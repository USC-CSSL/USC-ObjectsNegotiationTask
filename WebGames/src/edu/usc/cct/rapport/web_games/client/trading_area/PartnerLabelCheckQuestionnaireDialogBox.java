package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


public class PartnerLabelCheckQuestionnaireDialogBox extends DialogBox {

	final int maxQuestionNo = 1;
	final int maxAnswerNo 	= 3;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	AbsolutePanel absolutePanel = new AbsolutePanel();	
	final TextArea textArea = new TextArea();
	
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public PartnerLabelCheckQuestionnaireDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions, final int plyRemaining) {
		super(false, true);
		this.eventBus = eventBus;
//		setHTML("Questionnaire");
//		this.setHTML(constants.blank());
		this.setText("Questionnaires");
		
		setWidget(absolutePanel);
		HTML question = new HTML();
		question = new HTML(constants.partnerLabel_question());
		
		flexTable.setHTML(0, 1, constants.partnerLabel_computer());
		flexTable.setHTML(1, 1, constants.partnerLabel_human());
		flexTable.setHTML(2, 1, constants.partnerLabel_other());
		flexTable.setHTML(3, 1, constants.partnerLabel_other2());
		flexTable.setWidget(3, 2, textArea);
		
		for(int i=0; i<maxAnswerNo; i++) {
			flexTable.getCellFormatter().setHeight(i, 0, "25px");
		}
		flexTable.getCellFormatter().setWidth(0, 0, "25px");
		flexTable.getCellFormatter().setWidth(0, 1, "150px");
		flexTable.getCellFormatter().setVerticalAlignment(3, 1, HasVerticalAlignment.ALIGN_TOP);
//		flexTable.getCellFormatter().setWidth(3, 2, "570px");
//		flexTable.getCellFormatter().setWidth(3, 2, "120px");

/*		for(int i=0; i<maxAnswerNo; i++) {
			flexTable.getCellFormatter().setWidth(0, i, "95px");
			flexTable.getCellFormatter().setHorizontalAlignment(0, i, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.getCellFormatter().setHorizontalAlignment(1, i, HasHorizontalAlignment.ALIGN_CENTER);
		}*/
		
		setQuestion(0, experimentConditions, plyRemaining);

//		applyDataRowStyles();
		absolutePanel.add(question, 15, 10);		
		absolutePanel.add(flexTable, 10, 30);
		absolutePanel.setSize("800px", "565px");
//		absolutePanel.add(textArea, 170, 110);
		textArea.setSize("550px", "100px");
//		textArea.setSize("690px", "100px");

	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
		
		for(int row=0; row<maxAnswerNo; row++) {
			for(int col=0; col<flexTable.getRowCount(); col++) {
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			}
		}

		
	}
	
	public void applyDataRowStylesAgain() {
		for(int row=0; row<=maxAnswerNo; row++) {
			flexTable.getCellFormatter().setStyleName(row, 0, "FlexTable-OddRow");
			flexTable.getCellFormatter().setStyleName(row, 1, "FlexTable-OddRow");
		}
	}
	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions, final int plyRemaining) {		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i);
			flexTable.getCellFormatter().setHorizontalAlignment(i, currentQuestionNo, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(i, currentQuestionNo, radioButton);


			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
					applyDataRowStylesAgain();

					flexTable.getCellFormatter().setStyleName(radioButton.getTabIndex(), currentQuestionNo, "FlexTable-SelectedCell");
					flexTable.getCellFormatter().setStyleName(radioButton.getTabIndex(), currentQuestionNo+1, "FlexTable-SelectedCell");
					if(radioButton.getTabIndex() == 2) {
						flexTable.getCellFormatter().setStyleName(radioButton.getTabIndex()+1, 1, "FlexTable-SelectedCell");						
//						flexTable.getCellFormatter().setStyleName(radioButton.getTabIndex()+1, 2, "FlexTable-SelectedCell");						
					}

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
				if(textArea.getText().isEmpty()) textArea.setText("");

				if(plyRemaining < 29) {
					final FairnessQuestionnaire1DialogBox dialogBox = new FairnessQuestionnaire1DialogBox (eventBus, experimentConditions, plyRemaining);
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				} else {
					final SocialValueOrientationQuestionnaire1DialogBox dialogBox = new SocialValueOrientationQuestionnaire1DialogBox (eventBus, experimentConditions);
					dialogBox.setPopupPosition(105, 75);
					dialogBox.show();
				}

				hide();
				experimentConditions.setPartnerLabelCheck(userAnswer[0]);
				experimentConditions.setPartnerLabelCheckComment(textArea.getText());
			}
		});

		btnSubmit.setSize("250px", "33px");
		absolutePanel.add(btnSubmit, 307, 510);
	}	
}

