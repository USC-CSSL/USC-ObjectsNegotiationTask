package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.i18n.client.Constants;

public interface ScenarioInternationalizationConstants extends Constants {

	@DefaultStringValue("[TRANSLATION MISSING] Scenario")
	String scenario_Window_Title();

	@DefaultStringValue("[TRANSLATION MISSING] scenario missing")
	String scenario_textA();

	@DefaultStringValue("[TRANSLATION MISSING] scenario missing")
	String scenario_textB();
	
	@DefaultStringValue("[TRANSLATION MISSING] scenario missing")
	String scenario_textC();

	@DefaultStringValue("[TRANSLATION MISSING] Continue")
	String ok_button();
	
	@DefaultStringValue("[TRANSLATION MISSING] Quiz")
	String scenario_quiz_Window_Title();

	@DefaultStringValue("[TRANSLATION MISSING] Please select the correct answer.")
	String scenario_quiz_part1();

	@DefaultStringValue("[TRANSLATION MISSING] What is the only way to control the spread of infection in your baby?")
	String scenario_quiz_no1();

	@DefaultStringValue("[TRANSLATION MISSING] Medicine (penicillin)")
	String scenario_quiz_no1_ans1();

	@DefaultStringValue("[TRANSLATION MISSING] Holy water")
	String scenario_quiz_no1_ans2();

	@DefaultStringValue("[TRANSLATION MISSING] Baby food")
	String scenario_quiz_no1_ans3();

	@DefaultStringValue("[TRANSLATION MISSING] Hand sanitizer")
	String scenario_quiz_no1_ans4();

	@DefaultStringValue("[TRANSLATION MISSING] Which family are you going to split aid packages with?")
	String scenario_quiz_no2();

	@DefaultStringValue("[TRANSLATION MISSING] Your boss's family")
	String scenario_quiz_no2_ans1();

	@DefaultStringValue("[TRANSLATION MISSING] Your coworker's family")
	String scenario_quiz_no2_ans2();

	@DefaultStringValue("[TRANSLATION MISSING] Your employee's family")
	String scenario_quiz_no2_ans3();

	@DefaultStringValue("[TRANSLATION MISSING] Your neighbor's family")
	String scenario_quiz_no2_ans4();

	@DefaultStringValue("[TRANSLATION MISSING] Which item in your possession is running low?")
	String scenario_quiz_no3();

	@DefaultStringValue("[TRANSLATION MISSING] Medicine")
	String scenario_quiz_no3_ans1();

	@DefaultStringValue("[TRANSLATION MISSING] Water")
	String scenario_quiz_no3_ans2();

	@DefaultStringValue("[TRANSLATION MISSING] Food")
	String scenario_quiz_no3_ans3();

	@DefaultStringValue("[TRANSLATION MISSING] Hand Sanitizer")
	String scenario_quiz_no3_ans4();

	@DefaultStringValue("[TRANSLATION MISSING] Please select true of false.")
	String scenario_quiz_part2();

	@DefaultStringValue("[TRANSLATION MISSING] You can select your facial expression anytime during the game.")
	String scenario_quiz_no4();

	@DefaultStringValue("[TRANSLATION MISSING] You cannot make another offer when you reject the other participant's offer.")
	String scenario_quiz_no5();

	@DefaultStringValue("[TRANSLATION MISSING] True")
	String scenario_quiz_true();

	@DefaultStringValue("[TRANSLATION MISSING] False")
	String scenario_quiz_false();

	@DefaultStringValue("[TRANSLATION MISSING] 1")
	String scenario_quiz_no1_ans();

	@DefaultStringValue("[TRANSLATION MISSING] 3")
	String scenario_quiz_no3_ans();

	@DefaultStringValue("[TRANSLATION MISSING] 1")
	String scenario_quiz_no4_ans();

	@DefaultStringValue("[TRANSLATION MISSING] 2")
	String scenario_quiz_no5_ans();

	@DefaultStringValue("[TRANSLATION MISSING] Quiz result")
	String scenario_quiz_result_Window_Title();

	@DefaultStringValue("[TRANSLATION MISSING] You got all questions correct.")
	String scenario_quiz_result_pass();

	@DefaultStringValue("[TRANSLATION MISSING] Please review the scenario again and answer the questions.")
	String scenario_quiz_result_nonpass();
	
	//String btnContinue_html();
};
