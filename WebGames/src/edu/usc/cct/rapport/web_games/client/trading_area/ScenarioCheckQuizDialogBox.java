package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalSplitPanel;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

import com.google.gwt.user.client.ui.Button;

//import edu.usc.cct.rapport.web_games.client.instructions.ScenarioInternationalizationConstants;



public class ScenarioCheckQuizDialogBox extends DialogBox {
	static final private ScenarioInternationalizationConstants constants = (ScenarioInternationalizationConstants) (GWT.isClient() ? GWT.create(ScenarioInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final ArrayList<RadioButton> Quiz1 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz2 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz3 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz4 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz5 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> Quiz6 = new ArrayList<RadioButton>(); 

	public ScenarioCheckQuizDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions){
		super(false, true);
		this.eventBus = eventBus;

		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		
		setHTML(constants.scenario_quiz_Window_Title());
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
//		absolutePanel.setSize("750px", "550px");
		absolutePanel.setSize("800px", "565px");
	
		if (localName == "en"){
			HTML part1 = new HTML(constants.scenario_quiz_part1());
			HTML quiz1 = new HTML(constants.scenario_quiz_forFruits_no1()); 
			absolutePanel.add(part1, 35, 20);			
			absolutePanel.add(quiz1, 35, 45);
			
			RadioButton radioButtonQuestions1_1  = new RadioButton("Quiz1");
			radioButtonQuestions1_1.setHTML(constants.scenario_quiz_forFruits_no1_ans1());
			radioButtonQuestions1_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions1_1, 45, 70);
			radioButtonQuestions1_1.setSize("266px", "19px");
			Quiz1.add(radioButtonQuestions1_1);
		
			RadioButton radioButtonQuestions1_2 = new RadioButton("Quiz1");
			radioButtonQuestions1_2.setHTML(constants.scenario_quiz_forFruits_no1_ans2());
			radioButtonQuestions1_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions1_2, 245, 70);
			radioButtonQuestions1_2.setSize("196px", "19px");
			Quiz1.add(radioButtonQuestions1_2);
		
			RadioButton radioButtonQuestions1_3 = new RadioButton("Quiz1");
			radioButtonQuestions1_3.setHTML(constants.scenario_quiz_forFruits_no1_ans3());
			radioButtonQuestions1_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions1_3, 445, 70);
			Quiz1.add(radioButtonQuestions1_3);
		
			////////////////////////////////////////////////////////////////////////////////////		

			HTML quiz2 = new HTML("");
/*			Integer partnerLabel = experimentConditions.getPartnerLabel();

			if (partnerLabel == 0) {
				quiz2.setHTML(constants.scenario_quiz_forFruits_no2_computer());
			} else if(partnerLabel == 1) {			
				quiz2.setHTML(constants.scenario_quiz_forFruits_no2_human());
			} else {
				quiz2.setHTML(constants.scenario_quiz_forFruits_no2());
			}*/
			quiz2.setHTML(constants.scenario_quiz_forFruits_no2());

//			absolutePanel.add(quiz2, 35, 185);
//			absolutePanel.add(quiz2, 35, 125);
			absolutePanel.add(quiz2, 35, 115);
			
			RadioButton radioButtonQuestions2_1  = new RadioButton("Quiz2");
			radioButtonQuestions2_1.setHTML(constants.scenario_quiz_forFruits_no2_ans1());
			radioButtonQuestions2_1.setFormValue("1");
//			absolutePanel.add(radioButtonQuestions2_1, 35, 210);
//			absolutePanel.add(radioButtonQuestions2_1, 35, 150);
			absolutePanel.add(radioButtonQuestions2_1, 35, 140);
			radioButtonQuestions2_1.setSize("266px", "19px");
			Quiz2.add(radioButtonQuestions2_1);
		
			RadioButton radioButtonQuestions2_2 = new RadioButton("Quiz2");
			radioButtonQuestions2_2.setHTML(constants.scenario_quiz_forFruits_no2_ans2());
			radioButtonQuestions2_2.setFormValue("2");
//			absolutePanel.add(radioButtonQuestions2_2, 235, 210);
//			absolutePanel.add(radioButtonQuestions2_2, 245, 150);
			absolutePanel.add(radioButtonQuestions2_2, 245, 140);
			radioButtonQuestions2_2.setSize("196px", "19px");
			Quiz2.add(radioButtonQuestions2_2);
		
			RadioButton radioButtonQuestions2_3 = new RadioButton("Quiz2");
			radioButtonQuestions2_3.setHTML(constants.scenario_quiz_forFruits_no2_ans3());
			radioButtonQuestions2_3.setFormValue("3");
//			absolutePanel.add(radioButtonQuestions2_3, 435, 210);
//			absolutePanel.add(radioButtonQuestions2_3, 445, 150);
			absolutePanel.add(radioButtonQuestions2_3, 445, 140);
			Quiz2.add(radioButtonQuestions2_3);
			
