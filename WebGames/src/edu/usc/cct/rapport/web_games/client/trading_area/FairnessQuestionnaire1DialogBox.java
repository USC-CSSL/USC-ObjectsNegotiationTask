package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.AlgorithmicCounterpartDecisionMakingStrategyEnum;


public class FairnessQuestionnaire1DialogBox extends DialogBox {

	final int maxQuestionNo = 1;
	final int maxAnswerNo 	= 8;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	private ArrayList<HTML> questions = new ArrayList<HTML>();
	private ArrayList<ArrayList<HTML>> possibleAnswers = new ArrayList<ArrayList<HTML>>();
//	private ArrayList<HTML> possibleAnswersQ1 = new ArrayList<HTML>();
//	private ArrayList<HTML> possibleAnswersQ2 = new ArrayList<HTML>();
	AbsolutePanel absolutePanel = new AbsolutePanel();	
	
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public FairnessQuestionnaire1DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions, final int plyRemaining) {
		super(false, true);
		this.eventBus = eventBus;
//		setHTML("Questionnaire");
		this.setHTML(constants.blank());
		
		setWidget(absolutePanel);
		HTML explanation1 = new HTML();	    		
		if(experimentConditions.getPartnerLabel()==0)
			explanation1 = new HTML(constants.fairness_explanation_offer1_part1_computer_partner());
		else if(experimentConditions.getPartnerLabel()==1)
			explanation1 = new HTML(constants.fairness_explanation_offer1_part1_human_partner());
		
//		explanation1.setText(Integer.toString(plyRemaining)); // for testing

		Image offer = new Image();
		offer.setWidth("450px");
		if(experimentConditions.getPartnerLabel()==0) {	
			if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedSoftGentleSlopeStrategyFruits1)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits1_offer1_c.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedSoftSteepSlopeStrategyFruits3)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits3_offer1_c.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedToughGentleSlopeStrategyFruits5)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits5_offer1_c.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedToughSteepSlopeStrategyFruits7)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits7_offer1_c.png");
			}			
		} else if (experimentConditions.getPartnerLabel()==1) {
			if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedSoftGentleSlopeStrategyFruits1)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits1_offer1_h.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedSoftSteepSlopeStrategyFruits3)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits3_offer1_h.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedToughGentleSlopeStrategyFruits5)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits5_offer1_h.png");
			} else if(experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedToughSteepSlopeStrategyFruits7)) {
				offer.setUrl("http://shiraz.usc.edu/negotiation/images/fruits7_offer1_h.png");
			}
		}

		HTML explanation2 = new HTML();	    		
		if(experimentConditions.getPartnerLabel()==0)
			explanation2 = new HTML(constants.fairness_explanation_offer1_part2_computer_partner());
		else if(experimentConditions.getPartnerLabel()==1)
			explanation2 = new HTML(constants.fairness_explanation_offer1_part2_human_partner());

		
//		flexTable.setText(0, 1, constants.mfq_explanation_part1_zero());
		flexTable.setHTML(0, 0, constants.fairness_explanation_zero());
		flexTable.setHTML(0, 1, constants.fairness_explanation_one());
		flexTable.setHTML(0, 2, constants.fairness_explanation_two());
		flexTable.setHTML(0, 3, constants.fairness_explanation_three());
		flexTable.setHTML(0, 4, constants.fairness_explanation_four());
		flexTable.setHTML(0, 5, constants.fairness_explanation_five());
		flexTable.setHTML(0, 6, constants.fairness_explanation_six());
		flexTable.setHTML(0, 7, constants.fairness_explanation_seven());
/*		flexTable.setText(1, 0, constants.zero());
		flexTable.setText(1, 1, constants.one());
		flexTable.setText(1, 2, constants.two());
		flexTable.setText(1, 3, constants.three());
		flexTable.setText(1, 4, constants.four());
		flexTable.setText(1, 5, constants.five());
		flexTable.setText(1, 6, constants.six());
		flexTable.setText(1, 7, constants.seven());*/

		
