package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import com.google.gwt.user.client.ui.Button;

public class ParticipantIDDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	
	
	public ParticipantIDDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;

		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		
				
	//	if (localName == "en"){
		setHTML(constants.participant_ID());
		
		SimplePanel simplePanel = new SimplePanel();
		setWidget(simplePanel);
//		simplePanel.setSize("294px", "99px");
		simplePanel.setSize("250px", "100px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		simplePanel.setWidget(absolutePanel);
		absolutePanel.setSize("100%", "100%");
		
		Label lblPleaseEnterYou = new Label(constants.get_participant_ID());
		lblPleaseEnterYou.setStylePrimaryName("Label-style");
		absolutePanel.add(lblPleaseEnterYou, 10, 10);
		
		final TextArea ParticipantIDBox = new TextArea();
		ParticipantIDBox.setSize("220px", "20px");
//		absolutePanel.add(ParticipantIDBox, 10, 31);
		absolutePanel.add(ParticipantIDBox, 10, 35);
		
		Button button = new Button(constants.ok_button());
//		absolutePanel.add(button, 197, 66);
		absolutePanel.add(button, 75, 70);
		button.setSize("100px", "25px");

		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//int participantID = 0;
				//String participantID;
				/*if (!ParticipantIDBox.getText().isEmpty()) 
					if(isNumeric(ParticipantIDBox.getText()) > 0)
						participantID = Integer.parseInt(ParticipantIDBox.getText());*/
					
				//participantID
				//if (!ParticipantIDBox.getText().isEmpty() & participantID > 0 ){
				if (!ParticipantIDBox.getText().isEmpty()){
					//experimentConditions.setParticipantID(participantID);
					experimentConditions.setParticipantID(ParticipantIDBox.getText());
					hide();
					Timer timer = new Timer() {
					      public void run() {
					    	  final MoralFoundationsQuestionnaire1DialogBox dialogBox = new MoralFoundationsQuestionnaire1DialogBox (eventBus, experimentConditions);
//					    	  final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, 0); // To ease testing
//					    	  final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
					    	  dialogBox.center();
					      }
					    };
					    timer.schedule(1000);
					
				}
			};
			});
	}
	public static int isNumeric(String str)  
	{  
	  try  
	  {  
		@SuppressWarnings("unused")
		Integer i = Integer.parseInt(str);  
	    
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return 0;  
	  }  
	  return Integer.parseInt(str);  
	}
}
	

