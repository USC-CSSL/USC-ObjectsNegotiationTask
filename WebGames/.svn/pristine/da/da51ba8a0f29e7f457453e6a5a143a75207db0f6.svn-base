package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class NegotiationConcludedDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	public NegotiationConcludedDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {

		super(false, true);
		String titleDiscription = constants.help_Window_Title();
		this.setText(titleDiscription);
		final FlowPanel flowPanelDialogBoxContents = new FlowPanel();
		
		final TextArea dialogBoxTextArea = new TextArea();
		dialogBoxTextArea.setCharacterWidth(50);
		dialogBoxTextArea.setVisibleLines(5);

		String endOfNegotiation = constants.end_of_Negotiation_text();
		final StringBuilder builder = new StringBuilder();
		builder.append(endOfNegotiation);
		final String result = builder.toString();
		
		dialogBoxTextArea.setText(result);
		flowPanelDialogBoxContents.add(dialogBoxTextArea);

		String okButtonString = constants.ok_button();
		Button okButton = new Button(okButtonString);
		
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				hide();
				final ValueOfExpressionQuestionnaire1DialogBox dialogBox = new ValueOfExpressionQuestionnaire1DialogBox (eventBus, experimentConditions);
//				final ValueOfExpressionQuestionnaireDialogBox dialogBox = new ValueOfExpressionQuestionnaireDialogBox (eventBus, experimentConditions);
//				final PostGameQuestionnaireDialogBox dialogBox = new PostGameQuestionnaireDialogBox (eventBus, experimentConditions);
				dialogBox.center();
				//eventBus.fireEvent(new LogExperimentInformationEvent());
				
				//timer.schedule(1000);
			//eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
			
			}
/*			Timer timer = new Timer() {
			      public void run() {
			    	  //Window.open("https://usc.qualtrics.com/SE/?SID=SV_8w6VIY1oPigrrZq", "_blank", "");
			    	 // Window.open("https://atrial.qualtrics.com/SE/?SID=SV_bIzNEcOFu7OYMVn", "_blank", "");
			    	  eventBus.fireEvent(new LogExperimentInformationEvent());
			    	  eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());

			    	 // eventBus.fireEvent(new LogExperimentInformationEvent());
			      }
			    };*/
		});
		
		flowPanelDialogBoxContents.add(okButton);
		this.setWidget(flowPanelDialogBoxContents);
	};




};
