package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.ArrayList;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;

import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class ReportFacialExpressionDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	private ArrayList<String> possibleAnswers = new ArrayList<String>();
	private int userAnswer = -1;

	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
//	public ReportFacialExpressionDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
	public ReportFacialExpressionDialogBox(final EventBus eventBus, final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession, final ExperimentConditions experimentConditions) {
	
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML(constants.blank());
			
		final FlexTable flexTable = new FlexTable();
		flexTable.setSize("650px", "430px");
//		flexTable.setSize("780px", "430px");
//		setWidget(flexTable);
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");
		
		HTML report = new HTML("");
		report.setHTML(constants.reportFacialExpressionHTML());

		flexTable.setWidget(0, 0, report);
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 5);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
/*		HTML playerName = new HTML("");
		playerName.setHTML(constants.playerNameHTML());
		flexTable.setWidget(1, 0, playerName);
		flexTable.getFlexCellFormatter().setColSpan(1, 0, 5);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);

		Image selectedImage = new Image();
		selectedImage.setUrl("http://shiraz.usc.edu/negotiation/images/neutral.gif");
		flexTable.setWidget(2, 0, selectedImage);
		flexTable.getFlexCellFormatter().setColSpan(2, 0, 5);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);*/
		
		Image happy = new Image();
		happy.setUrl("http://shiraz.usc.edu/negotiation/images/happy.gif");
		happy.setWidth("80px");
		flexTable.setWidget(3, 0, happy);

		Image content = new Image();
		content.setUrl("http://shiraz.usc.edu/negotiation/images/content.gif");
		content.setWidth("80px");
		flexTable.setWidget(3, 1, content);

		Image neutral = new Image();
		neutral.setUrl("http://shiraz.usc.edu/negotiation/images/neutral.gif");
		neutral.setWidth("80px");
		flexTable.setWidget(3, 2, neutral);

		Image angry = new Image();
		angry.setUrl("http://shiraz.usc.edu/negotiation/images/angry.gif");
		angry.setWidth("80px");		
		flexTable.setWidget(3, 3, angry);

		Image sad = new Image();
		sad.setUrl("http://shiraz.usc.edu/negotiation/images/sad.gif");
		sad.setWidth("80px");
		flexTable.setWidget(3, 4, sad);
		
		flexTable.setWidget(4, 0, new HTML(constants.happyHTML()));
		flexTable.setWidget(4, 1, new HTML(constants.contentHTML()));
		flexTable.setWidget(4, 2, new HTML(constants.neutralHTML()));
		flexTable.setWidget(4, 3, new HTML(constants.angryHTML()));
		flexTable.setWidget(4, 4, new HTML(constants.sadHTML()));
		
/*		possibleAnswers.add(new String(" Happy"));
		possibleAnswers.add(new String(" Content"));
		possibleAnswers.add(new String(" Neutral"));
		possibleAnswers.add(new String(" Angry"));
		possibleAnswers.add(new String(" Sad"));*/
		final int partnerLabel = experimentConditions.getPartnerLabel();
		
		for (int i=0; i<5; i++) {
			flexTable.getFlexCellFormatter().setHeight(3, i, "170px");
			flexTable.getFlexCellFormatter().setHorizontalAlignment(3, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.getFlexCellFormatter().setHorizontalAlignment(4, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.getFlexCellFormatter().setHorizontalAlignment(5, i, HasHorizontalAlignment.ALIGN_CENTER);
//			final RadioButton radioButton = new RadioButton("Q", possibleAnswers.get(i));
			final RadioButton radioButton = new RadioButton("Q");
			radioButton.setTabIndex(i);
			flexTable.setWidget(5, i, radioButton);
			
			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer = radioButton.getTabIndex();
					for (int i=0; i<5; i++) {
						flexTable.getCellFormatter().setStyleName(3, i, "FlexTable-OddRow");
						flexTable.getCellFormatter().setStyleName(4, i, "FlexTable-OddRow");
						flexTable.getCellFormatter().setStyleName(5, i, "FlexTable-OddRow");
					}
					flexTable.getCellFormatter().setStyleName(3, radioButton.getTabIndex(), "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(4, radioButton.getTabIndex(), "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(5, radioButton.getTabIndex(), "FlexTable-SelectedCell");
					
//			  		Button btnSubmit = new Button(constants.ok_button());
//			  		btnSubmit.setSize("250px", "33px");			  		
					final Button btnSubmit = new Button(constants.ok_button());
					btnSubmit.setSize("200px", "50px");
					btnSubmit.setStylePrimaryName("MiddleButton-style");


			  		
					btnSubmit.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							// EK0707: should be reportSelfEmotion
							final double timestampReportSelfEmotion = Duration.currentTimeMillis();
							final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampReportSelfEmotion, TradingActionEnum.reportSelfEmotion, null);
							eventBus.fireEvent(new ReportSelfEmotionEvent(newTradingAction));
							
							String userAnswerEmotion = "";
							if(userAnswer == 0)
								userAnswerEmotion = "Happy";
							else if(userAnswer == 1)
								userAnswerEmotion = "Content";
							else if(userAnswer == 2)
								userAnswerEmotion = "Neutral";
							else if(userAnswer == 3)
								userAnswerEmotion = "Angry";
							else if(userAnswer == 4)
								userAnswerEmotion = "Sad";
							
							int plyRemaining = negotiationSession.getPlyRemaining();
							if(plyRemaining == 59) //28)
								experimentConditions.setSelfReportedEmotion_1(userAnswerEmotion);
							else if(plyRemaining == 48) //23)
								experimentConditions.setSelfReportedEmotion_2(userAnswerEmotion);
							else if(plyRemaining == 37) //18)
								experimentConditions.setSelfReportedEmotion_3(userAnswerEmotion);
							else if(plyRemaining == 26) //13)
								experimentConditions.setSelfReportedEmotion_4(userAnswerEmotion);
							else if(plyRemaining == 15) //8)
								experimentConditions.setSelfReportedEmotion_5(userAnswerEmotion);
							else if(plyRemaining == 4) //3)
								experimentConditions.setSelfReportedEmotion_6(userAnswerEmotion);
							
							final OfferAcceptanceStartDialogBox dialogBoxOfferAcceptanceStart = new OfferAcceptanceStartDialogBox(eventBus, partnerLabel);
					    	  dialogBoxOfferAcceptanceStart.setPopupPosition(105, 75);
					    	  dialogBoxOfferAcceptanceStart.show();
					    	  
					    	  Timer timer1 = new Timer() {
					    		  public void run() {
									  // EK0707: should be decidingOfferAcceptance
									  final double timestampDecidingOfferAcceptance = Duration.currentTimeMillis();
									  final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestampDecidingOfferAcceptance, TradingActionEnum.decidingOfferAcceptance, null);
									  eventBus.fireEvent(new DecidingOfferAcceptanceEvent(newTradingAction));
					    			  
							      	  final OfferAcceptanceDialogBox dialogBoxOfferAcceptance = new OfferAcceptanceDialogBox(eventBus, newTradingBoardState, negotiationSession, experimentConditions);
							      	  dialogBoxOfferAcceptance.setPopupPosition(105, 75);
							      	  dialogBoxOfferAcceptanceStart.hide();
							      	  dialogBoxOfferAcceptance.show();  
					    		  }
					    	  };
					    	  timer1.schedule(10000); 						// 10 sec delay for reviewing*/
							
//							final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
//					    	dialogBox.setPopupPosition(105, 75);
//					    	dialogBox.show();

							hide();
							}
						});
