package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class OfferAcceptanceDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	private SimplePanel[][] innerGridSimplePanels;
	
	public OfferAcceptanceDialogBox(final EventBus eventBus, final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession) {
		super(false, true);
		this.eventBus = eventBus;

		setHTML(constants.reviewingOffer());
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("800px", "565px");
		
		Label lblAcceptance = new Label(constants.offerAcceptance_msg());

		lblAcceptance.setStylePrimaryName("BigLabel-style");
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(0, 0, lblAcceptance);
		
		
		
/*		// Offer to be reviewed
		FlexTable offerFlexTable = new FlexTable();
		int itemsAcrossPerTradingObjectCategoryCount = TradingBoardState.itemsAcrossPerTradingObjectCategoryCount;
		int itemsUpDownPerTradingObjectCategoryCount = TradingBoardState.itemsUpDownPerTradingObjectCategoryCount;
		int outerColumnsAcross = TradingBoardState.outerColumnsAcross;
		int outerRowsUpDown = TradingBoardState.outerRowsUpDown;
		String grid1x1CellStyleName = "ict-rapport-grid-1x1-cell";
		int imageWidthInPixels = 63;
		int imageHeightInPixels = 49;
		int agentAreasOnTradingBoard = TradingBoardState.agentAreasOnTradingBoard;
		final int[][] tradingObjectAllocations = newTradingBoardState.getTradingObjectAllocationsAsArray();
		
	    innerGridSimplePanels = new SimplePanel[outerRowsUpDown][outerColumnsAcross];
	    for (int row = 0; row != outerRowsUpDown; ++row) {
    		innerGridSimplePanels[row] = new SimplePanel[outerColumnsAcross];
    		for (int col = 0; col != outerColumnsAcross; ++col) {
		    	final SimplePanel gridCellPanel = new SimplePanel();
				gridCellPanel.addStyleName(grid1x1CellStyleName);
				gridCellPanel.setPixelSize(imageWidthInPixels, imageHeightInPixels);
		    	innerGridSimplePanels[row][col] = gridCellPanel;
	    	};
	    };

		for (int outerColumn = 0; outerColumn != newTradingBoardState.getTradingObjectSetEnum().getSetOfTradingObjectEnum().size(); ++outerColumn) {
			final TradingObjectEnum tradingObjectEnum = newTradingBoardState.getTradingObjectEnumByIndex(outerColumn);
			int outerRow = agentAreasOnTradingBoard-1;
//			for (int outerRow = 0; outerRow != agentAreasOnTradingBoard; ++outerRow) {
				final FlexTable grid2x2 = new FlexTable();
				final int tradingObjectsInCurrentSpot = tradingObjectAllocations[outerRow][outerColumn];

				for (int col = 0; col != TradingBoardState.itemsAcrossPerTradingObjectCategoryCount; ++col) {
					for (int row = 0; row != TradingBoardState.itemsUpDownPerTradingObjectCategoryCount; ++row) {
						final SimplePanel gridCellPanel = innerGridSimplePanels[outerRow*itemsUpDownPerTradingObjectCategoryCount + row][outerColumn*itemsAcrossPerTradingObjectCategoryCount + col];
						final int nthOfThisDistinctTradingObject = row * itemsAcrossPerTradingObjectCategoryCount + col + 1;
						if (tradingObjectsInCurrentSpot >= nthOfThisDistinctTradingObject) {
							final Image imageForTrade = tradingObjectEnum.getImage();
							gridCellPanel.add(imageForTrade);
						};
						grid2x2.setWidget(row, col, gridCellPanel);
					};
//				};
//				flexTable.setWidget(1, outerColumn, grid2x2);
//				flexTable.getCellFormatter().setStyleName(1, outerColumn, "ict-rapport-grid-2x2");
				offerFlexTable.setWidget(0, outerColumn, grid2x2);
				offerFlexTable.getCellFormatter().setStyleName(0, outerColumn, "ict-rapport-grid-2x2");
			}
		}
		
		flexTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(1, 0, offerFlexTable);*/
		
		

		// Accept button
		Button btnAccept = new Button(constants.accept());
		btnAccept.setSize("200px", "50px");
		btnAccept.setStylePrimaryName("MiddleButton-style");
//		flexTable.setWidget(2, 0, btnAccept);
		flexTable.setWidget(1, 0, btnAccept);

		btnAccept.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double timestamp = Duration.currentTimeMillis();
				final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.acceptProposal, null);
				eventBus.fireEvent(new ProposalAcceptedEvent(newTradingAction));
				hide();
			}
		});
		
		// Reject button
		Button btnReject = new Button(constants.reject());
		btnReject.setSize("200px", "50px");
		btnReject.setStylePrimaryName("MiddleButton-style");
//		flexTable.setWidget(2, 1, btnReject);
		flexTable.setWidget(1, 1, btnReject);

		btnReject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(negotiationSession.getPlyRemaining()>2) {
					final double timestamp = Duration.currentTimeMillis();
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.rejectProposal, null);
					eventBus.fireEvent(new ProposalRejectedEvent(newTradingAction));
	
					hide();	
					final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "waitAfterRejection");
					dialogBoxWait.setPopupPosition(0, 0);
					dialogBoxWait.show();
						
					Timer timer = new Timer() {
						public void run() {
							dialogBoxWait.hide();
						}
					};
				    timer.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec   */
				} else {
					final double timestamp = Duration.currentTimeMillis();
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.rejectProposal, null);
					eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));
//					eventBus.fireEvent(new LogExperimentInformationEvent());
//					eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
					hide();	
				}
			}
		});
		
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_LEFT);
	}
}
	

