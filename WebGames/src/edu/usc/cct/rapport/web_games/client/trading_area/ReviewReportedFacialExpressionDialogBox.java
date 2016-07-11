package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Random;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class ReviewReportedFacialExpressionDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
//	public ReportFacialExpressionDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
//	public ReviewReportedFacialExpressionDialogBox(final EventBus eventBus, final String temp, final int partnerLabel, final TradingAction tradingAction, final int plyRemaining) {
	public ReviewReportedFacialExpressionDialogBox(final EventBus eventBus, final String temp, ExperimentConditions experimentConditions, final TradingAction tradingAction, final int plyRemaining) {
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML(constants.blank());
			
		final FlexTable flexTable = new FlexTable();
		flexTable.setSize("780px", "400px");
//		setWidget(flexTable);
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");
		
		HTML report = new HTML("");
		final int partnerLabel = experimentConditions.getPartnerLabel();
		if(partnerLabel == 0)
			report.setHTML(constants.reportComputerPartnersFacialExpressionHTML());
		else if(partnerLabel == 1)
			report.setHTML(constants.reportHumanPartnersFacialExpressionHTML());
		else
			report.setHTML(constants.reportPartnersFacialExpressionHTML());

		flexTable.setWidget(0, 0, report);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		Image selectedImage = new Image();
		HTML selectedImage_explanation = new HTML("");

		if (experimentConditions.getAgentSelfReportedEmotion().equals("everyOtherTurnAngry")) {
			if(plyRemaining==25 || plyRemaining==15 || plyRemaining==5) { // if round 2, 4, 6
				selectedImage.setUrl("http://shiraz.usc.edu/negotiation/images/angry1.gif");
				selectedImage_explanation.setHTML(constants.angryHTML());
			} else {	
				selectedImage.setUrl("http://shiraz.usc.edu/negotiation/images/neutral1.gif");
				selectedImage_explanation.setHTML(constants.neutralHTML());
			}
		} else {
			selectedImage.setUrl("http://shiraz.usc.edu/negotiation/images/neutral1.gif");
			selectedImage_explanation.setHTML(constants.neutralHTML());			
		}
		
		flexTable.setWidget(1, 0, selectedImage);
		flexTable.getFlexCellFormatter().setHeight(1, 0, "180px");
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);

		flexTable.setWidget(2, 0, selectedImage_explanation);
		flexTable.getFlexCellFormatter().setHeight(2, 0, "50px");
		flexTable.getFlexCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);

