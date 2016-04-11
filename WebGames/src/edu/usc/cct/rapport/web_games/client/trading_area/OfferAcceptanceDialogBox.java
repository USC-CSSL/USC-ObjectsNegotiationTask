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

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class OfferAcceptanceDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	private SimplePanel[][] innerGridSimplePanels;
	
//	public OfferAcceptanceDialogBox(final EventBus eventBus, final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession) {
	public OfferAcceptanceDialogBox(final EventBus eventBus, final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;

//		setHTML(constants.reviewingOffer());
		setHTML(constants.blank());
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("800px", "565px");
		
		Label lblAcceptance = new Label(constants.offerAcceptance_msg());
		
/*		if(negotiationSession.getPlyRemaining() < 3) {
			lblAcceptance = new Label(constants.last_round());
		}*/

/*		lblAcceptance.setStylePrimaryName("BigLabel-style");
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(0, 0, lblAcceptance);*/
		
		
		
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
		final Button btnAccept = new Button(constants.accept());
		btnAccept.setSize("200px", "50px");
		btnAccept.setStylePrimaryName("MiddleButton-style");
//		flexTable.setWidget(2, 0, btnAccept);
		flexTable.setWidget(1, 0, btnAccept);
		
		// Reject button
		final Button btnReject = new Button(constants.reject());
		btnReject.setSize("200px", "50px");
		btnReject.setStylePrimaryName("MiddleButton-style");

/*		// TossCoin button
		final Button btnTossCoin = new Button(constants.tossCoin());		
		btnTossCoin.setSize("200px", "50px");
		btnTossCoin.setStylePrimaryName("MiddleButton-style");

		if(negotiationSession.getPlyRemaining() < 5) {
			flexTable.setWidget(1, 1, btnTossCoin);
		} else {
			flexTable.setWidget(1, 1, btnReject);
		}*/
		flexTable.setWidget(1, 1, btnReject);

		btnAccept.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double timestamp = Duration.currentTimeMillis();
				btnAccept.setEnabled(false);
				btnReject.setEnabled(false);
//				btnTossCoin.setEnabled(false);
				final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.acceptProposal, null);
				eventBus.fireEvent(new ProposalAcceptedEvent(newTradingAction));
				
				Timer timer = new Timer() {
					public void run() {
						hide();
					}
				};
			    timer.schedule(1000); 		// 1sec delay  */
			}
		});
				
		btnReject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double timestamp = Duration.currentTimeMillis();
				if(negotiationSession.getPlyRemaining() < 6) {
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.claimBATNAValue, null);
					eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));							

					hide();	
				} else {
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.rejectProposal, null);
					eventBus.fireEvent(new ProposalRejectedEvent(newTradingAction));
	
					hide();	
	//				final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "waitAfterRejection");
					final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "waitAfterRejection", experimentConditions.getPartnerLabel());
					dialogBoxWait.setPopupPosition(105, 75);
					dialogBoxWait.show();
						
					Timer timer = new Timer() {
						public void run() {
							final double timestampEndWaiting = Duration.currentTimeMillis();
							final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampEndWaiting, TradingActionEnum.endWaiting, null);
							eventBus.fireEvent(new EndWaitingEvent(newTradingAction));
							dialogBoxWait.hide();
						}
					};
				    timer.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec   
				}
			}
		});
		
/*		btnTossCoin.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double timestamp = Duration.currentTimeMillis();
				final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.claimBATNAValue, null);
				eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));
				hide();
				
//				final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "coinTossing");
				final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "coinTossing", experimentConditions.getPartnerLabel());
				dialogBoxWait.setPopupPosition(105, 75);
				dialogBoxWait.show();
				
				Timer timer = new Timer() {
					public void run() {
						final double timestampEndWaiting = Duration.currentTimeMillis();
						final TradingAction newTradingAction_endWaiting = new TradingAction(AgentEnum.counterpart, timestampEndWaiting, TradingActionEnum.endWaiting, null);
						eventBus.fireEvent(new EndWaitingEvent(newTradingAction_endWaiting));
						
						
//						final TossCoinResultDialogBox dialogBoxTossCoin = new TossCoinResultDialogBox(eventBus);
						final TossCoinResultDialogBox dialogBoxTossCoin = new TossCoinResultDialogBox(eventBus, experimentConditions);
						dialogBoxTossCoin.setPopupPosition(105, 75);
						dialogBoxTossCoin.show();
						dialogBoxWait.hide();

						Timer timer1 = new Timer() {
							public void run() {
		
								final double timestamp = Duration.currentTimeMillis();
						    	final TradingAction newTradingAction_endCoinTossResultReview = new TradingAction(AgentEnum.counterpart, timestamp, TradingActionEnum.endCoinTossResultReview, null);
						    	eventBus.fireEvent(new EndCoinTossResultReviewEvent(newTradingAction_endCoinTossResultReview));
		
								Timer timer2 = new Timer() {
									public void run() {
										dialogBoxTossCoin.hide();
									}
								};
							    timer2.schedule(1000); 		// 1sec delay
							}
						};
					    timer1.schedule(5000); 		// 5sec delay			    
					}
				};
			    timer.schedule(3000); 		// 3sec delay: tossing a coin  

			}
		});*/

/*		// Reject button
		Button btnReject = new Button(constants.reject());
//		if(negotiationSession.getPlyRemaining() < 3) {
		if(negotiationSession.getPlyRemaining() < 5) {
			btnReject = new Button(constants.tossCoin());
		}

		
		btnReject.setSize("200px", "50px");
		btnReject.setStylePrimaryName("MiddleButton-style");
//		flexTable.setWidget(2, 1, btnReject);
		flexTable.setWidget(1, 1, btnReject);

		btnReject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				if(negotiationSession.getPlyRemaining() > 2) {
				if(negotiationSession.getPlyRemaining() > 4) {
					final double timestamp = Duration.currentTimeMillis();
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.rejectProposal, null);
					eventBus.fireEvent(new ProposalRejectedEvent(newTradingAction));
	
					hide();	
					final WaitingDialogBox dialogBoxWait = new WaitingDialogBox(eventBus, "waitAfterRejection");
					dialogBoxWait.setPopupPosition(105, 75);
					dialogBoxWait.show();
						
					Timer timer = new Timer() {
						public void run() {
							final double timestampEndWaiting = Duration.currentTimeMillis();
							final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampEndWaiting, TradingActionEnum.endWaiting, null);
							eventBus.fireEvent(new EndWaitingEvent(newTradingAction));

							dialogBoxWait.hide();
						}
					};
				    timer.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec   
				} else {
					final double timestamp = Duration.currentTimeMillis();
					final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.claimBATNAValue, null);
//					eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));
//					eventBus.fireEvent(new LogExperimentInformationEvent());
//					eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
					hide();	
					final TossCoinResultDialogBox dialogBoxTossCoin = new TossCoinResultDialogBox(eventBus);
					dialogBoxTossCoin.setPopupPosition(105, 75);
					dialogBoxTossCoin.show();
					
					Timer timer = new Timer() {
						public void run() {
							eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));
							dialogBoxTossCoin.hide();
						}
					};
				    timer.schedule(5000); 		// random delay between 5sec and 8sec   
				}
			}
		});*/
		
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_LEFT);
	}
}
	

