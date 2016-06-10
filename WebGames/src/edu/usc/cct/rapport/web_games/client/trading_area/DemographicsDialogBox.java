package edu.usc.cct.rapport.web_games.client.trading_area;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

import java.util.Iterator;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
//import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaActivity.LogExperimentInformation;


public class DemographicsDialogBox extends DialogBox {

	final ArrayList<RadioButton> genderQuestion = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> educationQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> religiosityQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> ethnicityQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> economicClassQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> politicalOrientationQuestion = new ArrayList<RadioButton>();
	
//	@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
//	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public DemographicsDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML("Demographic Information");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
//		absolutePanel.setSize("597px", "450px"); // 597, 610 // 597, 555 (w/o economic class and political orientation questions)
		absolutePanel.setSize("800px", "565px");
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		final IntegerBox integerBox = new IntegerBox();
		final TextArea textArea = new TextArea();
		
		if (localName == "en" || localName == "ko"){	
			Label lblNewLabel_1 = new Label(constants.please_provide_demographics());
			lblNewLabel_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel_1, 10, 10);
			lblNewLabel_1.setSize("502px", "18px");
			
			Label lblWhatIs = new Label(constants.what_is_your_age());
			lblWhatIs.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblWhatIs, 10, 60); // 10, 67
			lblWhatIs.setSize("502px", "18px");
			
			//final IntegerBox integerBox = new IntegerBox();
			integerBox.setSize("30px", "15px");
			absolutePanel.add(integerBox, 145, 57); // 145, 63
			
			Label lblGender = new Label(constants.gender());
			lblGender.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblGender, 10, 105);
			lblGender.setSize("502px", "18px");
			
			final RadioButton radioButtonQuestions1_1 = new RadioButton("genderQuestion", constants.female());
			radioButtonQuestions1_1.setFormValue("1");
			radioButtonQuestions1_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_1, 90, 105);
			genderQuestion.add(radioButtonQuestions1_1);
			
			RadioButton radioButtonQuestions1_2 = new RadioButton("genderQuestion", constants.male());
			radioButtonQuestions1_2.setFormValue("2");
			radioButtonQuestions1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_2, 210, 105);
			genderQuestion.add(radioButtonQuestions1_2);
			
/*			Label lblFemale = new Label(constants.female());
			lblFemale.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblFemale, 89, 145);
			
			Label lblMale = new Label(constants.male());
			lblMale.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblMale, 170, 145);*/
			
			Label lblEducation = new Label(constants.education());
			lblEducation.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblEducation, 10, 150);
			lblEducation.setSize("502px", "18px");
			
			RadioButton radioButtonQuestions2_1 = new RadioButton("educationQuestion", constants.elementary());
			radioButtonQuestions2_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 90, 150);
			educationQuestion.add(radioButtonQuestions2_1);
			
			RadioButton radioButtonQuestions2_2 = new RadioButton("educationQuestion", constants.high_school());
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 210, 150);
			educationQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("educationQuestion", constants.college());
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 330, 150);
			educationQuestion.add(radioButtonQuestions2_3);
			
			RadioButton radioButtonQuestions2_4 = new RadioButton("educationQuestion", constants.grad_school());
			radioButtonQuestions2_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 450, 150);
			educationQuestion.add(radioButtonQuestions2_4);
			
/*			Label lblElementary = new Label(constants.elementary());
			lblElementary.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblElementary, 110, 219);
			lblElementary.setSize("47px", "16px");
			
			Label lblHighSchool = new Label(constants.high_school());
			lblHighSchool.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblHighSchool, 200, 219);
			lblHighSchool.setSize("47px", "16px");
			
			Label lblCollege = new Label(constants.college());
			lblCollege.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblCollege, 276, 219);
			lblCollege.setSize("47px", "16px");
			
			Label lblGraduateSchool = new Label(constants.grad_school());
			lblGraduateSchool.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblGraduateSchool, 351, 219);
			lblGraduateSchool.setSize("47px", "16px");*/

/*			Label lblEducation = new Label("Do you have any children?");
			lblEducation.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblEducation, 10, 195);
			lblEducation.setSize("502px", "18px");
			
			
			RadioButton radioButtonQuestions2_2 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_2.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_2, 203, 195);
			educationQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_3.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_3, 283, 195);
			educationQuestion.add(radioButtonQuestions2_3);
			
			Label lblHighSchool = new Label("No");
			lblHighSchool.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblHighSchool, 200, 219);
			lblHighSchool.setSize("47px", "16px");
			
			Label lblCollege = new Label("Yes");
			lblCollege.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblCollege, 276, 219);
			lblCollege.setSize("47px", "16px");
*/			
			
			
			Label lblHow = new Label(constants.how_religious());
			lblHow.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblHow, 10, 195); //10, 285
			lblHow.setSize("502px", "18px");
			
			
			RadioButton radioButtonQuestions3_1 = new RadioButton("religiosityQuestion", constants.one());
			radioButtonQuestions3_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 330, 195); // 40, 308
