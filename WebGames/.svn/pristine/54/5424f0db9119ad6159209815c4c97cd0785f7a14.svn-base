package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.HasDirection.Direction;
//import com.google.gwt.user.client.Timer;
//import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;



@SuppressWarnings("deprecation")
public class PreGameQuestionnaireDialogBox extends DialogBox  {

	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final private ExperimentConditions experimentConditions;

	//@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	final ArrayList<RadioButton> SVQuestion = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> SVQuestionFood = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> SVQuestionWater = new ArrayList<RadioButton>();
//	final ArrayList<RadioButton> SVQuestionMoney = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> SVQuestionSanitizer = new ArrayList<RadioButton>();
	
//	final ArrayList<RadioButton> importanceQuestion = new ArrayList<RadioButton>();
//	final ArrayList<RadioButton> moralQuestion = new ArrayList<RadioButton>();
	
	
	public PreGameQuestionnaireDialogBox(final EventBus eventBus, final int temp, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;

		setHTML("Questionnaire");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		
		absolutePanel.setSize("650px", "700px");
		
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
    
		
//		if (localName == "en"){
		if (localName == "en" || localName == "ko"){
		//	int expScenario = experimentConditions.getExpScenario();
			HTML html;
			/*if(expScenario==1)  
				html = new HTML("How do you feel about giving up the <b>medicine package?</b> needed to save the life of the other family's baby?");
			if(expScenario==2)
				html = new HTML("How do you feel about giving up the <b>medicine package?</b> needed to save the life of the other family's baby?");
			if(expScenario==3)
				html = new HTML("How do you feel about giving up the <b>medicine package?</b> needed to save the life of the other family's baby?");*/
//			html = new HTML("How do you feel about giving up the <b>medicine</b>?");
    		html = new HTML(constants.SV_Question());
			absolutePanel.add(html, 10, 25);			
			
			//Label lblHowDoYou = new Label(constants.SV_Question());
			//lblHowDoYou.setStylePrimaryName("RadioButton-style");
			//absolutePanel.add(lblHowDoYou, 10, 25);
			absolutePanel.add(html, 10, 25);
			
			RadioButton radioButtonQuestions1_1  = new RadioButton("SVQuestion");
			radioButtonQuestions1_1.setHTML(constants.SV_Question_1());
			radioButtonQuestions1_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions1_1, 20, 50);
			radioButtonQuestions1_1.setSize("266px", "19px");
			SVQuestion.add(radioButtonQuestions1_1);
		
			RadioButton radioButtonQuestions1_2 = new RadioButton("SVQuestion");
			radioButtonQuestions1_2.setHTML(constants.SV_Question_2());
			radioButtonQuestions1_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions1_2, 20, 75);
			radioButtonQuestions1_2.setSize("196px", "19px");
			SVQuestion.add(radioButtonQuestions1_2);
		
			RadioButton radioButtonQuestions1_3 = new RadioButton("SVQuestion");
			radioButtonQuestions1_3.setHTML(constants.SV_Question_3());
			radioButtonQuestions1_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions1_3, 20, 100);
			SVQuestion.add(radioButtonQuestions1_3);
		
			RadioButton radioButtonQuestions1_4 = new RadioButton("SVQuestion");
			radioButtonQuestions1_4.setHTML(constants.SV_Question_4());
			radioButtonQuestions1_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions1_4, 20, 125);
			SVQuestion.add(radioButtonQuestions1_4);
			
	    	VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 109, 150);
			verticalSplitPanel.setSize("446px", "32px");
			
	////////////////////////////////////////////////////////////////////////////////////		