//					flexTable.setWidget(2, 0, btnSubmit);
					absolutePanel.add(btnSubmit, 300, 470);


				}
			});
		}
		

		


/*		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{FacialExpressionEnum.happy, FacialExpressionEnum.content, FacialExpressionEnum.neutral, FacialExpressionEnum.angry, FacialExpressionEnum.sad};
		final FacialExpressionEnum originalSelection = FacialExpressionEnum.neutral;
		final AgentEmotionSelectionWidget playerEmotionSelection;

		playerEmotionSelection = new AgentEmotionSelectionWidget(eventBus, FacialExpressionStyleEnum.drama_masks, desiredImagePresentationOrder, originalSelection);

		flexTable.setWidget(1, 0, playerEmotionSelection);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);*/
				
//		Image loadingImage = new Image();
//		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
//		absolutePanel.add(loadingImage, 390, 470);
//		flexTable.setWidget(2, 0, loadingImage); // image
//		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		absolutePanel.add(flexTable, 75, 10);
//		absolutePanel.add(flexTable, 10, 10);
/*		final int partnerLabel = experimentConditions.getPartnerLabel();

		Timer timer = new Timer() {
		      public void run() {
		  		Button btnSubmit = new Button(constants.ok_button());
		  		btnSubmit.setSize("250px", "33px");

		  		
				btnSubmit.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						final OfferAcceptanceStartDialogBox dialogBoxOfferAcceptanceStart = new OfferAcceptanceStartDialogBox(eventBus, partnerLabel);
				    	  dialogBoxOfferAcceptanceStart.setPopupPosition(105, 75);
				    	  dialogBoxOfferAcceptanceStart.show();
				    	  
				    	  Timer timer1 = new Timer() {
				    		  public void run() {
						      	  final OfferAcceptanceDialogBox dialogBoxOfferAcceptance = new OfferAcceptanceDialogBox(eventBus, newTradingBoardState, negotiationSession, experimentConditions);
						      	  dialogBoxOfferAcceptance.setPopupPosition(105, 75);
						      	  dialogBoxOfferAcceptanceStart.hide();
						      	  dialogBoxOfferAcceptance.show();  
				    		  }
				    	  };
				    	  timer1.schedule(10000); 						// 10 sec delay for reviewing
						
//						final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
//				    	dialogBox.setPopupPosition(105, 75);
//				    	dialogBox.show();

						hide();
						}
					});
				flexTable.setWidget(2, 0, btnSubmit);
				absolutePanel.add(btnSubmit, 275, 470);
		      }
		};
		
		timer.schedule(5000);*/
	}
	
	protected void beginDragging(MouseDownEvent e)
	{
		e.preventDefault();
	}

}
	

