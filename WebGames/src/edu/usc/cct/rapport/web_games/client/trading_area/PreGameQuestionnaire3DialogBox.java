package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;



@SuppressWarnings("deprecation")
public class PreGameQuestionnaire3DialogBox extends DialogBox  {

	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final private ExperimentConditions experimentConditions;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	final ArrayList<RadioButton> SVQuestion1 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> SVQuestion2 = new ArrayList<RadioButton>(); 
	private AbsolutePanel absolutePanel = new AbsolutePanel();

	
	public PreGameQuestionnaire3DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;

		setHTML("Questionnaire");
		
//		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		
		absolutePanel.setSize("650px", "350px");
		
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
    		
		if (localName == "en"){
			HTML html;
    		html = new HTML(constants.SV_Question_Private_Sector());
			absolutePanel.add(html, 10, 10);			

			RadioButton radioButtonQuestions1_1  = new RadioButton("SVQuestion1");
			radioButtonQuestions1_1.setHTML(constants.yes());
			radioButtonQuestions1_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions1_1, 20, 50);
			radioButtonQuestions1_1.setSize("266px", "19px");
			SVQuestion1.add(radioButtonQuestions1_1);
		
			RadioButton radioButtonQuestions1_2 = new RadioButton("SVQuestion1");
			radioButtonQuestions1_2.setHTML(constants.no());
			radioButtonQuestions1_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions1_2, 20, 75);
			radioButtonQuestions1_2.setSize("196px", "19px");
			SVQuestion1.add(radioButtonQuestions1_2);
		
			RadioButton radioButtonQuestions1_3 = new RadioButton("SVQuestion1");
			radioButtonQuestions1_3.setHTML(constants.notSure());
			radioButtonQuestions1_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions1_3, 20, 100);
			SVQuestion1.add(radioButtonQuestions1_3);
			
			radioButtonQuestions1_1.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					showNextQuestion();
				}
			});
			
			radioButtonQuestions1_2.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					showNextQuestion();
				}
			});

			radioButtonQuestions1_3.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					showNextQuestion();
				}
			});
		}
	};

	public void showNextQuestion() {
		if(getAnswers (SVQuestion1).equals("1") || getAnswers (SVQuestion1).equals("2")) {
	    	VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 109, 125);
			verticalSplitPanel.setSize("446px", "32px");
			
			HTML htmlb = new HTML(constants.SV_Question_Private_Sector2());
			absolutePanel.add(htmlb, 10, 175);
			
			RadioButton radioButtonQuestions2_1  = new RadioButton("SVQuestion2");
			radioButtonQuestions2_1.setHTML(constants.yes());
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 20, 215);
			radioButtonQuestions2_1.setSize("266px", "19px");
			SVQuestion2.add(radioButtonQuestions2_1);
		
			RadioButton radioButtonQuestions2_2 = new RadioButton("SVQuestion2");
			radioButtonQuestions2_2.setHTML(constants.no());
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 20, 240);
			radioButtonQuestions2_2.setSize("196px", "19px");
			SVQuestion2.add(radioButtonQuestions2_2);
			
	    	Button btnSubmit = new Button(constants.ok_button());
			btnSubmit.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if(!getAnswers (SVQuestion1).equals("0") & !getAnswers (SVQuestion2).equals("0")) {
						hide();
						experimentConditions.setSVValuePrivateSector(Integer.parseInt(getAnswers (SVQuestion1)));
						experimentConditions.setSVValuePrivateSector2(Integer.parseInt(getAnswers (SVQuestion2)));
						final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, 0, experimentConditions);
						dialogBox.center();
					}

				}
			});
			btnSubmit.setSize("92px", "33px");
			absolutePanel.add(btnSubmit, 300, 290);
			
		} else {
			
	    	Button btnSubmit = new Button(constants.ok_button());
			btnSubmit.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if(!getAnswers (SVQuestion1).equals("0")) {
						hide();
						experimentConditions.setSVValuePrivateSector(Integer.parseInt(getAnswers (SVQuestion1)));
						experimentConditions.setSVValuePrivateSector2(0);
						final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, 0, experimentConditions);
						dialogBox.center();
					}

				}
			});
			btnSubmit.setSize("92px", "33px");
			absolutePanel.add(btnSubmit, 300, 290);			
		}
	}

	//checks to see which element of the array of buttons is checked, and returns its value
	public String getAnswers(final ArrayList<RadioButton> questions){
		final Iterator<RadioButton> iterator = questions.iterator();
		String valueofButton = "";
		RadioButton radioButtonTemp;
		final StringBuilder builder = new StringBuilder();
		
		while (iterator.hasNext()) {
			radioButtonTemp = iterator.next();
			if (radioButtonTemp.getValue()){
				builder.append(radioButtonTemp.getFormValue());
			}
			
	};
	valueofButton = builder.toString();
	if (valueofButton.isEmpty())
		valueofButton = "0";
	return valueofButton;
		
	};
};