//			HTML htmlb = new HTML("How do you feel about giving up the <b>water bottles</b>?");
    		HTML htmlb = new HTML(constants.SV_QuestionB());
			absolutePanel.add(htmlb, 10, 200);
			
			RadioButton radioButtonQuestions2_1  = new RadioButton("SVQuestionWater");
			radioButtonQuestions2_1.setHTML(constants.SV_Question_1());
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 20, 225);
			radioButtonQuestions2_1.setSize("266px", "19px");
			SVQuestionWater.add(radioButtonQuestions2_1);
		
			RadioButton radioButtonQuestions2_2 = new RadioButton("SVQuestionWater");
			radioButtonQuestions2_2.setHTML(constants.SV_Question_2());
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 20, 250);
			radioButtonQuestions2_2.setSize("196px", "19px");
			SVQuestionWater.add(radioButtonQuestions2_2);
		
			RadioButton radioButtonQuestions2_3 = new RadioButton("SVQuestionWater");
			radioButtonQuestions2_3.setHTML(constants.SV_Question_3());
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 20, 275);
			SVQuestionWater.add(radioButtonQuestions2_3);
		
			RadioButton radioButtonQuestions2_4 = new RadioButton("SVQuestionWater");
			radioButtonQuestions2_4.setHTML(constants.SV_Question_4());
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 20, 300);
			SVQuestionWater.add(radioButtonQuestions2_4);
			
	    	VerticalSplitPanel verticalSplitPanel2 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel2, 109, 325);
			verticalSplitPanel2.setSize("446px", "32px");
////////////////////////////////////////////////////////////////////////////////////////
//			HTML htmlc = new HTML("How do you feel about giving up the <b>canned food</b>?");
    		HTML htmlc = new HTML(constants.SV_QuestionC());
			absolutePanel.add(htmlc, 10, 375);
			
			RadioButton radioButtonQuestions3_1  = new RadioButton("SVQuestionFood");
			radioButtonQuestions3_1.setHTML(constants.SV_Question_1());
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 20, 400);
			radioButtonQuestions3_1.setSize("266px", "19px");
			SVQuestionFood.add(radioButtonQuestions3_1);
		
			RadioButton radioButtonQuestions3_2 = new RadioButton("SVQuestionFood");
			radioButtonQuestions3_2.setHTML(constants.SV_Question_2());
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 20, 425);
			radioButtonQuestions3_2.setSize("196px", "19px");
			SVQuestionFood.add(radioButtonQuestions3_2);
		
			RadioButton radioButtonQuestions3_3 = new RadioButton("SVQuestionFood");
			radioButtonQuestions3_3.setHTML(constants.SV_Question_3());
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 20, 450);
			SVQuestionFood.add(radioButtonQuestions3_3);
		
			RadioButton radioButtonQuestions3_4 = new RadioButton("SVQuestionFood");
			radioButtonQuestions3_4.setHTML(constants.SV_Question_4());
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 20, 475);
			SVQuestionFood.add(radioButtonQuestions3_4);
			
	    	VerticalSplitPanel verticalSplitPanel3 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel3, 109, 500);
			verticalSplitPanel3.setSize("446px", "32px");