			////////////////////////////////////////////////////////////////////////////////////		
	
			HTML part2 = new HTML(constants.scenario_quiz_part2());
			HTML quiz3 = new HTML(constants.scenario_quiz_forFruits_no3()); 
//			absolutePanel.add(part2, 35, 335);
//			absolutePanel.add(part2, 35, 205);
			absolutePanel.add(part2, 35, 185);
//			absolutePanel.add(quiz3, 35, 355);
//			absolutePanel.add(quiz3, 35, 230);
			absolutePanel.add(quiz3, 35, 210);
			
			RadioButton radioButtonQuestions3_1  = new RadioButton("Quiz3");
			radioButtonQuestions3_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions3_1.setFormValue("1");
//			absolutePanel.add(radioButtonQuestions3_1, 45, 380);
//			absolutePanel.add(radioButtonQuestions3_1, 45, 255);
			absolutePanel.add(radioButtonQuestions3_1, 45, 235);
			radioButtonQuestions3_1.setSize("266px", "19px");
			Quiz3.add(radioButtonQuestions3_1);
		
			RadioButton radioButtonQuestions3_2 = new RadioButton("Quiz3");
			radioButtonQuestions3_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions3_2.setFormValue("2");
//			absolutePanel.add(radioButtonQuestions3_2, 245, 380);
//			absolutePanel.add(radioButtonQuestions3_2, 245, 255);
			absolutePanel.add(radioButtonQuestions3_2, 245, 235);
			radioButtonQuestions3_2.setSize("196px", "19px");
			Quiz3.add(radioButtonQuestions3_2);

			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz4 = new HTML(constants.scenario_quiz_forFruits_no4()); 
//			absolutePanel.add(quiz4, 35, 355);
//			absolutePanel.add(quiz4, 35, 315);
			absolutePanel.add(quiz4, 35, 280);
			
			RadioButton radioButtonQuestions4_1  = new RadioButton("Quiz4");
			radioButtonQuestions4_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions4_1.setFormValue("1");
//			absolutePanel.add(radioButtonQuestions4_1, 45, 380);
//			absolutePanel.add(radioButtonQuestions4_1, 45, 340);
			absolutePanel.add(radioButtonQuestions4_1, 45, 305);
			radioButtonQuestions4_1.setSize("266px", "19px");
			Quiz4.add(radioButtonQuestions4_1);
		
			RadioButton radioButtonQuestions4_2 = new RadioButton("Quiz4");
			radioButtonQuestions4_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions4_2.setFormValue("2");
//			absolutePanel.add(radioButtonQuestions4_2, 245, 380);
//			absolutePanel.add(radioButtonQuestions4_2, 245, 340);
			absolutePanel.add(radioButtonQuestions4_2, 245, 305);
			radioButtonQuestions4_2.setSize("196px", "19px");
			Quiz4.add(radioButtonQuestions4_2);

			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz5 = new HTML(constants.scenario_quiz_forFruits_no5()); 
//			absolutePanel.add(quiz5, 35, 355);
//			absolutePanel.add(quiz5, 35, 395);
			absolutePanel.add(quiz5, 35, 350);
			
			RadioButton radioButtonQuestions5_1  = new RadioButton("Quiz5");
			radioButtonQuestions5_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions5_1.setFormValue("1");
//			absolutePanel.add(radioButtonQuestions5_1, 45, 380);
//			absolutePanel.add(radioButtonQuestions5_1, 45, 420);
			absolutePanel.add(radioButtonQuestions5_1, 45, 375);
			radioButtonQuestions5_1.setSize("266px", "19px");
			Quiz5.add(radioButtonQuestions5_1);
		
			RadioButton radioButtonQuestions5_2 = new RadioButton("Quiz5");
			radioButtonQuestions5_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions5_2.setFormValue("2");
//			absolutePanel.add(radioButtonQuestions5_2, 245, 380);
//			absolutePanel.add(radioButtonQuestions5_2, 245, 420);
			absolutePanel.add(radioButtonQuestions5_2, 245, 375);
			radioButtonQuestions5_2.setSize("196px", "19px");
			Quiz5.add(radioButtonQuestions5_2);
			
			
/*			HTML quiz5 = new HTML(constants.scenario_quiz_no5()); 
			absolutePanel.add(quiz5, 10, 470);			
			
			RadioButton radioButtonQuestions5_1  = new RadioButton("Quiz5");
			radioButtonQuestions5_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 20, 495);
			radioButtonQuestions5_1.setSize("266px", "19px");
			Quiz5.add(radioButtonQuestions5_1);
		
			RadioButton radioButtonQuestions5_2 = new RadioButton("Quiz5");
			radioButtonQuestions5_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 320, 495);
			radioButtonQuestions5_2.setSize("196px", "19px");
			Quiz5.add(radioButtonQuestions5_2);*/
			
