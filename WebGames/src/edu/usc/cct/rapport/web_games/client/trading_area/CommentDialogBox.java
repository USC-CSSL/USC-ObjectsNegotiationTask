package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
//import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaActivity.LogExperimentInformation;


public class CommentDialogBox extends DialogBox {

//	@SuppressWarnings("unused")
	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
//	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public CommentDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML("Comment");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("597px", "160px"); // 597, 610 // 597, 555 (w/o economic class and political orientation questions)
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		final IntegerBox integerBox = new IntegerBox();
		final TextArea textArea = new TextArea();
		
		if (localName == "en" || localName == "ko"){	

			Label lblComments = new Label("Please leave us a comment.");
			lblComments.setStylePrimaryName("RadioButton-style");
			absolutePanel.add(lblComments, 10, 10);
			lblComments.setSize("502px", "18px");

			absolutePanel.add(textArea, 14, 35);
			textArea.setSize("450px", "60px");
		}
		
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(textArea.getText().isEmpty()) textArea.setText("");

				String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();

				hide();
//				experimentConditions.setCommentOfParticipant(textArea.getText());
				eventBus.fireEvent(new LogExperimentInformationEvent());
				
				timer.schedule(1000);
			}
	});
		btnSubmit.setSize("92px", "33px");
		absolutePanel.add(btnSubmit, 285, 120); // 471, 570 // 471, 515
		
	}
	
	Timer timer = new Timer() {
	      public void run() {
	    	  eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	      }
	};
}
