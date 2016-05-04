package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

import com.google.gwt.user.client.ui.Button;

public class ScenarioCheckQuizResultDialogBox extends DialogBox {

	static final private ScenarioInternationalizationConstants constants = (ScenarioInternationalizationConstants) (GWT.isClient() ? GWT.create(ScenarioInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public ScenarioCheckQuizResultDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions, final boolean result) {
		super(false, true);
		this.eventBus = eventBus;

		setHTML(constants.scenario_quiz_result_Window_Title());
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");		


//		String okButtonString = constants.ok_button();
//		final Button okButton = new Button(okButtonString);		
		Button okButton = new Button(constants.ok_button());
		okButton.setSize("250px", "33px");
//		absolutePanel.add(okButton, 307, 510);
		absolutePanel.add(okButton, 275, 470);
		
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				
				if(result) {
//					final PreGameQuestionnaireDialogBox dialogBox = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
//					final PreGameQuestionnaire1DialogBox dialogBox = new PreGameQuestionnaire1DialogBox(eventBus, experimentConditions);
					final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, 1, experimentConditions);
//			    	dialogBox.center();
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				} else {
					final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
//			    	dialogBox.center();
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				}				
			};
		});
		
//		Label lblQuizResult = new Label("");
		HTML lblQuizResult = new HTML("");
		
		if(result)
			lblQuizResult = new HTML(constants.scenario_quiz_result_pass());
//			lblQuizResult = new Label(constants.scenario_quiz_result_pass());
		else
			lblQuizResult = new HTML(constants.scenario_quiz_result_nonpass());
//			lblQuizResult = new Label(constants.scenario_quiz_result_nonpass());
		
		FlexTable flexTable = new FlexTable();
		flexTable.setSize("780px", "450px");
/*		setWidget(flexTable);
//		flexTable.setSize("500px", "200px");*/

		lblQuizResult.setStylePrimaryName("BigLabel-style");
		flexTable.setWidget(0, 0, lblQuizResult);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		absolutePanel.add(flexTable, 10, 10);
	
//		lblQuizResult.setStylePrimaryName("Label-style");
/*		flexTable.setWidget(0, 0, lblQuizResult);
		flexTable.setWidget(1, 0, okButton);
		flexTable.getCellFormatter().setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);*/

	}
}
	

