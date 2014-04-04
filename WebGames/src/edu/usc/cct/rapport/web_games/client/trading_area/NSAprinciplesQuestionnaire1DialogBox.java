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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;



@SuppressWarnings("deprecation")
public class NSAprinciplesQuestionnaire1DialogBox extends DialogBox  {

	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final private ExperimentConditions experimentConditions;

	//@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	final ArrayList<RadioButton> NSA_Question1 = new ArrayList<RadioButton>(); 
	final ArrayList<RadioButton> NSA_Question2 = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> NSA_Question3 = new ArrayList<RadioButton>();
	
	public NSAprinciplesQuestionnaire1DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;

		setHTML("Questionnaire");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		
		absolutePanel.setSize("650px", "490px");
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
    		
		if (localName == "en"){
			HTML html;
    		html = new HTML(constants.NSA_Question1());
			absolutePanel.add(html, 10, 25);			
			
			RadioButton radioButtonQuestions1_1  = new RadioButton("NSA_Question1");
			radioButtonQuestions1_1.setHTML(constants.NSA_Question1_1());
			radioButtonQuestions1_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions1_1, 20, 65);
			radioButtonQuestions1_1.setSize("266px", "19px");
			NSA_Question1.add(radioButtonQuestions1_1);
		
			RadioButton radioButtonQuestions1_2 = new RadioButton("NSA_Question1");
			radioButtonQuestions1_2.setHTML(constants.NSA_Question1_2());
			radioButtonQuestions1_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions1_2, 20, 90);
			radioButtonQuestions1_2.setSize("196px", "19px");
			NSA_Question1.add(radioButtonQuestions1_2);
		
			RadioButton radioButtonQuestions1_3 = new RadioButton("NSA_Question1");
			radioButtonQuestions1_3.setHTML(constants.NSA_Question1_3());
			radioButtonQuestions1_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions1_3, 20, 115);
			NSA_Question1.add(radioButtonQuestions1_3);
		
	    	VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 109, 140);
			verticalSplitPanel.setSize("446px", "32px");
			
	////////////////////////////////////////////////////////////////////////////////////		
    		HTML htmlb = new HTML(constants.NSA_Question2());
			absolutePanel.add(htmlb, 10, 190);
			
			RadioButton radioButtonQuestions2_1  = new RadioButton("NSA_Question2");
			radioButtonQuestions2_1.setHTML(constants.NSA_Question2_1());
			radioButtonQuestions2_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions2_1, 20, 215);
			radioButtonQuestions2_1.setSize("266px", "19px");
			NSA_Question2.add(radioButtonQuestions2_1);
		
			RadioButton radioButtonQuestions2_2 = new RadioButton("NSA_Question2");
			radioButtonQuestions2_2.setHTML(constants.NSA_Question2_2());
			radioButtonQuestions2_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions2_2, 20, 240);
			radioButtonQuestions2_2.setSize("196px", "19px");
			NSA_Question2.add(radioButtonQuestions2_2);
		
			RadioButton radioButtonQuestions2_3 = new RadioButton("NSA_Question2");
			radioButtonQuestions2_3.setHTML(constants.NSA_Question2_3());
			radioButtonQuestions2_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions2_3, 20, 265);
			NSA_Question2.add(radioButtonQuestions2_3);
		
	    	VerticalSplitPanel verticalSplitPanel2 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel2, 109, 290);
			verticalSplitPanel2.setSize("446px", "32px");
////////////////////////////////////////////////////////////////////////////////////////
    		HTML htmlc = new HTML(constants.NSA_Question3());
			absolutePanel.add(htmlc, 10, 340);
			
			RadioButton radioButtonQuestions3_1  = new RadioButton("NSA_Question3");
			radioButtonQuestions3_1.setHTML(constants.NSA_Question3_1());
			radioButtonQuestions3_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions3_1, 20, 380);
			radioButtonQuestions3_1.setSize("266px", "19px");
			NSA_Question3.add(radioButtonQuestions3_1);
		
			RadioButton radioButtonQuestions3_2 = new RadioButton("NSA_Question3");
			radioButtonQuestions3_2.setHTML(constants.NSA_Question3_2());
			radioButtonQuestions3_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions3_2, 20, 405);
			radioButtonQuestions3_2.setSize("196px", "19px");
			NSA_Question3.add(radioButtonQuestions3_2);
		
			RadioButton radioButtonQuestions3_3 = new RadioButton("NSA_Question3");
			radioButtonQuestions3_3.setHTML(constants.NSA_Question3_3());
			radioButtonQuestions3_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions3_3, 20, 430);
			NSA_Question3.add(radioButtonQuestions3_3);
		}

    	Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(!getAnswers (NSA_Question1).equals("0") & !getAnswers (NSA_Question2).equals("0") & !getAnswers (NSA_Question3).equals("0")){
					hide();
					experimentConditions.setNSA_01(Integer.parseInt(getAnswers (NSA_Question1)));
					experimentConditions.setNSA_02(Integer.parseInt(getAnswers (NSA_Question2)));
					experimentConditions.setNSA_03(Integer.parseInt(getAnswers (NSA_Question3)));
					final NSAprinciplesQuestionnaire2DialogBox dialogBox = new NSAprinciplesQuestionnaire2DialogBox(eventBus, experimentConditions);
					dialogBox.center();
					}

			}
		});
		btnSubmit.setSize("92px", "33px");
		absolutePanel.add(btnSubmit, 527, 450);
		
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