//			absolutePanel.add(radioButtonQuestions3_1, 90, 220); // 40, 308
			radioButtonQuestions3_1.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_1);
			
			RadioButton radioButtonQuestions3_2 = new RadioButton("religiosityQuestion", constants.two());
			radioButtonQuestions3_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 402, 195); // 110, 308
//			absolutePanel.add(radioButtonQuestions3_2, 162, 220); // 110, 308
			radioButtonQuestions3_2.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_2);
			
			RadioButton radioButtonQuestions3_3 = new RadioButton("religiosityQuestion", constants.three());
			radioButtonQuestions3_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 474, 195);
//			absolutePanel.add(radioButtonQuestions3_3, 234, 220);
			radioButtonQuestions3_3.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_3);
			
			RadioButton radioButtonQuestions3_4 = new RadioButton("religiosityQuestion", constants.four());
			radioButtonQuestions3_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 546, 195);
//			absolutePanel.add(radioButtonQuestions3_4, 306, 220);
			radioButtonQuestions3_4.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_4);
			
			RadioButton radioButtonQuestions3_5 = new RadioButton("religiosityQuestion", constants.five());
			radioButtonQuestions3_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions3_5, 618, 195);
//			absolutePanel.add(radioButtonQuestions3_5, 378, 220);
			radioButtonQuestions3_5.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_5);
			
			RadioButton radioButtonQuestions3_6 = new RadioButton("religiosityQuestion", constants.six());
			radioButtonQuestions3_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions3_6, 690, 195); // 390, 240
//			absolutePanel.add(radioButtonQuestions3_6, 450, 220); // 390, 240
			radioButtonQuestions3_6.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_6);
			
			Label lblNotReligious = new Label(constants.not_religious());
			lblNotReligious.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNotReligious, 315, 215); // 25, 333
//			absolutePanel.add(lblNotReligious, 75, 240); // 25, 333
//			lblNotReligious.setSize("150px", "16px");
			
			Label lblVeryReligious = new Label(constants.religious());
			lblVeryReligious.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblVeryReligious, 685, 215); // 385, 333
//			absolutePanel.add(lblVeryReligious, 445, 240); // 385, 333
//			lblVeryReligious.setSize("47px", "16px");
			
			if(localName == "en") {
				Label lblEthnicity = new Label(constants.ethnicity());
				lblEthnicity.setStylePrimaryName("RadioButton-style");
				absolutePanel.add(lblEthnicity, 10, 260);
//				absolutePanel.add(lblEthnicity, 10, 285);
				lblEthnicity.setSize("502px", "18px");
				
				RadioButton radioButtonQuestions4_1 = new RadioButton("ethnicityQuestion", constants.ethnicity1());
				radioButtonQuestions4_1.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_1.setFormValue("1");
				absolutePanel.add(radioButtonQuestions4_1, 90, 260);
//				absolutePanel.add(radioButtonQuestions4_1, 90, 285);
//				radioButtonQuestions4_1.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_1);
				
				RadioButton radioButtonQuestions4_2 = new RadioButton("ethnicityQuestion", constants.ethnicity2());
				radioButtonQuestions4_2.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_2.setFormValue("2");
				absolutePanel.add(radioButtonQuestions4_2, 230, 260);
//				absolutePanel.add(radioButtonQuestions4_2, 230, 285);
//				radioButtonQuestions4_2.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_2);
				
				RadioButton radioButtonQuestions4_3 = new RadioButton("ethnicityQuestion", constants.ethnicity3());
				radioButtonQuestions4_3.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_3.setFormValue("3");
				absolutePanel.add(radioButtonQuestions4_3, 330, 260);
//				absolutePanel.add(radioButtonQuestions4_3, 340, 285);
//				radioButtonQuestions4_3.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_3);
				
				RadioButton radioButtonQuestions4_4 = new RadioButton("ethnicityQuestion", constants.ethnicity4());
				radioButtonQuestions4_4.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_4.setFormValue("4");
				absolutePanel.add(radioButtonQuestions4_4, 430, 260);
//				absolutePanel.add(radioButtonQuestions4_4, 450, 285);
//				radioButtonQuestions4_4.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_4);
				
				RadioButton radioButtonQuestions4_5 = new RadioButton("ethnicityQuestion", constants.ethnicity5());
				radioButtonQuestions4_5.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_5.setFormValue("5");
				absolutePanel.add(radioButtonQuestions4_5, 90, 285);
//				absolutePanel.add(radioButtonQuestions4_5, 90, 310);
//				radioButtonQuestions4_5.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_5);
				
				RadioButton radioButtonQuestions4_6 = new RadioButton("ethnicityQuestion", constants.ethnicity6());
				radioButtonQuestions4_6.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_6.setFormValue("6");
				absolutePanel.add(radioButtonQuestions4_6, 230, 285);
//				absolutePanel.add(radioButtonQuestions4_6, 230, 310);
//				radioButtonQuestions4_6.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_6);
				
				RadioButton radioButtonQuestions4_7 = new RadioButton("ethnicityQuestion", constants.ethnicity7());
				radioButtonQuestions4_7.setStylePrimaryName("RadioButton-style");
				radioButtonQuestions4_7.setFormValue("7");
				absolutePanel.add(radioButtonQuestions4_7, 330, 285);
//				absolutePanel.add(radioButtonQuestions4_7, 340, 310);
//				radioButtonQuestions4_7.setSize("29px", "19px");
				ethnicityQuestion.add(radioButtonQuestions4_7);
			}
			
			Label lblEconomic = new Label(constants.economic_class());
			lblEconomic.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblEconomic, 10, 330);