/*		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{FacialExpressionEnum.happy, FacialExpressionEnum.content, FacialExpressionEnum.neutral, FacialExpressionEnum.angry, FacialExpressionEnum.sad};
		final FacialExpressionEnum originalSelection = FacialExpressionEnum.neutral;
		final AgentEmotionSelectionWidget playerEmotionSelection;

		playerEmotionSelection = new AgentEmotionSelectionWidget(eventBus, FacialExpressionStyleEnum.drama_masks, desiredImagePresentationOrder, originalSelection);

		flexTable.setWidget(1, 0, playerEmotionSelection);
		final AgentEmotionExpressionWidget counterpartEmotionExpressionWidget;
		counterpartEmotionExpressionWidget = new AgentEmotionExpressionWidget(AgentEnum.counterpart, FacialExpressionEnum.neutral, FacialExpressionStyleEnum.drama_masks, 215);
		flexTable.setWidget(1, 0, counterpartEmotionExpressionWidget);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);*/
				
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		absolutePanel.add(loadingImage, 390, 470);
//		flexTable.setWidget(2, 0, loadingImage); // image
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		absolutePanel.add(flexTable, 10, 10);
//		final int partnerLabel = experimentConditions.getPartnerLabel();

		Timer timer = new Timer() {
		      public void run() {
				final Button btnSubmit = new Button(constants.ok_button());
				btnSubmit.setSize("200px", "50px");
				btnSubmit.setStylePrimaryName("MiddleButton-style");

//		  		Button btnSubmit = new Button(constants.ok_button());
//		  		btnSubmit.setSize("250px", "33px");

		  		
				btnSubmit.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						
						// EK0707: should be checkAgentsReportedEmotion
						final double timestampCheckAgentsReportedEmotion = Duration.currentTimeMillis();
						final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampCheckAgentsReportedEmotion, TradingActionEnum.checkAgentsReportedEmotion, null);
						eventBus.fireEvent(new CheckAgentsReportedEmotionEvent(newTradingAction));
						
						final WaitingDialogBox waitingDialogBox = new WaitingDialogBox (eventBus, "waitForCounterpart", partnerLabel);
						final ProposalResultDialogBox resultDialogBox = new ProposalResultDialogBox(temp, partnerLabel);
						final ProposalResultDelayDialogBox resultDelayDialogBox = new ProposalResultDelayDialogBox(temp, partnerLabel);
						
						Random random = new Random();
						final int rand = random.nextInt(5);
				//		final int rand = 0; // for testing
				
				
						Timer timer1 = new Timer() { // ek: added waiting msg
				//        @Override
							public void run() {
								Timer timer2 = new Timer() {
								      public void run() {
								    	  final double timestamp = Duration.currentTimeMillis();
								    	  tradingAction.setTimestamp(timestamp);
				
								    	  String acceptedStr = "accepted";
				//				    	  String rejectedStr = "rejected";
				
								    	  if(temp.equals(acceptedStr))
								    		  eventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
//											    		  TradingAreaView.this.eventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
				
											Timer timer3 = new Timer() {
											      public void run() {
//											    	  final double timestamp = Duration.currentTimeMillis();
//											    	  tradingAction.setTimestamp(timestamp);
											    	  
													// EK0707: should be showAgentsOfferAcceptanceResult
													final double timestampShowAgentsOfferAcceptanceResult = Duration.currentTimeMillis();
													final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampShowAgentsOfferAcceptanceResult, TradingActionEnum.showAgentsOfferAcceptanceResult, null);
													eventBus.fireEvent(new ShowAgentsOfferAcceptanceResultEvent(newTradingAction));
							
				//							    	  String acceptedStr = "accepted";
											    	  String rejectedStr = "rejected";
							
				//							    	  if(temp.equals(acceptedStr))
				//							    		  TradingAreaView.this.eventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
				//							    	  else if(temp.equals(rejectedStr))
											    	  if(temp.equals(rejectedStr)) {
											    			final OfferReviewStartDialogBox dialogBox = new OfferReviewStartDialogBox(eventBus, partnerLabel, tradingAction, plyRemaining);
											    			
											    			dialogBox.setPopupPosition(105, 75);
											    			dialogBox.show();		

											    	  }
											    		  //showOfferReviewStartDialogBox(partnerLabel, tradingAction, plyRemaining);
							//				    		  showOfferReviewStartDialogBox(partnerLabel, tradingAction);
							//				    		  TradingAreaView.this.eventBus.fireEvent(new ProposalMadeEvent(tradingAction));
											    	  
												      if(partnerLabel == 1 && rand == 0 && temp.equals(rejectedStr)) {
												    	  resultDelayDialogBox.hide();
												      }
				
												      resultDialogBox.hide();
											    	  }
											      };
											      
										      String rejectedStr = "rejected";
										      if(partnerLabel == 1 && rand == 0 && temp.equals(rejectedStr)) {
										    	  resultDelayDialogBox.setPopupPosition(105, 75);
										    	  resultDelayDialogBox.show();
										    	  timer3.schedule((int)(Math.random() * (18000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 18sec
										      } else {
										    	  timer3.schedule(1);
										      }
								      }
								};
				
								resultDialogBox.setPopupPosition(105, 75);
								resultDialogBox.show();
								
								// EK0707: should be endWaitingForAgentsOfferAcceptance
								final double timestampEndWaitingForAgentsOfferAcceptance = Duration.currentTimeMillis();
								final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampEndWaitingForAgentsOfferAcceptance, TradingActionEnum.endWaitingForAgentsOfferAcceptance, null);
								eventBus.fireEvent(new EndWaitingForAgentsOfferAcceptanceEvent(newTradingAction));
								
								String acceptedStr = "accepted";
								if(temp.equals(acceptedStr))
									timer2.schedule(5000);	// 5 sec delay for reading
								else 
									timer2.schedule((int)(Math.random() * (18000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 18sec
								waitingDialogBox.hide();
							}
						};
						waitingDialogBox.setPopupPosition(105, 75);
						waitingDialogBox.show(); // EK 10/27/2014: pop up the screen in the left uppermost area
						
						timer1.schedule((int)(Math.random() * (3000 - 2000 + 1) + 2000)); 		// random delay between 2sec and 3sec
	
						hide();
						}
					});
//				flexTable.setWidget(2, 0, btnSubmit);
				absolutePanel.add(btnSubmit, 300, 470);
		      }
		};
		
		timer.schedule(5000);
	}
	
	protected void beginDragging(MouseDownEvent e)
	{
		e.preventDefault();
	}
}
	

