package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalSplitPanel;

import java.util.ArrayList;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


@SuppressWarnings("deprecation")
public class ValueOfExpressionQuestionnaireDialogBox extends DialogBox {

	final ArrayList<ListBox> veq_questions = new ArrayList<ListBox>();
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;

//	@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public ValueOfExpressionQuestionnaireDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
	
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML("");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);

		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		int spacing = 10;
		int spacing_between_explanation = 20;
		int spacing_between_questions 	= 30;
		int spacing_one_more_line 	  	= 15;
	    
		if (localName == "en" || localName == "ko"){

			int one_line_length = 100;
			if(localName == "ko")
				one_line_length = 50;
			
			ArrayList<Label> veq_questions_label = new ArrayList<Label>();
			veq_questions_label.add(new Label(constants.veq01()));
			veq_questions_label.add(new Label(constants.veq02()));
			veq_questions_label.add(new Label(constants.veq03()));
			veq_questions_label.add(new Label(constants.veq04()));
			veq_questions_label.add(new Label(constants.veq05()));
			veq_questions_label.add(new Label(constants.veq06()));
			veq_questions_label.add(new Label(constants.veq07()));
			veq_questions_label.add(new Label(constants.veq08()));
			veq_questions_label.add(new Label(constants.veq09()));
			veq_questions_label.add(new Label(constants.veq10()));
			veq_questions_label.add(new Label(constants.veq11()));

			ArrayList<Label> veq_explanation_label = new ArrayList<Label>();
			veq_explanation_label.add(new Label(constants.veq_explanation()));
			veq_explanation_label.add(new Label(constants.veq_explanation_one()));
			veq_explanation_label.add(new Label(constants.veq_explanation_two()));
			veq_explanation_label.add(new Label(constants.veq_explanation_three()));
			veq_explanation_label.add(new Label(constants.veq_explanation_four()));
			veq_explanation_label.add(new Label(constants.veq_explanation_five()));
			veq_explanation_label.add(new Label(constants.veq_explanation_six()));
			veq_explanation_label.add(new Label(constants.veq_explanation_seven()));
			veq_explanation_label.add(new Label(constants.veq_explanation_eight()));

			for(int i=0; i<veq_explanation_label.size(); i++) {
				veq_explanation_label.get(i).setStylePrimaryName("Label-style");

				absolutePanel.add(veq_explanation_label.get(i), 10, spacing);
				if(veq_explanation_label.get(i).getText().length() > one_line_length) {
					spacing = spacing + 2*spacing_between_explanation;
				} else { 
					spacing = spacing + spacing_between_explanation;
				}
			}
			spacing = spacing + 10;
			
			VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
			absolutePanel.add(verticalSplitPanel, 97, spacing);
			verticalSplitPanel.setSize("446px", "15px");
			spacing = spacing + 35;

			for(int i=0; i<veq_questions_label.size(); i++) {
				veq_questions_label.get(i).setStylePrimaryName("Label-style");
				absolutePanel.add(veq_questions_label.get(i), 65, spacing);
				
				ListBox veq = new ListBox();
				veq.addItem("");
				veq.addItem(constants.one());
				veq.addItem(constants.two());
				veq.addItem(constants.three());
				veq.addItem(constants.four());
				veq.addItem(constants.five());
				veq.addItem(constants.six());
				veq.addItem(constants.seven());
				veq.addItem(constants.eight());
	
				veq_questions.add(veq);
				absolutePanel.add(veq_questions.get(i), 10, spacing);
				
				veq_questions_label.get(i).setStylePrimaryName("Label-style");
				absolutePanel.add(veq_questions_label.get(i), 65, spacing);

				if(veq_questions_label.get(i).getText().length() > one_line_length) {
					spacing = spacing + spacing_between_questions + spacing_one_more_line;
				} else { 
					spacing = spacing + spacing_between_questions;
				}
			}
		}
	
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				experimentConditions.setVEQ_01(Integer.parseInt(getAnswers(veq_questions.get(0))));
				experimentConditions.setVEQ_02(Integer.parseInt(getAnswers(veq_questions.get(1))));
				experimentConditions.setVEQ_03(Integer.parseInt(getAnswers(veq_questions.get(2))));
				experimentConditions.setVEQ_04(Integer.parseInt(getAnswers(veq_questions.get(3))));
				experimentConditions.setVEQ_05(Integer.parseInt(getAnswers(veq_questions.get(4))));
				experimentConditions.setVEQ_06(Integer.parseInt(getAnswers(veq_questions.get(5))));
				experimentConditions.setVEQ_07(Integer.parseInt(getAnswers(veq_questions.get(6))));
				experimentConditions.setVEQ_08(Integer.parseInt(getAnswers(veq_questions.get(7))));
				experimentConditions.setVEQ_09(Integer.parseInt(getAnswers(veq_questions.get(8))));
				experimentConditions.setVEQ_10(Integer.parseInt(getAnswers(veq_questions.get(9))));
				experimentConditions.setVEQ_11(Integer.parseInt(getAnswers(veq_questions.get(10))));
				
				final DemographicsDialogBox dialogBox = new DemographicsDialogBox (eventBus, experimentConditions);
				dialogBox.center();
			}
		});
		
		btnSubmit.setSize("200px", "33px");
		absolutePanel.add(btnSubmit, 225, spacing);
		
		spacing = spacing + 40;
		String absolutePanelHeight = String.valueOf(spacing)+"px";
		absolutePanel.setSize("650px", absolutePanelHeight);
	}
	
	public String getAnswers(final ListBox questions){
		String value = "";
		value = questions.getItemText(questions.getSelectedIndex());
		if (value.isEmpty())
			value = "-1";

		return value;
	}
	
/*	public String getAnswers(final ArrayList<RadioButton> questions){
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
	};*/
	
}