//			absolutePanel.add(lblEconomic, 10, 355);
			lblEconomic.setSize("502px", "18px");
			
			RadioButton radioButtonQuestions5_1 = new RadioButton("economicClassQuestion", constants.lower());
			radioButtonQuestions5_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 330, 330);
//			absolutePanel.add(radioButtonQuestions5_1, 90, 380);
			economicClassQuestion.add(radioButtonQuestions5_1);
			
			RadioButton radioButtonQuestions5_2 = new RadioButton("economicClassQuestion", constants.middle());
			radioButtonQuestions5_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 474, 330);
//			absolutePanel.add(radioButtonQuestions5_2, 230, 380);
			economicClassQuestion.add(radioButtonQuestions5_2);
			
			RadioButton radioButtonQuestions5_3 = new RadioButton("economicClassQuestion", constants.upper());
			radioButtonQuestions5_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions5_3, 618, 330);
//			absolutePanel.add(radioButtonQuestions5_3, 370, 380);
			economicClassQuestion.add(radioButtonQuestions5_3);
			
			Label lblPolitical = new Label(constants.political_orientation());
			lblPolitical.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblPolitical, 10, 375);
//			absolutePanel.add(lblPolitical, 10, 355);
			lblPolitical.setSize("502px", "18px");

			RadioButton radioButtonQuestions6_1 = new RadioButton("politicalOrientationQuestion", constants.liberal());
			radioButtonQuestions6_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions6_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions6_1, 330, 375);
//			absolutePanel.add(radioButtonQuestions6_1, 90, 380);
			politicalOrientationQuestion.add(radioButtonQuestions6_1);
			
			RadioButton radioButtonQuestions6_2 = new RadioButton("politicalOrientationQuestion", constants.conservative());
			radioButtonQuestions6_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions6_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions6_2, 474, 375);
//			absolutePanel.add(radioButtonQuestions6_2, 230, 380);
			politicalOrientationQuestion.add(radioButtonQuestions6_2);
			
			RadioButton radioButtonQuestions6_3 = new RadioButton("politicalOrientationQuestion", constants.no_orientation());
			radioButtonQuestions6_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions6_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions6_3, 618, 375);
//			absolutePanel.add(radioButtonQuestions6_3, 370, 380);
			politicalOrientationQuestion.add(radioButtonQuestions6_3);
			
			Label lblComments = new Label(constants.comments());
			lblComments.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblComments, 10, 420);
//			absolutePanel.add(lblComments, 10, 425);
			lblComments.setSize("502px", "18px");

			absolutePanel.add(textArea, 90, 420);
//			absolutePanel.add(textArea, 14, 450);
			textArea.setSize("690px", "50px");
//			textArea.setSize("450px", "60px");
		}	
			
