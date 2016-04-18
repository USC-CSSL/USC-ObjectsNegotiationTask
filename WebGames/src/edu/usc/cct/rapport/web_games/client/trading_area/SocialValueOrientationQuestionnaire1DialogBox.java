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


public class SocialValueOrientationQuestionnaire1DialogBox extends DialogBox {

	final int maxQuestionNo = 1;
	final int maxAnswerNo 	= 9;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	private ArrayList<HTML> questions = new ArrayList<HTML>();
	private ArrayList<ArrayList<HTML>> possibleAnswers = new ArrayList<ArrayList<HTML>>();
	private ArrayList<HTML> possibleAnswersQ1 = new ArrayList<HTML>();
	private ArrayList<HTML> possibleAnswersQ2 = new ArrayList<HTML>();
	AbsolutePanel absolutePanel = new AbsolutePanel();	
	
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public SocialValueOrientationQuestionnaire1DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
//		setHTML("Questionnaire");
		this.setHTML(constants.blank());
		
		setWidget(absolutePanel);
		HTML explanation1 = new HTML();	    		
		explanation1 = new HTML(constants.svo_explanation_part1());
		
		Image exampleImage = new Image();
		exampleImage.setUrl("http://shiraz.usc.edu/negotiation/images/SVO_example.png");
		exampleImage.setWidth("790px");

		HTML explanation2 = new HTML();	    		
		explanation2 = new HTML(constants.svo_explanation_part2());

		questions.add(new HTML(constants.svo1()));
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
		}

		for(int i=0; i<maxAnswerNo; i++) {
			flexTable.getCellFormatter().setWidth(0, i+1, "63px");
			flexTable.getCellFormatter().setHorizontalAlignment(0, i+1, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.getCellFormatter().setHorizontalAlignment(0, i+1, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.getCellFormatter().setHorizontalAlignment(1, i, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.getCellFormatter().setWidth(2, i+1, "60px");
		}
		
		setQuestion(0, experimentConditions);

		applyDataRowStyles();
		absolutePanel.add(explanation1, 10, 10);
		absolutePanel.add(exampleImage, 10, 160); // example image
		absolutePanel.add(explanation2, 10, 305);
		
		Label questionNo1 = new Label("1.");
		questionNo1.setStylePrimaryName("Label-style");
		absolutePanel.add(questionNo1, 10, 390);

		absolutePanel.add(flexTable, 30, 390);
//		absolutePanel.add(flexTable, 10, 390);
		absolutePanel.setSize("800px", "565px");
	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
/*		HTMLTable.RowFormatter rf = flexTable.getRowFormatter();
		
//		rf.addStyleName(0, "FlexTable-ColumnLabel");
//		rf.addStyleName(1, "FlexTable-ColumnChoice");
		
//		for(int row=2; row<flexTable.getRowCount(); ++row) {
		for(int row=0; row<flexTable.getRowCount(); row++) {
//			if(row%2 != 0)
			if(row%4 == 0 || row%4 == 1)
				rf.addStyleName(row, "FlexTable-EvenRow");
//				rf.addStyleName(row, "FlexTable-EvenRowWithBorder");
			else
				rf.addStyleName(row, "FlexTable-OddRow");
//				rf.addStyleName(row, "FlexTable-OddRowWithBorder");
		}*/
		
		for(int row=0; row<flexTable.getRowCount(); row++) {
			for(int col=0; col<=maxAnswerNo; col++) {
				if(row%4 == 0 || row%4 == 1)
					flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
				else
					flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			}
		}

		
	}
	
/*	public void applyDataRowStylesAgain(int row) {
		for(int col=1; col<=maxAnswerNo; col++) {
//			if(row%2 != 0)
			if(row%4 == 0 || row%4 == 1)			
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			else
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
		}
	}*/
	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions) {
//		flexTable.setWidget(2+currentQuestionNo, 0, questions_label.get(currentQuestionNo));
		flexTable.setWidget(currentQuestionNo*2, 0, questions.get(currentQuestionNo));
		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i);
//			flexTable.getCellFormatter().setHorizontalAlignment(2+currentQuestionNo, i+1, HasHorizontalAlignment.ALIGN_CENTER);
//			flexTable.setWidget(2+currentQuestionNo, i+1, radioButton);
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2, i+1, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo*2, i+1, possibleAnswers.get(currentQuestionNo).get(i));
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2+1, i+1, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo*2+1, i+1, radioButton);


			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
//					applyDataRowStylesAgain(2+currentQuestionNo);
//					applyDataRowStylesAgain(currentQuestionNo*2);
//					applyDataRowStylesAgain(currentQuestionNo*2+1);
//					flexTable.getCellFormatter().setStyleName(2+currentQuestionNo, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");
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
				hide();
				experimentConditions.setSVO_1(userAnswer[0]);
				
				final SocialValueOrientationQuestionnaire2DialogBox dialogBox = new SocialValueOrientationQuestionnaire2DialogBox (eventBus, experimentConditions);
//				dialogBox.center();
				dialogBox.setPopupPosition(105, 75);
				dialogBox.show();
			}
		});

		btnSubmit.setSize("250px", "33px");
//		absolutePanel.add(btnSubmit, 250, 500);
		absolutePanel.add(btnSubmit, 307, 510);
	}	
}

