package edu.usc.cct.rapport.web_games.server.recording;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.usc.cct.rapport.web_games.client.WebGames;
import edu.usc.cct.rapport.web_games.client.recording.IExperimentInformationRecordingService;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.AllocationDS;
import edu.usc.cct.rapport.web_games.client.trading_area.ExperimentInformationDS;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSessionDS;
import edu.usc.cct.rapport.web_games.client.trading_area.PreGameQuestionnaireDialogBox;
import edu.usc.cct.rapport.web_games.client.trading_area.ProposalDS;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingActionDS;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingExpressionDS;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;


public class ExperimentInformationRecordingService extends RemoteServiceServlet implements IExperimentInformationRecordingService {

	static final public long serialVersionUID = 1L;

	static final private String headlessProperty = "java.awt.headless";
	static final private String excelFilePath = "/tomcat/webapps/";
	//static final private String excelFilePath = "";
	private String unisheetFilename = excelFilePath + WebGames.class.getSimpleName() + "-unisheet.xlsx";
	private String multisheetFilename =  excelFilePath + WebGames.class.getSimpleName() + "-multisheet.xlsx";
	private String csvforUnisheetFilename = excelFilePath + WebGames.class.getSimpleName() + "-unisheet.csv";
	private String csvforMultisheetFilename = excelFilePath + WebGames.class.getSimpleName() + "-multisheet.csv";
	//static final 
	static final private int maxActionPlyCount = 25;
	static final private int agentEnumCount = AgentEnum.values().length;
//	static final private int tradingObjectEnumCount = 4;
	static final private int tradingObjectEnumCount = 3; // Sasha's experiment
	static final private int allocationRepetitionCount = agentEnumCount * tradingObjectEnumCount;
	static final private int maxExpressionCount = 200;


	@Override
	synchronized public void recordFinalExperimentInformation(final ExperimentInformationDS finalExperimentInformation) {
		final Workbook multisheetExcelWorkbook = obtainExcelWorkbook(multisheetFilename,1);
		populateNewSheet(finalExperimentInformation, multisheetExcelWorkbook);
		recordExcelWorkbook(multisheetFilename, multisheetExcelWorkbook);
		
		//Timer timer = new Timer() {
		      //public void run() {
		    	final Workbook unisheetExcelWorkbook = obtainExcelWorkbook(unisheetFilename,0);
		  		appendToUnisheet(finalExperimentInformation, unisheetExcelWorkbook);
		  		recordExcelWorkbook(unisheetFilename, unisheetExcelWorkbook);
		     // }
		    //};
		   // timer.schedule(5432);
		
//		  		final String csvContents = obtainCSV(csvFilename);
//		  		appendToCSV(finalExperimentInformation, csvContents)
		  		recordCSV(csvforMultisheetFilename, multisheetExcelWorkbook,1);
		  		recordCSV(csvforUnisheetFilename, unisheetExcelWorkbook,0);
	};