/*		if (localName == "fa"){
			Label lblNewLabel_1 = new Label(constants.please_provide_demographics());
			lblNewLabel_1.setDirection(Direction.RTL);
			lblNewLabel_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblNewLabel_1, 75, 10);
			lblNewLabel_1.setSize("502px", "18px");
			
			Label lblWhatIs = new Label(constants.what_is_your_age());
			lblWhatIs.setDirection(Direction.RTL);
			lblWhatIs.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblWhatIs, 75, 67);
			lblWhatIs.setSize("502px", "18px");
			
			//final IntegerBox integerBox = new IntegerBox();
			absolutePanel.add(integerBox, 283, 67);
			
			Label lblGender = new Label(constants.gender());
			lblGender.setDirection(Direction.RTL);
			lblGender.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblGender, 75, 121);
			lblGender.setSize("502px", "18px");
			
			final RadioButton radioButtonQuestions1_1 = new RadioButton("genderQuestion", "");
			radioButtonQuestions1_1.setFormValue("1");
			radioButtonQuestions1_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_1, 460, 120);
			genderQuestion.add(radioButtonQuestions1_1);
			
			RadioButton radioButtonQuestions1_2 = new RadioButton("genderQuestion", "");
			radioButtonQuestions1_2.setFormValue("2");
			radioButtonQuestions1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_2, 395, 120);
			genderQuestion.add(radioButtonQuestions1_2);
			
			Label lblFemale = new Label(constants.female());
			lblFemale.setDirection(Direction.RTL);
			lblFemale.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblFemale, 461, 145);
			
			Label lblMale = new Label(constants.male());
			lblMale.setDirection(Direction.RTL);
			lblMale.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblMale, 395, 145);
			
			Label lblEducation = new Label(constants.education());
			lblEducation.setDirection(Direction.RTL);
			lblEducation.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblEducation, 75, 195);
			lblEducation.setSize("502px", "18px");
			
			RadioButton radioButtonQuestions2_1 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 91, 195);
			educationQuestion.add(radioButtonQuestions2_1);
			
			RadioButton radioButtonQuestions2_2 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 168, 195);
			educationQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 248, 195);
			educationQuestion.add(radioButtonQuestions2_3);
			
			RadioButton radioButtonQuestions2_4 = new RadioButton("educationQuestion", "");
			radioButtonQuestions2_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 330, 194);
			
			Label lblElementary = new Label(constants.elementary());
			lblElementary.setDirection(Direction.RTL);
			lblElementary.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblElementary, 75, 219);
			lblElementary.setSize("47px", "16px");
			
			Label lblHighSchool = new Label(constants.high_school());
			lblHighSchool.setDirection(Direction.RTL);
			lblHighSchool.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblHighSchool, 165, 219);
			lblHighSchool.setSize("47px", "16px");
			
			Label lblCollege = new Label(constants.college());
			lblCollege.setDirection(Direction.RTL);
			lblCollege.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblCollege, 241, 219);
			lblCollege.setSize("47px", "16px");
			
			Label lblGraduateSchool = new Label(constants.grad_school());
			lblGraduateSchool.setDirection(Direction.RTL);
			lblGraduateSchool.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblGraduateSchool, 310, 219);
			lblGraduateSchool.setSize("47px", "16px");
			
			Label lblHow = new Label(constants.how_religious());
			lblHow.setDirection(Direction.RTL);
			lblHow.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblHow, 75, 285);
			lblHow.setSize("502px", "18px");
			
			
			RadioButton radioButtonQuestions3_1 = new RadioButton("religiosityQuestion", constants.one());
			radioButtonQuestions3_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 116, 308);
			radioButtonQuestions3_1.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_1);
			
			RadioButton radioButtonQuestions3_2 = new RadioButton("religiosityQuestion", constants.two());
			radioButtonQuestions3_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 186, 308);
			radioButtonQuestions3_2.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_2);
			
			RadioButton radioButtonQuestions3_3 = new RadioButton("religiosityQuestion", constants.three());
			radioButtonQuestions3_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 256, 308);
			radioButtonQuestions3_3.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_3);
			
			RadioButton radioButtonQuestions3_4 = new RadioButton("religiosityQuestion", constants.four());
			radioButtonQuestions3_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 326, 308);
			radioButtonQuestions3_4.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_4);
			
			RadioButton radioButtonQuestions3_5 = new RadioButton("religiosityQuestion", constants.five());
			radioButtonQuestions3_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions3_5, 396, 308);
			radioButtonQuestions3_5.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_5);
			
			RadioButton radioButtonQuestions3_6 = new RadioButton("religiosityQuestion", constants.six());
			radioButtonQuestions3_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions3_6, 466, 308);
			radioButtonQuestions3_6.setSize("29px", "19px");
			religiosityQuestion.add(radioButtonQuestions3_6);
			
			Label lblNotReligious = new Label(constants.not_religious());
			lblNotReligious.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNotReligious, 113, 333);
			lblNotReligious.setSize("47px", "16px");
			
			Label lblVeryReligious = new Label(constants.religious());
			lblVeryReligious.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblVeryReligious, 461, 333);
			lblVeryReligious.setSize("47px", "16px");
			
//			Label lblComments = new Label(constants.comments());
//			lblComments.setDirection(Direction.RTL);
//			lblComments.setStylePrimaryName("gwt-SimpleRadioButtonfa");
//			absolutePanel.add(lblComments, 75, 410);
//			lblComments.setSize("502px", "18px");
//
//			absolutePanel.add(textArea, 160, 435);
//			textArea.setSize("450px", "100px");
		}*/
		
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(textArea.getText().isEmpty()) textArea.setText("");

				if(!getAnswers(genderQuestion).equals("0") & !getAnswers(educationQuestion).equals("0") & !getAnswers(religiosityQuestion).equals("0") & !getAnswers(ethnicityQuestion).equals("0")
						& !getAnswers(economicClassQuestion).equals("0") 
						& !getAnswers(politicalOrientationQuestion).equals("0")
						& integerBox.getValue() != null) {
					
					final Button source = (Button) event.getSource();
				    source.setEnabled(true);
				      
					String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
					
					experimentConditions.setGenderOfParticipant(Integer.parseInt(getAnswers (genderQuestion)));
					experimentConditions.setEducationOfParticipant(Integer.parseInt(getAnswers (educationQuestion)));
					experimentConditions.setReligiosityOfParticipant(Integer.parseInt(getAnswers (religiosityQuestion)));
					if (localName == "en") experimentConditions.setEthnicityOfParticipant(Integer.parseInt(getAnswers (ethnicityQuestion)));
					experimentConditions.setEconomicClassOfParticipant(Integer.parseInt(getAnswers (economicClassQuestion)));
					experimentConditions.setPoliticalOrientationOfParticipant(Integer.parseInt(getAnswers (politicalOrientationQuestion)));
					experimentConditions.setCommentOfParticipant(textArea.getText());
					experimentConditions.setAgeOfParticipant(integerBox.getValue());
					
/*					if(Integer.parseInt(getAnswers (politicalOrientationQuestion)) == 3) {
						Random random = new Random();
						experimentConditions.setExpScenario(random.nextInt(2));	
					} else {
						experimentConditions.setExpScenario(Integer.parseInt(getAnswers (politicalOrientationQuestion)));		
					}*/
					
					eventBus.fireEvent(new LogExperimentInformationEvent());
					eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
					
	//				timer.schedule(3000);		
//					timer.schedule(1000);

/*					final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);*/
					final WaitingDialogBox dialogBox = new WaitingDialogBox (eventBus, "savingData", 0);
					dialogBox.center();
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
					
					Timer timer = new Timer() {
					      public void run() {
					    	  dialogBox.hide();
					      }
					};
					
					timer.schedule(2000); // 2sec delay
					
					hide();
				} else if(integerBox.getValue() == null) {
					Window.alert("Please input your age.");					
				} else if(getAnswers(genderQuestion).equals("0")) {
					Window.alert("Please select your gender.");
				} else if(getAnswers(educationQuestion).equals("0")) {
					Window.alert("Please select your education.");
				} else if(getAnswers(religiosityQuestion).equals("0")) {					
					Window.alert("Please select your religiosity.");
				} else if(getAnswers(ethnicityQuestion).equals("0")) {
					Window.alert("Please select your ethnicity.");
				} else if(getAnswers(economicClassQuestion).equals("0") ) {
					Window.alert("Please select your economic class.");
				} else if(getAnswers(politicalOrientationQuestion).equals("0")) {
					Window.alert("Please select your political party.");
				}
			}
		

	});
//		btnSubmit.setSize("92px", "33px");
//		absolutePanel.add(btnSubmit, 250, 400); // 471, 570 // 471, 515
		btnSubmit.setSize("250px", "33px");
		absolutePanel.add(btnSubmit, 307, 510);

	}
	
/*	Timer timer = new Timer() {
	      public void run() {
	    	  eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	      }
	};*/
	    
		
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
		if (valueofButton.isEmpty()) {
			valueofButton = "0";
		}
	
		return valueofButton;	
	};
}