/*		questions.add(new HTML(constants.svo1()));
		possibleAnswersQ1.add(new HTML(constants.svo1_1()));
		possibleAnswersQ1.add(new HTML(constants.svo1_2()));
		possibleAnswersQ1.add(new HTML(constants.svo1_3()));
		possibleAnswersQ1.add(new HTML(constants.svo1_4()));
		possibleAnswersQ1.add(new HTML(constants.svo1_5()));
		possibleAnswersQ1.add(new HTML(constants.svo1_6()));
		possibleAnswersQ1.add(new HTML(constants.svo1_7()));
		possibleAnswersQ1.add(new HTML(constants.svo1_8()));
		possibleAnswersQ1.add(new HTML(constants.svo1_9()));
		possibleAnswers.add(possibleAnswersQ1);
		possibleAnswers.add(possibleAnswersQ2);		


//		for(int i=0; i<questions.size(); i++)
//			questions.get(i).setStylePrimaryName("Label-style");
		
		for(int i=0; i<maxQuestionNo; i++) {
//			for(int j=0; j<maxAnswerNo; j++) {
//				flexTable.setText(2+i, 1+j, " ");
//				flexTable.getCellFormatter().setWidth(2+i, 0, "350px");
//				flexTable.getCellFormatter().setHeight(2+i, 0, "40px");
				flexTable.getCellFormatter().setWidth( i*2, 0, "150px");
				flexTable.getCellFormatter().setHeight(i*2, 0, "69px");
				flexTable.getCellFormatter().setWidth( i*2+1, 0, "150px");
				flexTable.getCellFormatter().setHeight(i*2+1, 0,  "17px");
//			}
		}*/

		for(int i=0; i<maxAnswerNo; i++) {
			flexTable.getCellFormatter().setWidth(0, i, "95px");
			flexTable.getCellFormatter().setHorizontalAlignment(0, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.getCellFormatter().setHorizontalAlignment(1, i, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.getCellFormatter().setHorizontalAlignment(2, i, HasHorizontalAlignment.ALIGN_CENTER);
		}
		
		setQuestion(0, experimentConditions, plyRemaining);

		applyDataRowStyles();
		absolutePanel.add(explanation1, 160, 10);
		absolutePanel.add(offer, 150, 30); // offer image
		absolutePanel.add(explanation2, 15, 385);
		
//		Label questionNo1 = new Label("1.");
//		questionNo1.setStylePrimaryName("Label-style");
//		absolutePanel.add(questionNo1, 10, 390);

		absolutePanel.add(flexTable, 10, 410);
//		absolutePanel.add(flexTable, 10, 390);
		absolutePanel.setSize("800px", "565px");
	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
		
		for(int row=0; row<flexTable.getRowCount(); row++) {
			for(int col=0; col<maxAnswerNo; col++) {
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			}
		}

		
	}
	
	public void applyDataRowStylesAgain() {
		for(int col=0; col<maxAnswerNo; col++) {
			flexTable.getCellFormatter().setStyleName(0, col, "FlexTable-OddRow");
			flexTable.getCellFormatter().setStyleName(1, col, "FlexTable-OddRow");
//			flexTable.getCellFormatter().setStyleName(2, col, "FlexTable-OddRow");
		}
	}
	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions, final int plyRemaining) {
//		flexTable.setWidget(2+currentQuestionNo, 0, questions_label.get(currentQuestionNo));
//		flexTable.setWidget(currentQuestionNo*2, 0, questions.get(currentQuestionNo));
		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i);
//			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2, i+1, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.setWidget(currentQuestionNo*2, i+1, possibleAnswers.get(currentQuestionNo).get(i));
//			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2+1, i+1, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.setWidget(currentQuestionNo*2+1, i+1, radioButton);
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo+1, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo+1, i, radioButton);


			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
					applyDataRowStylesAgain();

//					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");
//					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2+1, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(currentQuestionNo, radioButton.getTabIndex(), "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(currentQuestionNo+1, radioButton.getTabIndex(), "FlexTable-SelectedCell");
//					flexTable.getCellFormatter().setStyleName(currentQuestionNo+2, radioButton.getTabIndex(), "FlexTable-SelectedCell");

					if(currentQuestionNo < maxQuestionNo-1 && currentQuestionNo+1 == currentMaxQuestionNo-1) {
						currentMaxQuestionNo = currentMaxQuestionNo+1;
						setQuestion(currentQuestionNo+1, experimentConditions, plyRemaining);
					} else if(currentQuestionNo < maxQuestionNo-1) {
						// do nothing
					} else {
						submit(experimentConditions, plyRemaining);
					}
				}
			});
		}
	}
	
	public void submit(final ExperimentConditions experimentConditions, final int plyRemaining) {
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(plyRemaining < 24) {// if the participant saw the agent's second offer
					final FairnessQuestionnaire2DialogBox dialogBox = new FairnessQuestionnaire2DialogBox (eventBus, experimentConditions, plyRemaining);
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				} else {
					final SocialValueOrientationQuestionnaire1DialogBox dialogBox = new SocialValueOrientationQuestionnaire1DialogBox (eventBus, experimentConditions);
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				}
				hide();
				experimentConditions.setFairnessOfTheAgentOffer_1(userAnswer[0]);

			}
		});

		btnSubmit.setSize("250px", "33px");
//		absolutePanel.add(btnSubmit, 250, 500);
		absolutePanel.add(btnSubmit, 307, 510);
	}	
}

