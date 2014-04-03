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
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


@SuppressWarnings("deprecation")
public class PostGameQuestionnaireDialogBox extends DialogBox {

	final ArrayList<RadioButton> angerQuestion = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> fairQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> needQuestion = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> otherAngerQuestion = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> otherFairQuestion = new ArrayList<RadioButton>();
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;

//	@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public PostGameQuestionnaireDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
	
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML("");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("650px", "679px");

		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
	    
		if (localName == "en"){
			Label lblNewLabel_1 = new Label(constants.outcome_fair());
			lblNewLabel_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel_1, 10, 10);
		
		
			final RadioButton radioButtonQuestions1_1 = new RadioButton("fairQuestion", constants.one());
			radioButtonQuestions1_1.setFormValue("1");
			radioButtonQuestions1_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_1, 41, 34);
			fairQuestion.add(radioButtonQuestions1_1);
			
			RadioButton radioButtonQuestions1_2 = new RadioButton("fairQuestion", constants.two());
			radioButtonQuestions1_2.setFormValue("2");
			radioButtonQuestions1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_2, 111, 34);
			fairQuestion.add(radioButtonQuestions1_2);
					
			RadioButton radioButtonQuestions1_3 = new RadioButton("fairQuestion", constants.three());
			radioButtonQuestions1_3.setFormValue("3");
			radioButtonQuestions1_3.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_3, 181, 34);
			fairQuestion.add(radioButtonQuestions1_3);
					
			RadioButton radioButtonQuestions1_4 = new RadioButton("fairQuestion", constants.four());
			radioButtonQuestions1_4.setFormValue("4");
			radioButtonQuestions1_4.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_4, 251, 34);
			fairQuestion.add(radioButtonQuestions1_4);
					
			RadioButton radioButtonQuestions1_5 = new RadioButton("fairQuestion", constants.five());
			radioButtonQuestions1_5.setFormValue("5");
			radioButtonQuestions1_5.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_5, 321, 34);
			fairQuestion.add(radioButtonQuestions1_5);
					
			RadioButton radioButtonQuestions1_6 = new RadioButton("fairQuestion", constants.six());
			radioButtonQuestions1_6.setFormValue("6");
			radioButtonQuestions1_6.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_6, 391, 34);
			fairQuestion.add(radioButtonQuestions1_6);
					
			Label lblNewLabel1_2 = new Label(constants.not_at_all_fair());
			lblNewLabel1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel1_2, 10, 59);
			lblNewLabel1_2.setSize("129px", "19px");
			
			Label lblVeryImportant = new Label(constants.very_much_fair());
			lblVeryImportant.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblVeryImportant, 367, 59);
			lblVeryImportant.setSize("129px", "19px");
			
			VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 97, 96);
			verticalSplitPanel.setSize("446px", "32px");
			
			Label lblToWhatExtent = new Label(constants.angry_if_deal_offered());
			lblToWhatExtent.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblToWhatExtent, 10, 134);
					
			RadioButton radioButtonQuestions2_1 = new RadioButton("angerQuestion", constants.one());
			radioButtonQuestions2_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 40, 158);
			angerQuestion.add(radioButtonQuestions2_1);
					
			Label lblNotAtAll = new Label(constants.not_at_all());
			lblNotAtAll.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNotAtAll, 23, 183);
			lblNotAtAll.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions2_2 = new RadioButton("angerQuestion", constants.two());
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 110, 158);
			angerQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("angerQuestion", constants.three());
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 180, 158);
			angerQuestion.add(radioButtonQuestions2_3);
					
			RadioButton radioButtonQuestions2_4 = new RadioButton("angerQuestion", constants.four());
			radioButtonQuestions2_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 250, 158);
			angerQuestion.add(radioButtonQuestions2_4);
					
			RadioButton radioButtonQuestions2_5 = new RadioButton("angerQuestion", constants.five());
			radioButtonQuestions2_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions2_5, 320, 158);
			angerQuestion.add(radioButtonQuestions2_5);
					
			RadioButton radioButtonQuestions2_6 = new RadioButton("angerQuestion", constants.six());
			radioButtonQuestions2_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions2_6, 390, 158);
			angerQuestion.add(radioButtonQuestions2_6);
					
			Label lblCompletelyAMoral = new Label(constants.a_lot());
			lblCompletelyAMoral.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblCompletelyAMoral, 391, 183);
			lblCompletelyAMoral.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_1 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_1, 97, 229);
			verticalSplitPanel_1.setSize("446px", "32px");
			
			Label label = new Label(constants.considered_your_need());
			label.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label, 10, 277);
			label.setSize("573px", "16px");
			
			Label label_1 = new Label(constants.not_at_all());
			label_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_1, 10, 326);
			label_1.setSize("129px", "19px");
	
			RadioButton radioButtonQuestions3_1 = new RadioButton("needQuestion", constants.one());
			radioButtonQuestions3_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 40, 301);
			radioButtonQuestions3_1.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_1);
			
			RadioButton radioButtonQuestions3_2 = new RadioButton("needQuestion", constants.two());
			radioButtonQuestions3_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 110, 301);
			radioButtonQuestions3_2.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_2);
			
			RadioButton radioButtonQuestions3_3 = new RadioButton("needQuestion", constants.three());
			radioButtonQuestions3_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 180, 301);
			radioButtonQuestions3_3.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_3);
			
			RadioButton radioButtonQuestions3_4 = new RadioButton("needQuestion", constants.four());
			radioButtonQuestions3_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 250, 301);
			radioButtonQuestions3_4.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_4);
			
			RadioButton radioButtonQuestions3_5 = new RadioButton("needQuestion", constants.five());
			radioButtonQuestions3_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions3_5, 320, 301);
			radioButtonQuestions3_5.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_5);
			
			RadioButton radioButtonQuestions3_6 = new RadioButton("needQuestion", constants.six());
			radioButtonQuestions3_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions3_6, 390, 301);
			radioButtonQuestions3_6.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_6);
			
			Label label_2 = new Label(constants.a_lot());
			label_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_2, 391, 326);
			label_2.setSize("149px", "19px");
			
		
			Label label_3 = new Label(constants.other_outcome_fair());
			label_3.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_3, 10, 407);
			label_3.setSize("486px", "16px");
			
			RadioButton radioButtonQuestions4_1 = new RadioButton("otherFairQuestion", constants.one());
			radioButtonQuestions4_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 40, 431);
			radioButtonQuestions4_1.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_1);
			
			
			Label label_4 = new Label(constants.not_at_all_fair());
			label_4.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_4, 10, 456);
			label_4.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions4_2 = new RadioButton("otherFairQuestion", constants.two());
			radioButtonQuestions4_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 110, 431);
			radioButtonQuestions4_2.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_2);
			
			RadioButton radioButtonQuestions4_3 = new RadioButton("otherFairQuestion", constants.three());
			radioButtonQuestions4_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions4_3, 180, 431);
			radioButtonQuestions4_3.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_3);
			
			RadioButton radioButtonQuestions4_4 = new RadioButton("otherFairQuestion", constants.four());
			radioButtonQuestions4_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions4_4, 250, 431);
			radioButtonQuestions4_4.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_4);
			
			RadioButton radioButtonQuestions4_5 = new RadioButton("otherFairQuestion", constants.five());
			radioButtonQuestions4_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions4_5, 320, 431);
			radioButtonQuestions4_5.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_5);
			
			RadioButton radioButtonQuestions4_6 = new RadioButton("otherFairQuestion", constants.six());
			radioButtonQuestions4_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions4_6, 390, 431);
			radioButtonQuestions4_6.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_6);
			
			Label label_5 = new Label(constants.very_much_fair());
			label_5.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_5, 367, 456);
			label_5.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_2 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_2, 97, 502);
			verticalSplitPanel_2.setSize("446px", "32px");
			
			Label label_6 = new Label(constants.angry_other_player());
			label_6.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_6, 10, 553);
			label_6.setSize("573px", "16px");
			
			Label label_7 = new Label(constants.not_at_all());
			label_7.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_7, 10, 600);
			label_7.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions5_1 = new RadioButton("otherAngerQuestion", constants.one());
			radioButtonQuestions5_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 40, 574);
			radioButtonQuestions5_1.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_1);
			
			RadioButton radioButtonQuestions5_2 = new RadioButton("otherAngerQuestion", constants.two());
			radioButtonQuestions5_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 110, 574);
			radioButtonQuestions5_2.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_2);
			
			RadioButton radioButtonQuestions5_3 = new RadioButton("otherAngerQuestion", constants.three());
			radioButtonQuestions5_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions5_3, 180, 574);
			radioButtonQuestions5_3.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_3);
			
			RadioButton radioButtonQuestions5_4 = new RadioButton("otherAngerQuestion", constants.four());
			radioButtonQuestions5_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions5_4, 250, 574);
			radioButtonQuestions5_4.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_4);
			
			RadioButton radioButtonQuestions5_5 = new RadioButton("otherAngerQuestion", constants.five());
			radioButtonQuestions5_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions5_5, 320, 574);
			radioButtonQuestions5_5.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_5);
			
			RadioButton radioButtonQuestions5_6 = new RadioButton("otherAngerQuestion", constants.six());
			radioButtonQuestions5_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions5_6, 390, 574);
			radioButtonQuestions5_6.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_6);
			
			
			Label label_8 = new Label(constants.a_lot());
			label_8.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_8, 391, 600);
			label_8.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_3 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_3, 97, 358);
			verticalSplitPanel_3.setSize("446px", "32px");
		}
		
		if (localName == "fa"){
			Label lblNewLabel_1 = new Label(constants.outcome_fair());
			lblNewLabel_1.setDirection(Direction.RTL);
			lblNewLabel_1.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblNewLabel_1, 435, 10);
			
			final RadioButton radioButtonQuestions1_1 = new RadioButton("fairQuestion", constants.one());
			radioButtonQuestions1_1.setFormValue("1");
			radioButtonQuestions1_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_1, 219, 34);
			fairQuestion.add(radioButtonQuestions1_1);
			
			RadioButton radioButtonQuestions1_2 = new RadioButton("fairQuestion", constants.two());
			radioButtonQuestions1_2.setFormValue("2");
			radioButtonQuestions1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_2, 289, 34);
			fairQuestion.add(radioButtonQuestions1_2);
					
			RadioButton radioButtonQuestions1_3 = new RadioButton("fairQuestion", constants.three());
			radioButtonQuestions1_3.setFormValue("3");
			radioButtonQuestions1_3.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_3, 359, 34);
			fairQuestion.add(radioButtonQuestions1_3);
					
			RadioButton radioButtonQuestions1_4 = new RadioButton("fairQuestion", constants.four());
			radioButtonQuestions1_4.setFormValue("4");
			radioButtonQuestions1_4.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_4, 429, 34);
			fairQuestion.add(radioButtonQuestions1_4);
					
			RadioButton radioButtonQuestions1_5 = new RadioButton("fairQuestion", constants.five());
			radioButtonQuestions1_5.setFormValue("5");
			radioButtonQuestions1_5.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_5, 499, 34);
			fairQuestion.add(radioButtonQuestions1_5);
					
			RadioButton radioButtonQuestions1_6 = new RadioButton("fairQuestion", constants.six());
			radioButtonQuestions1_6.setFormValue("6");
			radioButtonQuestions1_6.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(radioButtonQuestions1_6, 569, 34);
			fairQuestion.add(radioButtonQuestions1_6);
					
			Label lblNewLabel1_2 = new Label(constants.not_at_all_fair());
			lblNewLabel1_2.setDirection(Direction.RTL);
			lblNewLabel1_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNewLabel1_2, 150, 59);
			lblNewLabel1_2.setSize("129px", "19px");
			
			Label lblVeryImportant = new Label(constants.very_much_fair());
			lblVeryImportant.setDirection(Direction.RTL);
			lblVeryImportant.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblVeryImportant, 489, 59);
			lblVeryImportant.setSize("129px", "19px");
			
			VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 97, 96);
			verticalSplitPanel.setSize("446px", "32px");
			
			Label lblToWhatExtent = new Label(constants.angry_if_deal_offered());
			lblToWhatExtent.setDirection(Direction.RTL);
			lblToWhatExtent.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(lblToWhatExtent, 340, 134);
					
			RadioButton radioButtonQuestions2_1 = new RadioButton("angerQuestion", constants.one());
			radioButtonQuestions2_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 219, 156);
			angerQuestion.add(radioButtonQuestions2_1);
					
			Label lblNotAtAll = new Label(constants.not_at_all());
			lblNotAtAll.setDirection(Direction.RTL);
			lblNotAtAll.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblNotAtAll, 115, 181);
			lblNotAtAll.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions2_2 = new RadioButton("angerQuestion", constants.two());
			radioButtonQuestions2_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 289, 156);
			angerQuestion.add(radioButtonQuestions2_2);
					
			RadioButton radioButtonQuestions2_3 = new RadioButton("angerQuestion", constants.three());
			radioButtonQuestions2_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 359, 156);
			angerQuestion.add(radioButtonQuestions2_3);
					
			RadioButton radioButtonQuestions2_4 = new RadioButton("angerQuestion", constants.four());
			radioButtonQuestions2_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions2_4, 429, 156);
			angerQuestion.add(radioButtonQuestions2_4);
					
			RadioButton radioButtonQuestions2_5 = new RadioButton("angerQuestion", constants.five());
			radioButtonQuestions2_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions2_5, 499, 156);
			angerQuestion.add(radioButtonQuestions2_5);
					
			RadioButton radioButtonQuestions2_6 = new RadioButton("angerQuestion", constants.six());
			radioButtonQuestions2_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions2_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions2_6, 569, 156);
			angerQuestion.add(radioButtonQuestions2_6);
					
			Label lblCompletelyAMoral = new Label(constants.a_lot());
			lblCompletelyAMoral.setDirection(Direction.RTL);
			lblCompletelyAMoral.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblCompletelyAMoral, 450, 183);
			lblCompletelyAMoral.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_1 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_1, 97, 229);
			verticalSplitPanel_1.setSize("446px", "32px");
			
			Label label = new Label(constants.considered_your_need());
			label.setDirection(Direction.RTL);
			label.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(label, 45, 279);
			label.setSize("573px", "16px");
			
			Label label_1 = new Label(constants.not_at_all());
			label_1.setDirection(Direction.RTL);
			label_1.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_1, 120, 326);
			label_1.setSize("129px", "19px");

			RadioButton radioButtonQuestions3_1 = new RadioButton("needQuestion", constants.one());
			radioButtonQuestions3_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 219, 301);
			radioButtonQuestions3_1.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_1);
			
			RadioButton radioButtonQuestions3_2 = new RadioButton("needQuestion", constants.two());
			radioButtonQuestions3_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 289, 301);
			radioButtonQuestions3_2.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_2);
			
			RadioButton radioButtonQuestions3_3 = new RadioButton("needQuestion", constants.three());
			radioButtonQuestions3_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 359, 301);
			radioButtonQuestions3_3.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_3);
			
			RadioButton radioButtonQuestions3_4 = new RadioButton("needQuestion", constants.four());
			radioButtonQuestions3_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions3_4, 429, 301);
			radioButtonQuestions3_4.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_4);
			
			RadioButton radioButtonQuestions3_5 = new RadioButton("needQuestion", constants.five());
			radioButtonQuestions3_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions3_5, 499, 301);
			radioButtonQuestions3_5.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_5);
			
			RadioButton radioButtonQuestions3_6 = new RadioButton("needQuestion", constants.six());
			radioButtonQuestions3_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions3_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions3_6, 569, 301);
			radioButtonQuestions3_6.setSize("29px", "19px");
			needQuestion.add(radioButtonQuestions3_6);
			
			Label label_2 = new Label(constants.a_lot());
			label_2.setDirection(Direction.RTL);
			label_2.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_2, 445, 326);
			label_2.setSize("149px", "19px");
			
		
			Label label_3 = new Label(constants.other_outcome_fair());
			label_3.setDirection(Direction.RTL);
			label_3.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(label_3, 132, 406);
			label_3.setSize("486px", "16px");
			
			RadioButton radioButtonQuestions4_1 = new RadioButton("otherFairQuestion", constants.one());
			radioButtonQuestions4_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 219, 431);
			radioButtonQuestions4_1.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_1);
			
			
			Label label_4 = new Label(constants.not_at_all_fair());
			label_4.setDirection(Direction.RTL);
			label_4.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_4, 120, 456);
			label_4.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions4_2 = new RadioButton("otherFairQuestion", constants.two());
			radioButtonQuestions4_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 289, 431);
			radioButtonQuestions4_2.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_2);
			
			RadioButton radioButtonQuestions4_3 = new RadioButton("otherFairQuestion", constants.three());
			radioButtonQuestions4_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions4_3, 359, 431);
			radioButtonQuestions4_3.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_3);
			
			RadioButton radioButtonQuestions4_4 = new RadioButton("otherFairQuestion", constants.four());
			radioButtonQuestions4_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions4_4, 429, 431);
			radioButtonQuestions4_4.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_4);
			
			RadioButton radioButtonQuestions4_5 = new RadioButton("otherFairQuestion", constants.five());
			radioButtonQuestions4_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions4_5, 499, 431);
			radioButtonQuestions4_5.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_5);
			
			RadioButton radioButtonQuestions4_6 = new RadioButton("otherFairQuestion", constants.six());
			radioButtonQuestions4_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions4_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions4_6, 569, 431);
			radioButtonQuestions4_6.setSize("29px", "19px");
			otherFairQuestion.add(radioButtonQuestions4_6);
			
			Label label_5 = new Label(constants.very_much_fair());
			label_5.setDirection(Direction.RTL);
			label_5.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_5, 469, 456);
			label_5.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_2 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_2, 97, 502);
			verticalSplitPanel_2.setSize("446px", "32px");
			
			Label label_6 = new Label(constants.angry_other_player());
			label_6.setDirection(Direction.RTL);
			label_6.setStylePrimaryName("gwt-SimpleRadioButtonfa");
			absolutePanel.add(label_6, 40, 552);
			label_6.setSize("573px", "16px");
			
			Label label_7 = new Label(constants.not_at_all());
			label_7.setDirection(Direction.RTL);
			label_7.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_7, 118, 600);
			label_7.setSize("129px", "19px");
			
			RadioButton radioButtonQuestions5_1 = new RadioButton("otherAngerQuestion", constants.one());
			radioButtonQuestions5_1.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 219, 575);
			radioButtonQuestions5_1.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_1);
			
			RadioButton radioButtonQuestions5_2 = new RadioButton("otherAngerQuestion", constants.two());
			radioButtonQuestions5_2.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 289, 575);
			radioButtonQuestions5_2.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_2);
			
			RadioButton radioButtonQuestions5_3 = new RadioButton("otherAngerQuestion", constants.three());
			radioButtonQuestions5_3.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions5_3, 359, 575);
			radioButtonQuestions5_3.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_3);
			
			RadioButton radioButtonQuestions5_4 = new RadioButton("otherAngerQuestion", constants.four());
			radioButtonQuestions5_4.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions5_4, 429, 575);
			radioButtonQuestions5_4.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_4);
			
			RadioButton radioButtonQuestions5_5 = new RadioButton("otherAngerQuestion", constants.five());
			radioButtonQuestions5_5.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions5_5, 499, 575);
			radioButtonQuestions5_5.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_5);
			
			RadioButton radioButtonQuestions5_6 = new RadioButton("otherAngerQuestion", constants.six());
			radioButtonQuestions5_6.setStylePrimaryName("RadioButton-style");
			radioButtonQuestions5_6.setFormValue("6");
			absolutePanel.add(radioButtonQuestions5_6, 569, 575);
			radioButtonQuestions5_6.setSize("29px", "19px");
			otherAngerQuestion.add(radioButtonQuestions5_6);
			
			
			Label label_8 = new Label(constants.a_lot());
			label_8.setDirection(Direction.RTL);
			label_8.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(label_8, 447, 600);
			label_8.setSize("149px", "19px");
			
			VerticalSplitPanel verticalSplitPanel_3 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel_3, 97, 358);
			verticalSplitPanel_3.setSize("446px", "32px");
			
			
		}
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
/*				experimentConditions.setAngeryWithDeal(Integer.parseInt(getAnswers (angerQuestion)));
				experimentConditions.setNegotationFair(Integer.parseInt(getAnswers (fairQuestion)));
				experimentConditions.setOtherConsideredYourNeeds(Integer.parseInt(getAnswers (needQuestion)));
				experimentConditions.setOtherAngeryWithDeal(Integer.parseInt(getAnswers (otherAngerQuestion)));
				experimentConditions.setOtherNegotationFair(Integer.parseInt(getAnswers (otherFairQuestion)));*/
				
				final DemographicsDialogBox dialogBox = new DemographicsDialogBox (eventBus, experimentConditions);
				dialogBox.center();
			}
		});
		btnSubmit.setSize("92px", "33px");
		absolutePanel.add(btnSubmit, 536, 636);
		
	}
	
	
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
}
