package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
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

		String okButtonString = constants.ok_button();
		final Button okButton = new Button(okButtonString);		
		
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				
				if(result) {
					final PreGameQuestionnaireDialogBox dialogBox = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
			    	dialogBox.center();
				} else {
					final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
			    	dialogBox.center();
				}				
			};
		});
		
		Label lblQuizResult = new Label("");
		
		if(result)
			lblQuizResult = new Label(constants.scenario_quiz_result_pass());
		else
			lblQuizResult = new Label(constants.scenario_quiz_result_nonpass());
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
//		flexTable.setSize("500px", "200px");
		
		lblQuizResult.setStylePrimaryName("Label-style");
		flexTable.setWidget(0, 0, lblQuizResult);
		flexTable.setWidget(1, 0, okButton);
		flexTable.getCellFormatter().setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);

	}
}
	

