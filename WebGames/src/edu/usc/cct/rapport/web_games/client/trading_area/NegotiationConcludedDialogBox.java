package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class NegotiationConcludedDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
//	public NegotiationConcludedDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
	public NegotiationConcludedDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions, final NegotiationSession negotiationSession) {


		super(false, true);
		this.setHTML(constants.blank());
		
//		if (negotiationSession.getPlyRemaining() == 0) {	
//			String titleDiscription = constants.help_Window_Title();
//			this.setText(titleDiscription);
//			final FlowPanel flowPanelDialogBoxContents = new FlowPanel();
			final FlexTable flexTableDialogBoxContents = new FlexTable();
//			flexTableDialogBoxContents.setSize("750px", "500px");
			flexTableDialogBoxContents.setSize("800px", "565px");
//			flowPanelDialogBoxContents.setSize("300px", "200px");
			
/*			final TextArea dialogBoxTextArea = new TextArea();
			dialogBoxTextArea.setCharacterWidth(50);
			dialogBoxTextArea.setVisibleLines(5);
	
			String endOfNegotiation = constants.end_of_Negotiation_text();
			final StringBuilder builder = new StringBuilder();
			builder.append(endOfNegotiation);
			final String result = builder.toString();
			
			dialogBoxTextArea.setText(result);
			flowPanelDialogBoxContents.add(dialogBoxTextArea);//*/
			
			Label endOfNegotiation = new Label(constants.end_of_Negotiation_text());
			
			endOfNegotiation.setStylePrimaryName("BigLabel-style");
			flexTableDialogBoxContents.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
			flexTableDialogBoxContents.setWidget(0, 0, endOfNegotiation);

	
			String okButtonString = constants.ok_button();
			final Button okButton = new Button(okButtonString);
			okButton.setSize("200px", "50px");
			okButton.setStylePrimaryName("MiddleButton-style");
			
			okButton.addClickHandler(new ClickHandler() {
				public void onClick(final ClickEvent event) {
					final AnthropomorphismQuestionnaireDialogBox dialogBox = new AnthropomorphismQuestionnaireDialogBox(eventBus, experimentConditions, negotiationSession.getPlyRemaining());
//					final PartnerLabelCheckQuestionnaireDialogBox dialogBox = new PartnerLabelCheckQuestionnaireDialogBox(eventBus, experimentConditions, negotiationSession.getPlyRemaining());
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
	//				final ValueOfExpressionQuestionnaire1DialogBox dialogBox = new ValueOfExpressionQuestionnaire1DialogBox (eventBus, experimentConditions);
	//				final DemographicsDialogBox dialogBox = new DemographicsDialogBox (eventBus, experimentConditions); // To ease testing
	//				final NSAprinciplesQuestionnaire1DialogBox dialogBox = new NSAprinciplesQuestionnaire1DialogBox(eventBus, experimentConditions);
	//				final ValueOfExpressionQuestionnaireDialogBox dialogBox = new ValueOfExpressionQuestionnaireDialogBox (eventBus, experimentConditions);
	//				final PostGameQuestionnaireDialogBox dialogBox = new PostGameQuestionnaireDialogBox (eventBus, experimentConditions);
	//				final CommentDialogBox dialogBox = new CommentDialogBox (eventBus, experimentConditions);
	//				dialogBox.center();
					okButton.setEnabled(false);
					hide();
/*					eventBus.fireEvent(new LogExperimentInformationEvent());
					eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
					
					Timer timer = new Timer() {
						public void run() {
							hide();
					    }
					};
					timer.schedule(1000);*/
				
				}
/*				Timer timer = new Timer() {
				      public void run() {
				    	  //Window.open("https://usc.qualtrics.com/SE/?SID=SV_8w6VIY1oPigrrZq", "_blank", "");
				    	 // Window.open("https://atrial.qualtrics.com/SE/?SID=SV_bIzNEcOFu7OYMVn", "_blank", "");
				    	  eventBus.fireEvent(new LogExperimentInformationEvent());
				    	  eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	
				    	 // eventBus.fireEvent(new LogExperimentInformationEvent());
				      }
				    };
				    timer.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec;
*/			});
			
			flexTableDialogBoxContents.setWidget(1, 0, okButton);
			flexTableDialogBoxContents.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
//			flowPanelDialogBoxContents.add(okButton);
/*					Image loadingImage = new Image();
					loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
					flowPanelDialogBoxContents.add(loadingImage); // image
*/
//			this.setWidget(flowPanelDialogBoxContents);
			this.setWidget(flexTableDialogBoxContents);
/*		} else { // if the game didn't reach the last round
			eventBus.fireEvent(new LogExperimentInformationEvent());
		}*/
		
	};

	protected void beginDragging(MouseDownEvent e)
	{
		e.preventDefault();
	}

};