///////////////////////////////////////////////////////////////////////////////////////
//			HTML htmld = new HTML("How do you feel about giving up the <b>money</b>?");
/*    		HTML htmld = new HTML(constants.SV_QuestionD());
			absolutePanel.add(htmld, 10, 550);
			
			RadioButton radioButtonQuestions4_1  = new RadioButton("SVQuestionMoney");
			radioButtonQuestions4_1.setHTML(constants.SV_Question_1());
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 20, 575);
			radioButtonQuestions4_1.setSize("266px", "19px");
			SVQuestionMoney.add(radioButtonQuestions4_1);
		
			RadioButton radioButtonQuestions4_2 = new RadioButton("SVQuestionMoney");
			radioButtonQuestions4_2.setHTML(constants.SV_Question_2());
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 20, 600);
			radioButtonQuestions4_2.setSize("196px", "19px");
			SVQuestionMoney.add(radioButtonQuestions4_2);
		
			RadioButton radioButtonQuestions4_3 = new RadioButton("SVQuestionMoney");
			radioButtonQuestions4_3.setHTML(constants.SV_Question_3());
			radioButtonQuestions4_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions4_3, 20, 625);
			SVQuestionMoney.add(radioButtonQuestions4_3);
		
			RadioButton radioButtonQuestions4_4 = new RadioButton("SVQuestionMoney");
			radioButtonQuestions4_4.setHTML(constants.SV_Question_4());
			radioButtonQuestions4_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions4_4, 20, 650);
			SVQuestionMoney.add(radioButtonQuestions4_4);*/
			
			HTML htmld = new HTML(constants.SV_QuestionD());
			absolutePanel.add(htmld, 10, 550);
			
			RadioButton radioButtonQuestions4_1  = new RadioButton("SVQuestionSanitizer");
			radioButtonQuestions4_1.setHTML(constants.SV_Question_1());
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 20, 575);
			radioButtonQuestions4_1.setSize("266px", "19px");
			SVQuestionSanitizer.add(radioButtonQuestions4_1);
		
			RadioButton radioButtonQuestions4_2 = new RadioButton("SVQuestionSanitizer");
			radioButtonQuestions4_2.setHTML(constants.SV_Question_2());
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 20, 600);
			radioButtonQuestions4_2.setSize("196px", "19px");
			SVQuestionSanitizer.add(radioButtonQuestions4_2);
		
			RadioButton radioButtonQuestions4_3 = new RadioButton("SVQuestionSanitizer");
			radioButtonQuestions4_3.setHTML(constants.SV_Question_3());
			radioButtonQuestions4_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions4_3, 20, 625);
			SVQuestionSanitizer.add(radioButtonQuestions4_3);
		
			RadioButton radioButtonQuestions4_4 = new RadioButton("SVQuestionSanitizer");
			radioButtonQuestions4_4.setHTML(constants.SV_Question_4());
			radioButtonQuestions4_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions4_4, 20, 650);
			SVQuestionSanitizer.add(radioButtonQuestions4_4);
			
	    	
			/*Label lblNewLabel_1 = new Label(constants.importance_Question());
			lblNewLabel_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel_1, 10, 198);
					
			final RadioButton radioButtonQuestions2_1 = new RadioButton("importanceQuestion", constants.one());
			radioButtonQuestions2_1.setFormValue("1");
			radioButtonQuestions2_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_1, 41, 222);
			importanceQuestion.add(radioButtonQuestions2_1);
					
			RadioButton radioButtonQuestions2_2 = new RadioButton("importanceQuestion", constants.two());
			radioButtonQuestions2_2.setFormValue("2");
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_2, 111, 222);
			importanceQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("importanceQuestion", constants.three());
			radioButtonQuestions2_3.setFormValue("3");
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_3, 181, 222);
			importanceQuestion.add(radioButtonQuestions2_3);
					
			RadioButton radioButtonQuestions2_4 = new RadioButton("importanceQuestion", constants.four());
			radioButtonQuestions2_4.setFormValue("4");
			radioButtonQuestions2_4.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_4, 251, 222);
			importanceQuestion.add(radioButtonQuestions2_4);
					
			RadioButton radioButtonQuestions2_5 = new RadioButton("importanceQuestion", constants.five());
			radioButtonQuestions2_5.setFormValue("5");
			radioButtonQuestions2_5.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_5, 321, 222);
			importanceQuestion.add(radioButtonQuestions2_5);
					
			RadioButton radioButtonQuestions2_6 = new RadioButton("importanceQuestion", constants.six());
			radioButtonQuestions2_6.setFormValue("6");
			radioButtonQuestions2_6.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions2_6, 391, 222);
			importanceQuestion.add(radioButtonQuestions2_6);
					
			Label lblNewLabel_2 = new Label(constants.not_important_at_all());
			lblNewLabel_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel_2, 50, 247);
			lblNewLabel_2.setSize("129px", "19px");
			
			Label lblVeryImportant = new Label(constants.very_important());
			lblVeryImportant.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblVeryImportant, 347, 247);
			lblVeryImportant.setSize("129px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_1 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_1, 109, 286);
			verticalSplitPanel_1.setSize("446px", "32px");
			
			Label lblToWhatExtent = new Label(constants.moral_issue());
			lblToWhatExtent.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblToWhatExtent, 10, 337);
					
			RadioButton radioButtonQuestions3_1 = new RadioButton("moralQuestion", constants.one());
			radioButtonQuestions3_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 40, 361);
			moralQuestion.add(radioButtonQuestions3_1);
					
					
			RadioButton radioButtonQuestions3_2 = new RadioButton("moralQuestion", constants.two());
			radioButtonQuestions3_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 110, 361);
			moralQuestion.add(radioButtonQuestions3_2);
					
			RadioButton radioButtonQuestions3_3 = new RadioButton("moralQuestion", constants.three());
			radioButtonQuestions3_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 180, 361);
			moralQuestion.add(radioButtonQuestions3_3);
					
			RadioButton radioButtonQuestions3_4 = new RadioButton("moralQuestion", constants.four());
			radioButtonQuestions3_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 250, 361);
			moralQuestion.add(radioButtonQuestions3_4);
					
			RadioButton radioButtonQuestions3_5 = new RadioButton("moralQuestion", constants.five());
			radioButtonQuestions3_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions3_5, 320, 361);
			moralQuestion.add(radioButtonQuestions3_5);
					
			RadioButton radioButtonQuestions3_6 = new RadioButton("moralQuestion", constants.six());
			radioButtonQuestions3_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions3_6, 390, 361);
			moralQuestion.add(radioButtonQuestions3_6);
					

			Label lblNotAtAll = new Label(constants.not_at_all_moral());
			lblNotAtAll.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNotAtAll, 10, 386);
			lblNotAtAll.setSize("129px", "19px");
			
			Label lblCompletelyAMoral = new Label(constants.completely_moral());
			lblCompletelyAMoral.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblCompletelyAMoral, 347, 386);
			lblCompletelyAMoral.setSize("149px", "19px");
				*/	
			
		}
    	if (localName == "fa"){
    		Label lblHowDoYou = new Label(constants.SV_Question());
    		lblHowDoYou.setDirection(Direction.RTL);
    		lblHowDoYou.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		lblHowDoYou.setSize("614px", "19px");
    		absolutePanel.add(lblHowDoYou, 10, 30);
    		
    		RadioButton radioButtonQuestions1_1  = new RadioButton("SVQuestion");
    		radioButtonQuestions1_1.setStyleName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions1_1.setFormValue("1");
    		radioButtonQuestions1_1.setSize("266px", "19px");
    		absolutePanel.add(radioButtonQuestions1_1, 607, 55);
    		Label label_1 = new Label(constants.SV_Question_1());
    		label_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		label_1.setDirection(Direction.RTL);
    		absolutePanel.add(label_1, -12, 55);
    		label_1.setSize("614px", "19px");
    		SVQuestion.add(radioButtonQuestions1_1);
    	
    		RadioButton radioButtonQuestions1_2 = new RadioButton("SVQuestion");
    		radioButtonQuestions1_2.setStyleName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions1_2.setFormValue("2");
    		absolutePanel.add(radioButtonQuestions1_2, 607, 80);
    		Label label_2 = new Label(constants.SV_Question_2());
    		label_2.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		label_2.setDirection(Direction.RTL);
    		absolutePanel.add(label_2, -13, 77);
    		label_2.setSize("614px", "19px");
    		SVQuestion.add(radioButtonQuestions1_2);
    	
    		RadioButton radioButtonQuestions1_3 = new RadioButton("SVQuestion");
    		radioButtonQuestions1_3.setStyleName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions1_3.setFormValue("3");
    		absolutePanel.add(radioButtonQuestions1_3, 607, 105);
    		Label label_3 = new Label(constants.SV_Question_3());
    		label_3.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		label_3.setDirection(Direction.RTL);
    		absolutePanel.add(label_3, -13, 102);
    		label_3.setSize("614px", "19px");
    		SVQuestion.add(radioButtonQuestions1_3);
    	
    				
    		RadioButton radioButtonQuestions1_4 = new RadioButton("SVQuestion");
    		radioButtonQuestions1_4.setStyleName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions1_4.setFormValue("4");
    		absolutePanel.add(radioButtonQuestions1_4, 607, 130);
    		Label label_4 = new Label(constants.SV_Question_4());
    		label_4.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		label_4.setDirection(Direction.RTL);
    		absolutePanel.add(label_4, -12, 127);
    		label_4.setSize("614px", "19px");
    		SVQuestion.add(radioButtonQuestions1_4);
    		
/*        	VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
    		absolutePanel.add(verticalSplitPanel, 109, 150);
    		verticalSplitPanel.setSize("446px", "32px");
    		
    		Label lblNewLabel_1 = new Label(constants.importance_Question());
    		lblNewLabel_1.setDirection(Direction.RTL);
    		lblNewLabel_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(lblNewLabel_1, 360, 188);
    				
    		final RadioButton radioButtonQuestions2_1 = new RadioButton("importanceQuestion", constants.one());
    		radioButtonQuestions2_1.setFormValue("1");
    		radioButtonQuestions2_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_1, 220, 222);
    		importanceQuestion.add(radioButtonQuestions2_1);
    				
    		RadioButton radioButtonQuestions2_2 = new RadioButton("importanceQuestion", constants.two());
    		radioButtonQuestions2_2.setFormValue("2");
    		radioButtonQuestions2_2.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_2, 290, 222);
    		importanceQuestion.add(radioButtonQuestions2_2);
    				
    		RadioButton radioButtonQuestions2_3 = new RadioButton("importanceQuestion", constants.three());
    		radioButtonQuestions2_3.setFormValue("3");
    		radioButtonQuestions2_3.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_3, 360, 222);
    		importanceQuestion.add(radioButtonQuestions2_3);
    				
    		RadioButton radioButtonQuestions2_4 = new RadioButton("importanceQuestion", constants.four());
    		radioButtonQuestions2_4.setFormValue("4");
    		radioButtonQuestions2_4.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_4, 430, 222);
    		importanceQuestion.add(radioButtonQuestions2_4);
    				
    		RadioButton radioButtonQuestions2_5 = new RadioButton("importanceQuestion", constants.five());
    		radioButtonQuestions2_5.setFormValue("5");
    		radioButtonQuestions2_5.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_5, 500, 222);
    		importanceQuestion.add(radioButtonQuestions2_5);
    				
    		RadioButton radioButtonQuestions2_6 = new RadioButton("importanceQuestion", constants.six());
    		radioButtonQuestions2_6.setFormValue("6");
    		radioButtonQuestions2_6.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(radioButtonQuestions2_6, 570, 222);
    		importanceQuestion.add(radioButtonQuestions2_6);
    				
    		Label lblNewLabel_2 = new Label(constants.not_important_at_all());
    		lblNewLabel_2.setDirection(Direction.RTL);
    		lblNewLabel_2.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(lblNewLabel_2, 150, 247);
    		lblNewLabel_2.setSize("129px", "19px");
    		
    		Label lblVeryImportant = new Label(constants.very_important());
    		lblVeryImportant.setDirection(Direction.RTL);
    		lblVeryImportant.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(lblVeryImportant, 495, 247);
    		lblVeryImportant.setSize("129px", "19px");
    		
    		VerticalSplitPanel verticalSplitPanel_1 = new VerticalSplitPanel();
    		absolutePanel.add(verticalSplitPanel_1, 109, 286);
    		verticalSplitPanel_1.setSize("446px", "32px");
    		
    		Label lblToWhatExtent = new Label(constants.moral_issue());
    		lblToWhatExtent.setStyleName("gwt-SimpleRadioButtonfa");
    		lblToWhatExtent.setDirection(Direction.RTL);
    		lblToWhatExtent.setStylePrimaryName("RadioButton-style");
    		absolutePanel.add(lblToWhatExtent, 285, 336);
    				
    		RadioButton radioButtonQuestions3_1 = new RadioButton("moralQuestion", constants.one());
    		radioButtonQuestions3_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_1.setFormValue("1");
    		absolutePanel.add(radioButtonQuestions3_1, 220, 361);
    		moralQuestion.add(radioButtonQuestions3_1);
    				
    				
    		RadioButton radioButtonQuestions3_2 = new RadioButton("moralQuestion", constants.two());
    		radioButtonQuestions3_2.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_2.setFormValue("2");
    		absolutePanel.add(radioButtonQuestions3_2, 290, 361);
    		moralQuestion.add(radioButtonQuestions3_2);
    				
    		RadioButton radioButtonQuestions3_3 = new RadioButton("moralQuestion", constants.three());
    		radioButtonQuestions3_3.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_3.setFormValue("3");
    		absolutePanel.add(radioButtonQuestions3_3, 360, 361);
    		moralQuestion.add(radioButtonQuestions3_3);
    				
    		RadioButton radioButtonQuestions3_4 = new RadioButton("moralQuestion", constants.four());
    		radioButtonQuestions3_4.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_4.setFormValue("4");
    		absolutePanel.add(radioButtonQuestions3_4, 430, 361);
    		moralQuestion.add(radioButtonQuestions3_4);
    				
    		RadioButton radioButtonQuestions3_5 = new RadioButton("moralQuestion", constants.five());
    		radioButtonQuestions3_5.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_5.setFormValue("5");
    		absolutePanel.add(radioButtonQuestions3_5, 500, 361);
    		moralQuestion.add(radioButtonQuestions3_5);
    				
    		RadioButton radioButtonQuestions3_6 = new RadioButton("moralQuestion", constants.six());
    		radioButtonQuestions3_6.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		radioButtonQuestions3_6.setFormValue("6");
    		absolutePanel.add(radioButtonQuestions3_6, 570, 361);
    		moralQuestion.add(radioButtonQuestions3_6);
    				

    		Label lblNotAtAll = new Label(constants.not_at_all_moral());
    		lblNotAtAll.setDirection(Direction.RTL);
    		lblNotAtAll.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(lblNotAtAll, 170, 386);
    		lblNotAtAll.setSize("129px", "19px");
    		
    		Label lblCompletelyAMoral = new Label(constants.completely_moral());
    		lblCompletelyAMoral.setDirection(Direction.RTL);
    		lblCompletelyAMoral.setStylePrimaryName("gwt-SimpleRadioButtonfa");
    		absolutePanel.add(lblCompletelyAMoral, 475, 386);
    		lblCompletelyAMoral.setSize("149px", "19px");*/
    	}
				
