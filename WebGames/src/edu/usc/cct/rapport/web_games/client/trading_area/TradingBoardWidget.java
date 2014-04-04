package edu.usc.cct.rapport.web_games.client.trading_area;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class TradingBoardWidget extends Composite implements HasEnabled {

	static final private String grid1x1CellStyleName = "ict-rapport-grid-1x1-cell";
	static final private String grid2x2StyleName = "ict-rapport-grid-2x2";
	static final private String grid4x3StyleName = "ict-rapport-grid-4x3";
	static final private String grid4x3CellStyleName = "ict-rapport-grid-4x3-cell";

	static final private int agentAreasOnTradingBoard = TradingBoardState.agentAreasOnTradingBoard;
//	static final private int distinctTradingObjectsCount = TradingBoardState.distinctTradingObjectsCount;
	static final private int itemsPerTradingObjectCategoryCount = TradingBoardState.itemsPerTradingObjectCategoryCount;

	static final private int itemsAcrossPerTradingObjectCategoryCount = TradingBoardState.itemsAcrossPerTradingObjectCategoryCount;
	static final private int itemsUpDownPerTradingObjectCategoryCount = TradingBoardState.itemsUpDownPerTradingObjectCategoryCount;
	static final private int outerColumnsAcross = TradingBoardState.outerColumnsAcross;
	static final private int outerRowsUpDown = TradingBoardState.outerRowsUpDown;

//	static final private int imageWidthInPixels = 45;
	static final private int imageWidthInPixels = 63;
	static final private int imageHeightInPixels = 49;

	final private EventBus eventBus;
	final private AbsolutePanel absolutePanelDragAndDropArea;

	boolean dropped;
	private boolean enabled;
	private PickupDragController pickupDragController;
	private TradingBoardState tradingBoardState;
	private FlexTable grid4x3;
	private SimplePanel[][] innerGridSimplePanels;


	public TradingBoardWidget(final EventBus eventBus, final TradingBoardState tradingBoardState) {

		assert (itemsAcrossPerTradingObjectCategoryCount * itemsUpDownPerTradingObjectCategoryCount >= itemsPerTradingObjectCategoryCount);

		this.eventBus = eventBus;

		this.absolutePanelDragAndDropArea = new AbsolutePanel();
		initWidget(this.absolutePanelDragAndDropArea);
//		this.absolutePanelDragAndDropArea.setPixelSize(461, 376); // when there are 3 items each
		this.absolutePanelDragAndDropArea.setPixelSize(461, 564);

		this.enabled = false;
		this.tradingBoardState = tradingBoardState;
	    this.grid4x3 = generateTradingBoard(tradingBoardState);

	    this.absolutePanelDragAndDropArea.add(grid4x3);
	    this.dropped =  false;
	};


	@Override
	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	};


	@Override
	public boolean isEnabled() {
		return enabled;
	};


	@Override
	public void onBrowserEvent(final Event event) {
		if (enabled) {
			super.onBrowserEvent(event);
		};
	};


	private FlexTable generateTradingBoard(final TradingBoardState tradingBoardState) {

		final FlexTable result = new FlexTable();
		result.addStyleName(grid4x3StyleName);

		pickupDragController = new PickupDragController(absolutePanelDragAndDropArea, false);
	    pickupDragController.setBehaviorMultipleSelection(true);
	    pickupDragController.setBehaviorConstrainedToBoundaryPanel(true);
	    pickupDragController.setConstrainWidgetToBoundaryPanel(true);
	    innerGridSimplePanels = new SimplePanel[outerRowsUpDown][outerColumnsAcross];
	    for (int row = 0; row != outerRowsUpDown; ++row) {
    		innerGridSimplePanels[row] = new SimplePanel[outerColumnsAcross];
    		for (int col = 0; col != outerColumnsAcross; ++col) {
		    	final SimplePanel gridCellPanel = new SimplePanel();
//		    	pickupDragController.makeNotDraggable(gridCellPanel);
				gridCellPanel.addStyleName(grid1x1CellStyleName);
				gridCellPanel.setPixelSize(imageWidthInPixels, imageHeightInPixels);
		    	innerGridSimplePanels[row][col] = gridCellPanel;
	    	};
	    };

		final int[][] tradingObjectAllocations = tradingBoardState.getTradingObjectAllocationsAsArray();

		final int distinctTradingObjectsCount = tradingBoardState.getTradingObjectSetEnum().getSetOfTradingObjectEnum().size();

//		pickupDragController.makeNotDraggable(this.grid4x3);
		for (int outerColumn = 0; outerColumn != distinctTradingObjectsCount; ++outerColumn) {
			final TradingObjectEnum tradingObjectEnum = tradingBoardState.getTradingObjectEnumByIndex(outerColumn);
			for (int outerRow = 0; outerRow != agentAreasOnTradingBoard; ++outerRow) {
				final FlexTable grid2x2 = new FlexTable();
//				pickupDragController.makeNotDraggable(grid2x2);
				grid2x2.addStyleName(grid2x2StyleName);
				final int tradingObjectsInCurrentSpot = tradingObjectAllocations[outerRow][outerColumn];
				for (int col = 0; col != itemsAcrossPerTradingObjectCategoryCount; ++col) {
					for (int row = 0; row != itemsUpDownPerTradingObjectCategoryCount; ++row) {
						final SimplePanel gridCellPanel = innerGridSimplePanels[outerRow*itemsUpDownPerTradingObjectCategoryCount + row][outerColumn*itemsAcrossPerTradingObjectCategoryCount + col];
						encodeAgentAndTradingObjectInWidgetId(gridCellPanel, outerRow, tradingObjectEnum);
						final int nthOfThisDistinctTradingObject = row * itemsAcrossPerTradingObjectCategoryCount + col + 1;
						if (tradingObjectsInCurrentSpot >= nthOfThisDistinctTradingObject) {
							final Image imageForTrade = tradingObjectEnum.getImage();
							encodeAgentAndTradingObjectInWidgetId(imageForTrade, outerRow, tradingObjectEnum);
							pickupDragController.makeDraggable(imageForTrade);
							gridCellPanel.add(imageForTrade);
						};
						grid2x2.setWidget(row, col, gridCellPanel);
				        final TradingBoardDropController dropController = new TradingBoardDropController(this, gridCellPanel);
				        pickupDragController.registerDropController(dropController);
					};
				};
				result.setWidget(outerRow, outerColumn, grid2x2);
				result.getCellFormatter().setStyleName(outerRow, outerColumn, grid4x3CellStyleName);
			};
		};

		return result;
	};


	private void encodeAgentAndTradingObjectInWidgetId(final Widget widget, final int agentIndex, final TradingObjectEnum tradingObjectEnum) {
		final String id = agentIndex + "|" + tradingObjectEnum.name();
		widget.getElement().setId(id);
	};


	Pair<AgentEnum, TradingObjectEnum> decodeAgentAndTradingObjectFromWidgetId(final Widget widget) {
		final String[] idEncodedInfo = widget.getElement().getId().split("\\|");
		final AgentEnum agentEnum = AgentEnum.getFromTradingBoardRowIndex(Integer.parseInt(idEncodedInfo[0]));
		final String tradingObjectEnumName = idEncodedInfo[1];
		final TradingObjectEnum tradingObjectEnum = Enum.valueOf(TradingObjectEnum.class, tradingObjectEnumName);

		final Pair<AgentEnum, TradingObjectEnum> result = new Pair<AgentEnum, TradingObjectEnum>(agentEnum, tradingObjectEnum);
		return result;
	};


	public TradingBoardState getState() {
		return tradingBoardState;
	};


	public void setState(final TradingBoardState tradingBoardState) {
		// It's not safe to fail to redraw the board if the board state is unchanged, because the user may drag an item elsewhere within the same box.
		this.tradingBoardState = tradingBoardState;
		this.eventBus.fireEvent(new TradingBoardStateChangedEvent());
	};


	public void updateTradingBoardAfterTradingBoardStateChange() {
		this.grid4x3 = generateTradingBoard(this.tradingBoardState);
		this.absolutePanelDragAndDropArea.clear();
		this.absolutePanelDragAndDropArea.add(grid4x3);
	};


	public boolean representsValidProposal() {
		final boolean result = tradingBoardState.representsValidProposal();
		return result;
	};

};
