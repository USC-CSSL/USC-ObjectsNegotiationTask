package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

//public class StartGameHelpWindowDialogBox extends DialogBox implements ClickHandler {
public class StartGameHelpWindowDialogBox extends DialogBox {

	@SuppressWarnings("unused")
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
//	public StartGameHelpWindowDialogBox(final EventBus eventBus, final int temp) {
	public StartGameHelpWindowDialogBox(final EventBus eventBus, final int temp, final ExperimentConditions experimentConditions) {
		
		
		super(false, true);
		this.eventBus = eventBus;

//		String titleDiscription = constants.help_Window_Title();
//		this.setText(titleDiscription);
		this.setText("Task Instructions");
//		final FlowPanel flowPanelDialogBoxContents = new FlowPanel();
		AbsolutePanel absolutePanel = new AbsolutePanel();
//		absolutePanel.setSize("650px", "435px");
		absolutePanel.setSize("800px", "565px");
		
/*	//	final TextArea dialogBoxTextArea = new TextArea();
		RichTextArea dialogBoxTextArea = new RichTextArea();
//		dialogBoxTextArea.setSize("450px", "500px");
		dialogBoxTextArea.setSize("640px", "390px");
		//dialogBoxTextArea.setCharacterWidth(75);
		//dialogBoxTextArea.setVisibleLines(10);

		String helpStartofGame = constants.help_start_of_game();
		final StringBuilder builder = new StringBuilder();
		builder.append(helpStartofGame);
		final String result = builder.toString();
		
		dialogBoxTextArea.setHTML(result);
//		flowPanelDialogBoxContents.add(dialogBoxTextArea);
		absolutePanel.add(dialogBoxTextArea , 0, 0);*/
		
		Integer partnerLabel = experimentConditions.getPartnerLabel();
		HTML help_start_of_game = new HTML("");

/*		if (partnerLabel == 0) {
			help_start_of_game.setHTML(constants.help_start_of_game_computer_partner());
		} else if(partnerLabel == 1) {			
			help_start_of_game.setHTML(constants.help_start_of_game_human_partner());
		} else {
			help_start_of_game.setHTML(constants.help_start_of_game());
		}*/
		help_start_of_game.setHTML(constants.help_start_of_game());
		
		absolutePanel.add(help_start_of_game , 10, 10);


		String okButtonString = constants.ok_button();
		final Button button = new Button(okButtonString);
//		final Button button = new Button(okButtonString, this);
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final PartnerLabelDialogBox dialogBox = new PartnerLabelDialogBox(eventBus, experimentConditions);
				
				Timer timer = new Timer() {
					@Override
					public void run() {
						final PartnerAssignmentDialogBox dialogBox1 = new PartnerAssignmentDialogBox(eventBus, experimentConditions);

						Timer timer1 = new Timer() {
							@Override
							public void run() {
								final PartnerAssignmentResultDialogBox dialogBox2 = new PartnerAssignmentResultDialogBox(eventBus, experimentConditions);
								Timer timer2 = new Timer() {
									@Override
									public void run() {
										dialogBox2.hide();										
									}
								};
								dialogBox2.setPopupPosition(105, 75);
								dialogBox2.show();
							    timer2.schedule(5000);				
								dialogBox1.hide();
							}
						};
						dialogBox1.setPopupPosition(105, 75);
						dialogBox1.show();
						timer1.schedule((int)(Math.random() * (17000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 17sec;
						dialogBox.hide();
					}
				};
				dialogBox.setPopupPosition(105, 75);
				dialogBox.show();
			    timer.schedule(5000); 		// 5sec delay
				hide();
			}
		});
		
//		flowPanelDialogBoxContents.add(okButton);
//		this.setWidget(flowPanelDialogBoxContents);
						
//		absolutePanel.add(button, 540, 400);
//		button.setSize("101px", "26px");
		this.setWidget(absolutePanel);
		button.setSize("250px", "33px");
//		absolutePanel.add(button, 307, 510);
		absolutePanel.add(button, 275, 510);

	};
};

/*	@Override
	public void onClick(final ClickEvent event) {
		final PartnerLabelDialogBox dialogBox = new PartnerLabelDialogBox(eventBus, experimentConditions);
		
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();
		hide();
	//	eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	};
};*/
