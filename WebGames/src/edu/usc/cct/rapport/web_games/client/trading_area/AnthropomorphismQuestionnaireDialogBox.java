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

import java.util.ArrayList;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


public class AnthropomorphismQuestionnaireDialogBox extends DialogBox {

	final int maxQuestionNo = 9;
	final int maxAnswerNo 	= 7;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	private ArrayList<Label> questions_label = new ArrayList<Label>();
	private ArrayList<Label> questions_label_right = new ArrayList<Label>();
	AbsolutePanel absolutePanel = new AbsolutePanel();


	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public AnthropomorphismQuestionnaireDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions, final int plyRemaining) {
		super(false, true);
		this.eventBus = eventBus;
		setHTML("Questionnaire");
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		setWidget(absolutePanel);
		Label explanation = new Label();
	    
		if (localName == "en" || localName == "ko"){			
			explanation = new Label(constants.anthropomorphism());
			explanation.setStylePrimaryName("Explanation-style");

			questions_label.add(new Label(constants.anthropomorphism1_left()));
			questions_label.add(new Label(constants.anthropomorphism2_left()));
			questions_label.add(new Label(constants.anthropomorphism3_left()));
			questions_label.add(new Label(constants.anthropomorphism4_left()));
			questions_label.add(new Label(constants.anthropomorphism5_left()));
			questions_label.add(new Label(constants.anthropomorphism6_left()));
			questions_label.add(new Label(constants.anthropomorphism7_left()));
			questions_label.add(new Label(constants.anthropomorphism8_left()));
			questions_label.add(new Label(constants.anthropomorphism9_left()));
			
			questions_label_right.add(new Label(constants.anthropomorphism1_right()));
			questions_label_right.add(new Label(constants.anthropomorphism2_right()));
			questions_label_right.add(new Label(constants.anthropomorphism3_right()));
			questions_label_right.add(new Label(constants.anthropomorphism4_right()));
			questions_label_right.add(new Label(constants.anthropomorphism5_right()));
			questions_label_right.add(new Label(constants.anthropomorphism6_right()));
			questions_label_right.add(new Label(constants.anthropomorphism7_right()));
			questions_label_right.add(new Label(constants.anthropomorphism8_right()));
			questions_label_right.add(new Label(constants.anthropomorphism9_right()));


			for(int i=0; i<questions_label.size(); i++) {
				questions_label.get(i).setStylePrimaryName("Label-style");
				questions_label_right.get(i).setStylePrimaryName("Label-style");
			}

/*			// initialize
			flexTable.setText(0, 1, constants.mfq_explanation_part1_zero());
			flexTable.setText(0, 2, constants.mfq_explanation_part1_one());
			flexTable.setText(0, 3, constants.mfq_explanation_part1_two());
			flexTable.setText(0, 4, constants.mfq_explanation_part1_three());
			flexTable.setText(0, 5, constants.mfq_explanation_part1_four());
			flexTable.setText(0, 6, constants.mfq_explanation_part1_five());
			flexTable.getFlexCellFormatter().setRowSpan(0, 0, 2);
			flexTable.setText(1, 0, constants.zero());
			flexTable.setText(1, 1, constants.one());
			flexTable.setText(1, 2, constants.two());
			flexTable.setText(1, 3, constants.three());
			flexTable.setText(1, 4, constants.four());
			flexTable.setText(1, 5, constants.five()); */

			for(int i=0; i<maxQuestionNo; i++) {
				for(int j=0; j<maxAnswerNo; j++) {
//					flexTable.setText(i, j, " ");
//					flexTable.setText(i, j, "("+i+","+j+")");
					flexTable.getCellFormatter().setWidth(i*2+1, j, "60px");
					flexTable.getCellFormatter().setHorizontalAlignment(i*2, j, HasHorizontalAlignment.ALIGN_CENTER);
					flexTable.getCellFormatter().setHorizontalAlignment(i*2, j+1, HasHorizontalAlignment.ALIGN_CENTER);
					flexTable.getCellFormatter().setHorizontalAlignment(i*2, j+2, HasHorizontalAlignment.ALIGN_CENTER);
					flexTable.getCellFormatter().setHorizontalAlignment(i*2+1, j, HasHorizontalAlignment.ALIGN_CENTER);
				}
				flexTable.getFlexCellFormatter().setRowSpan(i*2, 0, 2);
				flexTable.getFlexCellFormatter().setRowSpan(i*2, maxAnswerNo+1, 2);
				flexTable.getCellFormatter().setWidth(i*2, 0, "175px");
				flexTable.getCellFormatter().setWidth(i*2, maxAnswerNo+1, "175px");
				flexTable.getCellFormatter().setHeight(i*2, 1, "15px");
				flexTable.getCellFormatter().setHeight(i*2+1, 1, "24px");
			}

/*			for(int i=0; i<maxAnswerNo; i++) {
				flexTable.getCellFormatter().setHorizontalAlignment(0, i+1, HasHorizontalAlignment.ALIGN_CENTER);
				flexTable.getCellFormatter().setHorizontalAlignment(1, i, HasHorizontalAlignment.ALIGN_CENTER);
				flexTable.getCellFormatter().setWidth(2, i+1, "60px");
			}*/
			
			setQuestion(0, experimentConditions, plyRemaining);
		}

		applyDataRowStyles();
		absolutePanel.add(explanation, 10, 10);
		absolutePanel.add(flexTable, 10, 35);
		absolutePanel.setSize("800px", "565px");
	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
		HTMLTable.RowFormatter rf = flexTable.getRowFormatter();
//		rf.addStyleName(0, "FlexTable-ColumnLabel");
//		rf.addStyleName(1, "FlexTable-ColumnChoice");
		
		for(int row=0; row<flexTable.getRowCount(); ++row) {
//			if(row%2 != 0)
			if(row%4 == 0 || row%4 == 1)
				rf.addStyleName(row, "FlexTable-OddRow");
			else
				rf.addStyleName(row, "FlexTable-EvenRow");
		}
	}
	
	public void applyDataRowStylesAgain(int row) {
		for(int col=0; col<maxAnswerNo; col++) {
//			if(row%2 != 0)
			if(row%4 == 0) {
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
				flexTable.getCellFormatter().setStyleName(row, col+1, "FlexTable-OddRow");
				flexTable.getCellFormatter().setStyleName(row, col+2, "FlexTable-OddRow");
			} else if(row%4 == 1) {
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			} else if(row%4 == 2) {				
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
				flexTable.getCellFormatter().setStyleName(row, col+1, "FlexTable-EvenRow");
				flexTable.getCellFormatter().setStyleName(row, col+2, "FlexTable-EvenRow");
			} else {
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
			}
		}
	}
	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions, final int plyRemaining) {
		flexTable.setWidget(currentQuestionNo*2, 0, questions_label.get(currentQuestionNo));
		flexTable.setWidget(currentQuestionNo*2, 1, new HTML(constants.one_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 2, new HTML(constants.two_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 3, new HTML(constants.three_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 4, new HTML(constants.four_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 5, new HTML(constants.five_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 6, new HTML(constants.six_HTML()));
		flexTable.setWidget(currentQuestionNo*2, 7, new HTML(constants.seven_HTML()));

		flexTable.setWidget(currentQuestionNo*2, maxAnswerNo+1, questions_label_right.get(currentQuestionNo));
		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i+1);
			flexTable.getCellFormatter().setHorizontalAlignment(currentQuestionNo*2, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(currentQuestionNo*2+1, i, radioButton);

			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
					applyDataRowStylesAgain(currentQuestionNo*2);
					applyDataRowStylesAgain(currentQuestionNo*2+1);

					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2, radioButton.getTabIndex(), "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(currentQuestionNo*2+1, radioButton.getTabIndex()-1, "FlexTable-SelectedCell");

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
				hide();
				experimentConditions.setAnthropomorphism_1(userAnswer[0]);
				experimentConditions.setAnthropomorphism_2(userAnswer[1]);
				experimentConditions.setAnthropomorphism_3(userAnswer[2]);
				experimentConditions.setAnthropomorphism_4(userAnswer[3]);
				experimentConditions.setAnthropomorphism_5(userAnswer[4]);
				experimentConditions.setAnthropomorphism_6(userAnswer[5]);
				experimentConditions.setAnthropomorphism_7(userAnswer[6]);
				experimentConditions.setAnthropomorphism_8(userAnswer[7]);
				experimentConditions.setAnthropomorphism_9(userAnswer[8]);

				final PartnerLabelCheckQuestionnaireDialogBox dialogBox = new PartnerLabelCheckQuestionnaireDialogBox(eventBus, experimentConditions, plyRemaining);
				dialogBox.setPopupPosition(105, 75);
				dialogBox.show();
			}
		});

		btnSubmit.setSize("250px", "33px");
		absolutePanel.add(btnSubmit, 307, 510);
	}	
}

