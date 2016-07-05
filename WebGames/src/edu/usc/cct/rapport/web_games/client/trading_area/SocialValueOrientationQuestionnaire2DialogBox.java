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


public class SocialValueOrientationQuestionnaire2DialogBox extends DialogBox {

	final int maxQuestionNo = 5;
	final int maxAnswerNo 	= 9;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	private ArrayList<HTML> questions = new ArrayList<HTML>();
	private ArrayList<ArrayList<HTML>> possibleAnswers = new ArrayList<ArrayList<HTML>>();
	private ArrayList<HTML> possibleAnswersQ2 = new ArrayList<HTML>();
	private ArrayList<HTML> possibleAnswersQ3 = new ArrayList<HTML>();
	private ArrayList<HTML> possibleAnswersQ4 = new ArrayList<HTML>();
	private ArrayList<HTML> possibleAnswersQ5 = new ArrayList<HTML>();
	private ArrayList<HTML> possibleAnswersQ6 = new ArrayList<HTML>();
	AbsolutePanel absolutePanel = new AbsolutePanel();	
	
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public SocialValueOrientationQuestionnaire2DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		this.setHTML(constants.blank());
		
		setWidget(absolutePanel);
/*		HTML explanation1 = new HTML();	    		
		explanation1 = new HTML(constants.svo_explanation_part1());
		
		Image exampleImage = new Image();
		exampleImage.setUrl("http://shiraz.usc.edu/negotiation/images/SVO_example.png");
		exampleImage.setWidth("780px");

		HTML explanation2 = new HTML();	    		
		explanation2 = new HTML(constants.svo_explanation_part2());*/

		questions.add(new HTML(constants.svo2()));
		questions.add(new HTML(constants.svo3()));
		questions.add(new HTML(constants.svo4()));
		questions.add(new HTML(constants.svo5()));
		questions.add(new HTML(constants.svo6()));
		possibleAnswersQ2.add(new HTML(constants.svo2_1()));
		possibleAnswersQ2.add(new HTML(constants.svo2_2()));
		possibleAnswersQ2.add(new HTML(constants.svo2_3()));
		possibleAnswersQ2.add(new HTML(constants.svo2_4()));
		possibleAnswersQ2.add(new HTML(constants.svo2_5()));
		possibleAnswersQ2.add(new HTML(constants.svo2_6()));
		possibleAnswersQ2.add(new HTML(constants.svo2_7()));
		possibleAnswersQ2.add(new HTML(constants.svo2_8()));
		possibleAnswersQ2.add(new HTML(constants.svo2_9()));
		possibleAnswersQ3.add(new HTML(constants.svo3_1()));
		possibleAnswersQ3.add(new HTML(constants.svo3_2()));
		possibleAnswersQ3.add(new HTML(constants.svo3_3()));
		possibleAnswersQ3.add(new HTML(constants.svo3_4()));
		possibleAnswersQ3.add(new HTML(constants.svo3_5()));
		possibleAnswersQ3.add(new HTML(constants.svo3_6()));
		possibleAnswersQ3.add(new HTML(constants.svo3_7()));
		possibleAnswersQ3.add(new HTML(constants.svo3_8()));
		possibleAnswersQ3.add(new HTML(constants.svo3_9()));
		possibleAnswersQ4.add(new HTML(constants.svo4_1()));
		possibleAnswersQ4.add(new HTML(constants.svo4_2()));
		possibleAnswersQ4.add(new HTML(constants.svo4_3()));
		possibleAnswersQ4.add(new HTML(constants.svo4_4()));
		possibleAnswersQ4.add(new HTML(constants.svo4_5()));
		possibleAnswersQ4.add(new HTML(constants.svo4_6()));
		possibleAnswersQ4.add(new HTML(constants.svo4_7()));
		possibleAnswersQ4.add(new HTML(constants.svo4_8()));
		possibleAnswersQ4.add(new HTML(constants.svo4_9()));
		possibleAnswersQ5.add(new HTML(constants.svo5_1()));
		possibleAnswersQ5.add(new HTML(constants.svo5_2()));
		possibleAnswersQ5.add(new HTML(constants.svo5_3()));
		possibleAnswersQ5.add(new HTML(constants.svo5_4()));
		possibleAnswersQ5.add(new HTML(constants.svo5_5()));
		possibleAnswersQ5.add(new HTML(constants.svo5_6()));
		possibleAnswersQ5.add(new HTML(constants.svo5_7()));
		possibleAnswersQ5.add(new HTML(constants.svo5_8()));
		possibleAnswersQ5.add(new HTML(constants.svo5_9()));
		possibleAnswersQ6.add(new HTML(constants.svo6_1()));
		possibleAnswersQ6.add(new HTML(constants.svo6_2()));
		possibleAnswersQ6.add(new HTML(constants.svo6_3()));
		possibleAnswersQ6.add(new HTML(constants.svo6_4()));
		possibleAnswersQ6.add(new HTML(constants.svo6_5()));
		possibleAnswersQ6.add(new HTML(constants.svo6_6()));
		possibleAnswersQ6.add(new HTML(constants.svo6_7()));
		possibleAnswersQ6.add(new HTML(constants.svo6_8()));
		possibleAnswersQ6.add(new HTML(constants.svo6_9()));
		possibleAnswers.add(possibleAnswersQ2);
		possibleAnswers.add(possibleAnswersQ3);
		possibleAnswers.add(possibleAnswersQ4);		
		possibleAnswers.add(possibleAnswersQ5);		
		possibleAnswers.add(possibleAnswersQ6);		