//    	final Button btnSubmit = new Button(constants.ok_button(), this);
    	Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(!getAnswers (SVQuestion).equals("0") & !getAnswers (SVQuestionWater).equals("0") & !getAnswers (SVQuestionFood).equals("0")
//						& !getAnswers (SVQuestionMoney).equals("0")){
						& !getAnswers (SVQuestionSanitizer).equals("0")){
					hide();
					experimentConditions.setSVValue(Integer.parseInt(getAnswers (SVQuestion)));
//					experimentConditions.setImportanceOfObject(Integer.parseInt(getAnswers (importanceQuestion)));
//					experimentConditions.setMoralIssueOfObject(Integer.parseInt(getAnswers (moralQuestion)));
					experimentConditions.setSVValueWater(Integer.parseInt(getAnswers (SVQuestionWater)));
					experimentConditions.setSVValueFood(Integer.parseInt(getAnswers (SVQuestionFood)));
//					experimentConditions.setSVValueMoney(Integer.parseInt(getAnswers (SVQuestionMoney)));
					experimentConditions.setSVValueSanitizer(Integer.parseInt(getAnswers (SVQuestionSanitizer)));
//					final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, temp);
					final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, temp, experimentConditions);
					dialogBox.center();
					}

			}
		});
		btnSubmit.setSize("92px", "33px");
		//absolutePanel.add(btnSubmit, 527, 476);
		absolutePanel.add(btnSubmit, 527, 660);
		
	};


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

