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
public class NSAprinciplesQuestionnaire2DialogBox extends DialogBox  {

	@SuppressWarnings("unused")
	final private EventBus eventBus;
	final private ExperimentConditions experimentConditions;

	//@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	final ArrayList<RadioButton> NSA_Question4 = new ArrayList<RadioButton>();
	final ArrayList<RadioButton> NSA_Question5 = new ArrayList<RadioButton>();
	
	public NSAprinciplesQuestionnaire2DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;

		setHTML("Questionnaire");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		
		absolutePanel.setSize("650px", "425px");
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
    		
		if (localName == "en"){
			HTML html;
			HTML htmld = new HTML(constants.NSA_Question4());
			absolutePanel.add(htmld, 10, 25);
			
			RadioButton radioButtonQuestions4_1  = new RadioButton("NSA_Question4");
			radioButtonQuestions4_1.setHTML(constants.NSA_Question4_1());
			radioButtonQuestions4_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions4_1, 20, 50);
			radioButtonQuestions4_1.setSize("266px", "19px");
			NSA_Question4.add(radioButtonQuestions4_1);
		
			RadioButton radioButtonQuestions4_2 = new RadioButton("NSA_Question4");
			radioButtonQuestions4_2.setHTML(constants.NSA_Question4_2());
			radioButtonQuestions4_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions4_2, 20, 75);
			radioButtonQuestions4_2.setSize("196px", "19px");
			NSA_Question4.add(radioButtonQuestions4_2);
		
			RadioButton radioButtonQuestions4_3 = new RadioButton("NSA_Question4");
			radioButtonQuestions4_3.setHTML(constants.NSA_Question4_3());
			radioButtonQuestions4_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions4_3, 20, 100);
			NSA_Question4.add(radioButtonQuestions4_3);
		
			RadioButton radioButtonQuestions4_4 = new RadioButton("NSA_Question4");
			radioButtonQuestions4_4.setHTML(constants.NSA_Question4_4());
			radioButtonQuestions4_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions4_4, 20, 125);
			NSA_Question4.add(radioButtonQuestions4_4);
			
			RadioButton radioButtonQuestions4_5 = new RadioButton("NSA_Question4");
			radioButtonQuestions4_5.setHTML(constants.NSA_Question4_5());
			radioButtonQuestions4_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions4_5, 20, 150);
			NSA_Question4.add(radioButtonQuestions4_5);

	    	VerticalSplitPanel verticalSplitPanel4 = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel4, 109, 175);
			verticalSplitPanel4.setSize("446px", "32px");

///////////////////////////////////////////////////////////////////////////////////////
			HTML htmle = new HTML(constants.NSA_Question5());
			absolutePanel.add(htmle, 10, 225);
			
			RadioButton radioButtonQuestions5_1  = new RadioButton("NSA_Question5");
			radioButtonQuestions5_1.setHTML(constants.NSA_Question4_1());
			radioButtonQuestions5_1.setFormValue("1");
			absolutePanel.add(radioButtonQuestions5_1, 20, 265);
			radioButtonQuestions5_1.setSize("266px", "19px");
			NSA_Question5.add(radioButtonQuestions5_1);
			
			RadioButton radioButtonQuestions5_2 = new RadioButton("NSA_Question5");
			radioButtonQuestions5_2.setHTML(constants.NSA_Question4_2());
			radioButtonQuestions5_2.setFormValue("2");
			absolutePanel.add(radioButtonQuestions5_2, 20, 290);
			radioButtonQuestions5_2.setSize("196px", "19px");
			NSA_Question5.add(radioButtonQuestions5_2);
			
			RadioButton radioButtonQuestions5_3 = new RadioButton("NSA_Question5");
			radioButtonQuestions5_3.setHTML(constants.NSA_Question4_3());
			radioButtonQuestions5_3.setFormValue("3");
			absolutePanel.add(radioButtonQuestions5_3, 20, 315);
			NSA_Question5.add(radioButtonQuestions5_3);
			
			RadioButton radioButtonQuestions5_4 = new RadioButton("NSA_Question5");
			radioButtonQuestions5_4.setHTML(constants.NSA_Question4_4());
			radioButtonQuestions5_4.setFormValue("4");
			absolutePanel.add(radioButtonQuestions5_4, 20, 340);
			NSA_Question5.add(radioButtonQuestions5_4);
			
			RadioButton radioButtonQuestions5_5 = new RadioButton("NSA_Question5");
			radioButtonQuestions5_5.setHTML(constants.NSA_Question4_5());
			radioButtonQuestions5_5.setFormValue("5");
			absolutePanel.add(radioButtonQuestions5_5, 20, 365);
			NSA_Question5.add(radioButtonQuestions5_5);
			
		}

    	Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(!getAnswers (NSA_Question4).equals("0") & !getAnswers (NSA_Question5).equals("0")){
					hide();
					experimentConditions.setNSA_04(Integer.parseInt(getAnswers (NSA_Question4)));
					experimentConditions.setNSA_05(Integer.parseInt(getAnswers (NSA_Question5)));
					final DemographicsDialogBox dialogBox = new DemographicsDialogBox (eventBus, experimentConditions);
					dialogBox.center();
					}
			}
		});
		btnSubmit.setSize("92px", "33px");
		//absolutePanel.add(btnSubmit, 527, 476);
		absolutePanel.add(btnSubmit, 527, 385);
		
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