	private void recordExcelWorkbook(final String filename, final Workbook updatedExcelWorkbook) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			updatedExcelWorkbook.write(fileOut);
			fileOut.close();
		} catch (final FileNotFoundException e) {
			final RuntimeException e2 = new RuntimeException(e);
			throw(e2);
		} catch (final IOException e) {
			final RuntimeException e2 = new RuntimeException(e);
			throw(e2);
		} catch (final SecurityException e) {
			final RuntimeException e2 = new RuntimeException(e);
			throw(e2);
		};
		
	};


	private Workbook obtainExcelWorkbook(final String filename, int uniOrMulti) {

		Workbook result;

		try {
			final FileInputStream excelSpreadsheetInputStream = new FileInputStream(filename);
			int i = excelSpreadsheetInputStream.available();
			if (i > 0) result = new XSSFWorkbook(excelSpreadsheetInputStream);
			else { 
					result = new XSSFWorkbook();
					final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmm");
					final String dateTime = dateTimeFormatter.format(new Date());
					
					if	(uniOrMulti==0) {
						unisheetFilename = excelFilePath + dateTime + WebGames.class.getSimpleName() + "-unisheet.xlsx";
						csvforUnisheetFilename = excelFilePath + dateTime + WebGames.class.getSimpleName() + "-unisheet.csv";
					}
					
					if	(uniOrMulti==1)	{
						multisheetFilename =  excelFilePath + dateTime + WebGames.class.getSimpleName() + "-multisheet.xlsx";			
						csvforMultisheetFilename =  excelFilePath + dateTime + WebGames.class.getSimpleName() + "-multisheet.csv";			
					}
			}
		} catch (final FileNotFoundException e) {
			// The spreadsheet hasn't yet been created, so we will create it now.
			result = new XSSFWorkbook();
		} catch (final IOException e) {
			// It's so important to not overwrite previously-collected data that we will choose to fail hard.
			//umm, maybe not so hard. try writing to a different file
			//result = new XSSFWorkbook();
			final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmm");
			final String dateTime = dateTimeFormatter.format(new Date());
			unisheetFilename 		 = excelFilePath + dateTime + WebGames.class.getSimpleName() + "-unisheet.xlsx";
			csvforUnisheetFilename 	 = excelFilePath + dateTime + WebGames.class.getSimpleName() + "-unisheet.csv";
			multisheetFilename 		 =  excelFilePath + dateTime + WebGames.class.getSimpleName() + "-multisheet.xlsx";
			csvforMultisheetFilename =  excelFilePath + dateTime + WebGames.class.getSimpleName() + "-multisheet.csv";			

			//e.printStackTrace();
			throw new RuntimeException(e);
			//result = 0;
		};

		return result;
	};
	
	private void recordCSV(final String filename, final Workbook updatedExcelWorkbook, int uniOrMulti) {

		StringBuffer data = new StringBuffer();

        try {
            FileOutputStream fos = new FileOutputStream(filename);
//            XSSFSheet sheet = (XSSFSheet) updatedExcelWorkbook.getSheetAt(0);
            XSSFWorkbook wb = (XSSFWorkbook) updatedExcelWorkbook;

            for(XSSFSheet sheet:wb) {
	            Row row;
	            Cell cell;
	
	            // Iterate through each rows from first sheet
	            Iterator<Row> rowIterator = sheet.iterator();
	
	            while (rowIterator.hasNext()) {
	                row = rowIterator.next();
	
	                // For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                while (cellIterator.hasNext()) {
	
	                    cell = cellIterator.next();
	
	                    switch (cell.getCellType()) {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            data.append(cell.getBooleanCellValue() + ",");
	
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:
	                            data.append(cell.getNumericCellValue() + ",");
	
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            data.append(cell.getStringCellValue() + ",");
	                            break;
	
	                        case Cell.CELL_TYPE_BLANK:
	                            data.append("" + ",");
	                            break;
	                        default:
	                            data.append(cell + ",");
	
	                    }
	                }
	                
	                if(uniOrMulti == 0) {
	                	data.append("\n");        
	                }
	            }
	            
            	data.append("\n");        
            }

            fos.write(data.toString().getBytes());
            fos.close();

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
	};


	private void appendToUnisheet(final ExperimentInformationDS finalExperimentInformation, final Workbook unisheetExcelWorkbook) {
		final Sheet mainSheet = obtainFirstSheet(unisheetExcelWorkbook);
		final int lastUsedRow = mainSheet.getLastRowNum();
		final Row rowToPopulate;
		if (0 == lastUsedRow) {

			// This is a brand new sheet, so we need to add the header information.

			final Row rowToPopulateWithHeaders = mainSheet.createRow(0);
			rowToPopulate = mainSheet.createRow(1);
			int cellColumnIndexToStartWritingIn = 0;
			cellColumnIndexToStartWritingIn = 1 + this.populateRowWithExperimentConditions(finalExperimentInformation.getExperimentConditions(), rowToPopulateWithHeaders, cellColumnIndexToStartWritingIn, false);
			cellColumnIndexToStartWritingIn = 1 + this.populateRowWithScalarInformation(finalExperimentInformation.getNegotiationSession(), rowToPopulateWithHeaders,  cellColumnIndexToStartWritingIn, false);
			cellColumnIndexToStartWritingIn = 1 + this.populateRowWithTradingActionHeaders(rowToPopulateWithHeaders, cellColumnIndexToStartWritingIn, maxActionPlyCount, agentEnumCount, tradingObjectEnumCount);
			cellColumnIndexToStartWritingIn = 1 + this.populateRowWithTradingExpressionHeaders(rowToPopulateWithHeaders, cellColumnIndexToStartWritingIn, maxExpressionCount);
		} else {
			rowToPopulate = mainSheet.createRow(1 + lastUsedRow);
		};

		int cellColumnIndexToStartWritingIn = 0;
		cellColumnIndexToStartWritingIn = 1 + this.populateRowWithExperimentConditions(finalExperimentInformation.getExperimentConditions(), rowToPopulate, cellColumnIndexToStartWritingIn, true);
		final NegotiationSessionDS negotiationSession = finalExperimentInformation.getNegotiationSession();
		cellColumnIndexToStartWritingIn = 1 + this.populateRowWithScalarInformation(negotiationSession, rowToPopulate, cellColumnIndexToStartWritingIn, true);

		final CellStyle dateCellStyle = getDateCellStyle(unisheetExcelWorkbook);

		final List<TradingActionDS> tradingActions = negotiationSession.getHistory();
		cellColumnIndexToStartWritingIn = 1 + populateRowWithTradingActionData(tradingActions, rowToPopulate, cellColumnIndexToStartWritingIn, dateCellStyle);

		final List<TradingExpressionDS> tradingExpressions = negotiationSession.getExpressionHistory();
		cellColumnIndexToStartWritingIn = 1 + populateRowWithTradingExpressionData(tradingExpressions, rowToPopulate, cellColumnIndexToStartWritingIn, dateCellStyle);

		autosizeSheetColumns(mainSheet, cellColumnIndexToStartWritingIn);
	};


	private CellStyle getDateCellStyle(final Workbook workbook) {

		final CreationHelper creationHelper = workbook.getCreationHelper();
		final CellStyle result = workbook.createCellStyle();
		result.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss.000"));

		return result;
	};


	private void autosizeSheetColumns(final Sheet sheet, final int leftmostColumnGuaranteedToBeEmpty) {

		final String originalHeadlessPropertyValue = System.setProperty(headlessProperty, Boolean.TRUE.toString());
		for (int i=0; i != leftmostColumnGuaranteedToBeEmpty; ++i) {
			sheet.autoSizeColumn(i);
		};
		if (null != originalHeadlessPropertyValue) {
			System.setProperty(headlessProperty, originalHeadlessPropertyValue);
		};
	};

	
	private void populateNewSheet(final ExperimentInformationDS experimentInformation, final Workbook multisheetExcelWorkbook) {
		final Sheet newSheet = obtainNewSheet(multisheetExcelWorkbook, true);
		final CellStyle dateCellStyle = getDateCellStyle(multisheetExcelWorkbook);
		final Pair<Integer, Integer> firstRowAndColumnThatAreGuaranteedToBeEmpty = populateEmptySheet(experimentInformation, newSheet, dateCellStyle);
		multisheetExcelWorkbook.setSheetOrder(newSheet.getSheetName(), 0);

		final int firstEmptyColumn = firstRowAndColumnThatAreGuaranteedToBeEmpty.getSecond();
		autosizeSheetColumns(newSheet, firstEmptyColumn);
	};


	private Sheet obtainNewSheet(final Workbook workbook, boolean useIPAddressAndDateTimeStampForSheetName) {

		final String sheetName;

		if (useIPAddressAndDateTimeStampForSheetName) {
			final String ipAddress = getThreadLocalRequest().getRemoteAddr();
			// Ideally, ISO 8601 format ("yyyy-MM-dd'T'HH:mm:ss") would be used, but the
			// combined length of this and the IP address exceeds Excel's limit.
			final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmm");
			final String dateTime = dateTimeFormatter.format(new Date());
			
			if(ipAddress.equals("0:0:0:0:0:0:0:1%0"))		// when testing on the local machine using IPv6
				sheetName = dateTime + ' ' + "127.0.0.1";	// set ipAddress = 127.0.0.1
			else
				sheetName = dateTime + ' ' + ipAddress;
		} else {
			sheetName = WebGames.class.getSimpleName();
		};

		final Sheet result = workbook.createSheet(sheetName);
		return result;
	};


	private Sheet obtainFirstSheet(final Workbook workbook) {

		final Sheet result;

		final int sheetCount = workbook.getNumberOfSheets();
		if (sheetCount < 1) {
			result = obtainNewSheet(workbook, false);
		} else {
			result = workbook.getSheetAt(0);
		};
		return result;
	};


	private Pair<Integer, Integer> populateEmptySheet(final ExperimentInformationDS experimentInformation, final Sheet emptySheet, final CellStyle dateCellStyle) {

		assert (null != experimentInformation);

		int cellRowIndex = 0;

		int leftmostColumnGuaranteedToBeEmpty = 0;

		final Row sheetHeaderRow = emptySheet.createRow(cellRowIndex++);
		int firstEmptyColumn = populateRowWithSheetHeaderInformation(sheetHeaderRow, 0, dateCellStyle);

		++cellRowIndex;

		final ExperimentConditions experimentConditions = experimentInformation.getExperimentConditions();
		final NegotiationSessionDS negotiationSession = experimentInformation.getNegotiationSession();

		final Row experimentConditionsHeaderRow = emptySheet.createRow(cellRowIndex++);
		firstEmptyColumn = populateRowWithExperimentConditions(experimentConditions, experimentConditionsHeaderRow, 0, false);
		if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;

		final Row experimentConditionsRow = emptySheet.createRow(cellRowIndex++);
		firstEmptyColumn = populateRowWithExperimentConditions(experimentConditions, experimentConditionsRow, 0, true);
		if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;

		++cellRowIndex;

		final Row negotiationSessionScalarHeaderRow = emptySheet.createRow(cellRowIndex++);
		firstEmptyColumn = populateRowWithScalarInformation(negotiationSession, negotiationSessionScalarHeaderRow, 0, false);
		if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;

		final Row negotiationSessionScalarRow = emptySheet.createRow(cellRowIndex++);
		firstEmptyColumn = populateRowWithScalarInformation(negotiationSession, negotiationSessionScalarRow, 0, true);
		if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;

		++cellRowIndex;

		final List<TradingActionDS> tradingActions = negotiationSession.getHistory();
		for (final TradingActionDS tradingAction: tradingActions) {
			final Row tradingActionRow = emptySheet.createRow(cellRowIndex++);
			firstEmptyColumn = populateRowWithTradingActionData(tradingAction, tradingActionRow, 0, dateCellStyle);
			if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;
		};

		++cellRowIndex;

		final List<TradingExpressionDS> tradingExpressions = negotiationSession.getExpressionHistory();
		for (final TradingExpressionDS tradingExpression: tradingExpressions) {
			final Row tradingExpressionRow = emptySheet.createRow(cellRowIndex++);
			firstEmptyColumn = populateRowWithTradingExpressionData(tradingExpression, tradingExpressionRow, 0, dateCellStyle);
			if (leftmostColumnGuaranteedToBeEmpty < firstEmptyColumn) leftmostColumnGuaranteedToBeEmpty = firstEmptyColumn;
		};

		final Pair<Integer, Integer> firstRowAndColumnGuaranteedToBeEmpty = new Pair<Integer, Integer>(cellRowIndex, leftmostColumnGuaranteedToBeEmpty);
		return firstRowAndColumnGuaranteedToBeEmpty;
	};


	private int populateRowWithExperimentConditions(final ExperimentConditions experimentConditions, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final boolean writeData) {

		assert (null != experimentConditions);

		int columnIndex = cellColumnIndexToStartWritingIn;

		final ArrayList<String> stringsToStore;
		if (writeData) {
			stringsToStore = experimentConditions.getObjectFieldData();
		} else {
			stringsToStore = experimentConditions.getObjectFieldHeaders();
		};

		final Iterator<String> iterator = stringsToStore.iterator();
		while (iterator.hasNext()) {
			final Cell cell = rowToPopulate.createCell(columnIndex, Cell.CELL_TYPE_STRING);
			cell.setCellValue(iterator.next());
			++columnIndex;
		};

		return columnIndex;
	};


	private int populateRowWithScalarInformation(final NegotiationSessionDS negotiationSession, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final boolean writeData) {

		assert (null != negotiationSession);

		int columnIndex = cellColumnIndexToStartWritingIn;

		final ArrayList<String> stringsToStore;
		if (writeData) {
			stringsToStore = negotiationSession.getObjectScalarFieldData();
		} else {
			stringsToStore = negotiationSession.getObjectScalarFieldHeaders();
		};

		final Iterator<String> iterator = stringsToStore.iterator();
		while (iterator.hasNext()) {
			final Cell cell = rowToPopulate.createCell(columnIndex, Cell.CELL_TYPE_STRING);
			cell.setCellValue(iterator.next());
			++columnIndex;
		};

		return columnIndex;
	};


	public int populateRowWithTradingActionHeaders(final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final int maxActionPlyCount, final int agentEnumCount, final int tradingObjectEnumCount) {

		int cellColumnIndex = cellColumnIndexToStartWritingIn;

		final Cell actionPlyCountCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		actionPlyCountCell.setCellValue("actionPlyCount");

		for (int j = 1; j != 1 + maxActionPlyCount; ++j) {

			final String fieldPrefix = "ta" + getIntegerFieldPrefix(j);
			final Cell timestampCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			timestampCell.setCellValue(fieldPrefix + "timestampAsNumber");
			final Cell timestampAsDateCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			timestampAsDateCell.setCellValue(fieldPrefix + "timestampAsDate");
			final Cell performingAgentCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			performingAgentCell.setCellValue(fieldPrefix + "performingAgent");
			final Cell tradingActionEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			tradingActionEnumCell.setCellValue(fieldPrefix + "tradingActionEnum");

			for (int i = 0; i != allocationRepetitionCount; ++i) {
				final Cell proposalAgentCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
				proposalAgentCell.setCellValue(fieldPrefix + "proposalAgent");
				final Cell tradingObjectEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
				tradingObjectEnumCell.setCellValue(fieldPrefix + "tradingObjectEnum");
				final Cell valueCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
				valueCell.setCellValue(fieldPrefix + "tradingAllocationCount");
			};
			//added
			final Cell utilCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			utilCell.setCellValue(fieldPrefix + "util");
		};

		return cellColumnIndex;
	};


	public int populateRowWithTradingActionData(final List<TradingActionDS> tradingActions, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final CellStyle dateCellStyle) {

		assert (null != tradingActions);

		final int actionPlyCount = tradingActions.size();

		int cellColumnIndex = cellColumnIndexToStartWritingIn;
		final Cell actionPlyCountCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		actionPlyCountCell.setCellValue(actionPlyCount);

		for (int j = 0; j != maxActionPlyCount; ++j) {
			if (j < actionPlyCount) {
				// When a proposal is not made, the proposal fields are not serialized.  We still need to advance the appropriate number of cells, regardless.
				populateRowWithTradingActionData(tradingActions.get(j), rowToPopulate, cellColumnIndex, dateCellStyle);
			};
			//cellColumnIndex += 4 + allocationRepetitionCount * 3;
			cellColumnIndex += 5 + allocationRepetitionCount * 3;
		};

		return cellColumnIndex;
	};


	public int populateRowWithTradingActionData(final TradingActionDS tradingAction, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final CellStyle dateCellStyle) {

		assert (null != tradingAction);
		int utility = 0;
		int cellColumnIndex = cellColumnIndexToStartWritingIn;

		final Cell timestampCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		timestampCell.setCellValue(tradingAction.getTimestamp());
		final Cell timestampAsDateCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		populateTimestampCellFormattedAsDate(timestampAsDateCell, tradingAction.getTimestamp(), dateCellStyle);
		final Cell performingAgentCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		performingAgentCell.setCellValue(tradingAction.getPerformingAgent().name());
		final Cell tradingActionEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		tradingActionEnumCell.setCellValue(tradingAction.getTradingActionEnum());

		final ProposalDS proposal = tradingAction.getProposal();
		if (null != proposal) {
			final ArrayList<AllocationDS> tradingObjectsAllocation = proposal.getTradingObjectsAllocation();
			for (final AllocationDS threeTuple: tradingObjectsAllocation) {
				final AgentEnum agentEnum = threeTuple.getAgentMakingProposal();
				final TradingObjectEnum tradingObjectEnum = threeTuple.getTradingObjectEnum();
				if (agentEnum.name()== "player"){
					utility = utility + (tradingObjectEnum.getPayoff(agentEnum) * threeTuple.getCount());
				}
				final Cell proposalAgentEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
				proposalAgentEnumCell.setCellValue(agentEnum.name());
				final Cell tradingObjectEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
				tradingObjectEnumCell.setCellValue(tradingObjectEnum.name());
				final Cell valueCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
				final Integer tradingAllocationCount = threeTuple.getCount();
				valueCell.setCellValue(tradingAllocationCount);
			};
			//added
			final Cell utilCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
			utilCell.setCellValue(utility);
		};

		return cellColumnIndex;
	};


	public int populateRowWithTradingExpressionHeaders(final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final int maxExpressionCount) {

		int cellColumnIndex = cellColumnIndexToStartWritingIn;

		final Cell actionPlyCountCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		actionPlyCountCell.setCellValue("expressionPlyCount");

		for (int j = 1; j != 1 + maxExpressionCount; ++j) {

			final String fieldPrefix = "fe" + getIntegerFieldPrefix(j);
			final Cell timestampCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			timestampCell.setCellValue(fieldPrefix + "timestampAsNumber");
			final Cell timestampAsDateCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			timestampAsDateCell.setCellValue(fieldPrefix + "timestampAsDate");
			final Cell performingAgentCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			performingAgentCell.setCellValue(fieldPrefix + "performingAgent");
			final Cell tradingActionEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
			tradingActionEnumCell.setCellValue(fieldPrefix + "facialExpressionEnum");
		};

		return cellColumnIndex;
	};


	public int populateRowWithTradingExpressionData(final List<TradingExpressionDS> tradingExpressions, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final CellStyle dateCellStyle) {

		assert (null != tradingExpressions);

		final int expressionCount = tradingExpressions.size();

		int cellColumnIndex = cellColumnIndexToStartWritingIn;
		final Cell expressionCountCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		expressionCountCell.setCellValue(maxExpressionCount);

		for (int j = 0; j != expressionCount; ++j) {
			cellColumnIndex = populateRowWithTradingExpressionData(tradingExpressions.get(j), rowToPopulate, cellColumnIndex, dateCellStyle);
		};

		return cellColumnIndex;
	};


	public int populateRowWithTradingExpressionData(final TradingExpressionDS tradingExpression, final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final CellStyle dateCellStyle) {

		assert (null != tradingExpression);

		int cellColumnIndex = cellColumnIndexToStartWritingIn;

		final Cell timestampCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		timestampCell.setCellValue(tradingExpression.getTimestamp());
		final Cell timestampAsDateCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		populateTimestampCellFormattedAsDate(timestampAsDateCell, tradingExpression.getTimestamp(), dateCellStyle);
		final Cell performingAgentCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		performingAgentCell.setCellValue(tradingExpression.getPerformingAgent().name());
		final Cell facialExpressionEnumCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		facialExpressionEnumCell.setCellValue(tradingExpression.getFacialExpressionEnum().name());

		return cellColumnIndex;
	};


	private String getIntegerFieldPrefix(int n) {

		assert (0 <= n);

		final String result;

		if ((0 <= n) && (n < 10)) {
			result = "00" + Integer.toString(n);
		} else if ((10 <= n) && (n < 100)) {
			result = "0" + Integer.toString(n);
		} else {
			result = Integer.toString(n);
		};

		return result;
	};


	public int populateRowWithSheetHeaderInformation(final Row rowToPopulate, final int cellColumnIndexToStartWritingIn, final CellStyle dateCellStyle) {

		int cellColumnIndex = cellColumnIndexToStartWritingIn;
		final double timestamp = System.currentTimeMillis();
		final Cell timestampCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		timestampCell.setCellValue(timestamp);
		final Cell timestampAsDateCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_NUMERIC);
		populateTimestampCellFormattedAsDate(timestampAsDateCell, timestamp, dateCellStyle);
		final Cell ipAddressCell = rowToPopulate.createCell(cellColumnIndex++, Cell.CELL_TYPE_STRING);
		ipAddressCell.setCellValue(this.getThreadLocalRequest().getRemoteAddr());

		return cellColumnIndex;
	};


	public void populateTimestampCellFormattedAsDate(final Cell timestampCell, final double javaTimestamp, final CellStyle dateCellStyle) {

		assert(null != timestampCell);

		final long javaTimestampRestoredToLong = (long)javaTimestamp;
		final Date javaDate = new Date(javaTimestampRestoredToLong);
		final double excelTimestamp = DateUtil.getExcelDate(javaDate);
		timestampCell.setCellValue(excelTimestamp);
		timestampCell.setCellStyle(dateCellStyle);
	};

};