		for(int i=0; i<maxQuestionNo; i++) {
			flexTable.getCellFormatter().setWidth( i*2, 0, "150px");
			flexTable.getCellFormatter().setHeight(i*2, 0, "69px");
			flexTable.getCellFormatter().setWidth( i*2+1, 0, "150px");
			flexTable.getCellFormatter().setHeight(i*2+1, 0,  "17px");
		}

		for(int i=0; i<maxAnswerNo; i++) {
			flexTable.getCellFormatter().setWidth(0, i+1, "63px");
			flexTable.getCellFormatter().setHorizontalAlignment(0, i+1, HasHorizontalAlignment.ALIGN_CENTER);
		}
		
		setQuestion(0, experimentConditions);

		applyDataRowStyles();
//		Label questionNo2 = new Label("2.");
//		questionNo2.setStylePrimaryName("Label-style");
//		absolutePanel.add(questionNo2, 10, 10);

		absolutePanel.add(flexTable, 30, 10);
//		absolutePanel.add(flexTable, 10, 10);
		absolutePanel.setSize("800px", "565px");
	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
		
		for(int row=0; row<flexTable.getRowCount(); row++) {
			for(int col=0; col<=maxAnswerNo; col++) {
				if(row%4 == 0 || row%4 == 1)
					flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
				else
					flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			}
		}
	}
	
	public void applyDataRowStylesAgain(int row) {
		for(int col=1; col<=maxAnswerNo; col++) {
			if(row%4 == 0 || row%4 == 1)			
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
			else
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
		}
	}

	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions) {
		flexTable.setWidget(currentQuestionNo*2, 0, questions.get(currentQuestionNo));
		Label questionNo = new Label(currentQuestionNo+2+".");
		questionNo.setStylePrimaryName("Label-style");
		absolutePanel.add(questionNo, 10, 12+95*currentQuestionNo);
		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i);
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2, i+1, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo*2, i+1, possibleAnswers.get(currentQuestionNo).get(i));
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2+1, i+1, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo*2+1, i+1, radioButton);

			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
					applyDataRowStylesAgain(currentQuestionNo*2);
					applyDataRowStylesAgain(currentQuestionNo*2+1);
					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2+1, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");

					if(currentQuestionNo < maxQuestionNo-1 && currentQuestionNo+1 == currentMaxQuestionNo-1) {
						currentMaxQuestionNo = currentMaxQuestionNo+1;
						setQuestion(currentQuestionNo+1, experimentConditions);
					} else if(currentQuestionNo < maxQuestionNo-1) {
						// do nothing
					} else {
						submit(experimentConditions);
					}
				}
			});
		}
	}
	
	public void submit(final ExperimentConditions experimentConditions) {
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				experimentConditions.setSVO_2(userAnswer[0]);
				experimentConditions.setSVO_3(userAnswer[1]);
				experimentConditions.setSVO_4(userAnswer[2]);
				experimentConditions.setSVO_5(userAnswer[3]);
				experimentConditions.setSVO_6(userAnswer[4]);

				final DemographicsDialogBox dialogBox = new DemographicsDialogBox(eventBus, experimentConditions);
				dialogBox.setPopupPosition(105, 75);
				dialogBox.show();
//				final SocialValueOrientationQuestionnaire2DialogBox dialogBox = new SocialValueOrientationQuestionnaire2DialogBox (eventBus, experimentConditions);
//				dialogBox.center();
				hide();
			}
		});

		btnSubmit.setSize("250px", "33px");
//		absolutePanel.add(btnSubmit, 250, 500);
		absolutePanel.add(btnSubmit, 307, 510);
	}	
}