			////////////////////////////////////////////////////////////////////////////////////		
			
			HTML quiz6 = new HTML(constants.scenario_quiz_forFruits_no6()); 
//			absolutePanel.add(quiz6, 35, 475);
			absolutePanel.add(quiz6, 35, 420);
			
			RadioButton radioButtonQuestions6_1  = new RadioButton("Quiz6");
			radioButtonQuestions6_1.setHTML(constants.scenario_quiz_true());
			radioButtonQuestions6_1.setFormValue("1");
//			absolutePanel.add(radioButtonQuestions6_1, 45, 500);
			absolutePanel.add(radioButtonQuestions6_1, 45, 445);
			radioButtonQuestions6_1.setSize("266px", "19px");
			Quiz6.add(radioButtonQuestions6_1);
		
			RadioButton radioButtonQuestions6_2 = new RadioButton("Quiz6");
			radioButtonQuestions6_2.setHTML(constants.scenario_quiz_false());
			radioButtonQuestions6_2.setFormValue("2");
//			absolutePanel.add(radioButtonQuestions6_2, 245, 500);
			absolutePanel.add(radioButtonQuestions6_2, 245, 445);
			radioButtonQuestions6_2.setSize("196px", "19px");
			Quiz6.add(radioButtonQuestions6_2);

		}

		Button button = new Button(constants.ok_button());
//		absolutePanel.add(button, 640, 515);
//		button.setSize("101px", "26px");
		button.setSize("250px", "33px");
//		absolutePanel.add(button, 307, 510);
//		absolutePanel.add(button, 275, 490); // when there are 5 questions
//		absolutePanel.add(button, 275, 510);
		absolutePanel.add(button, 275, 500);

		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions);
//				dialogBox.center();
				
//				hide();
//				final PreGameQuestionnaireDialogBox dialogBox  = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
//				dialogBox.center();
				
//				if(!getAnswers(Quiz1).equals("0") & !getAnswers(Quiz2).equals("0") & !getAnswers(Quiz4).equals("0")) {
				if(!getAnswers(Quiz1).equals("0") & !getAnswers(Quiz2).equals("0") & !getAnswers(Quiz3).equals("0") & !getAnswers(Quiz4).equals("0") 
						& !getAnswers(Quiz5).equals("0") & !getAnswers(Quiz6).equals("0")) {
					
					if(getAnswers(Quiz1).equals(constants.scenario_quiz_forFruits_no1_ans()) 			& getAnswers(Quiz2).equals(constants.scenario_quiz_forFruits_no2_ans()) 
							& getAnswers(Quiz3).equals(constants.scenario_quiz_forFruits_no3_ans())		& getAnswers(Quiz4).equals(constants.scenario_quiz_forFruits_no4_ans())
							& getAnswers(Quiz5).equals(constants.scenario_quiz_forFruits_no5_ans())		& getAnswers(Quiz6).equals(constants.scenario_quiz_forFruits_no6_ans())) {
//					if(getAnswers(Quiz1).equals(constants.scenario_quiz_forNSA_no1_ans()) 			& getAnswers(Quiz2).equals(constants.scenario_quiz_forNSA_no2_ans()) 
//							& getAnswers(Quiz3).equals(constants.scenario_quiz_forNSA_no3_ans()) 	& getAnswers(Quiz4).equals(constants.scenario_quiz_no4_ans()) 
//							& getAnswers(Quiz5).equals(constants.scenario_quiz_no5_ans())) {
						hide();
						final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions, true);
	//					final PreGameQuestionnaireDialogBox dialogBox  = new PreGameQuestionnaireDialogBox(eventBus, 1, experimentConditions);
//						dialogBox.center();
						dialogBox.setPopupPosition(105, 75);
						dialogBox.show();
					
					} else {
						hide();
						final ScenarioCheckQuizResultDialogBox dialogBox = new ScenarioCheckQuizResultDialogBox (eventBus, experimentConditions, false);
	//					final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
	//					dialogBox.center();
						dialogBox.setPopupPosition(105, 75);
						dialogBox.show();
					}
				}
			}
		});
		
		this.setWidget(absolutePanel);
	}
	
	public String getAnswers(final ArrayList<RadioButton> questions) {
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
}
