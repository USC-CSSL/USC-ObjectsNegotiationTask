package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;

public class LastRoundHelpWindowDialogBox extends DialogBox implements ClickHandler {

	@SuppressWarnings("unused")
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	public LastRoundHelpWindowDialogBox(final EventBus eventBus) {
		
		super(false, true);
		this.eventBus = eventBus;

		String titleDiscription = constants.help_Window_Title();
		this.setText(titleDiscription);
		final FlowPanel flowPanelDialogBoxContents = new FlowPanel();
		
		final RichTextArea dialogBoxTextArea = new RichTextArea();
		//dialogBoxTextArea.setCharacterWidth(50);
		//dialogBoxTextArea.setVisibleLines(5);
		dialogBoxTextArea.setSize("350px", "200px");
		
		String lastRound = constants.last_round();
			
		final StringBuilder builder = new StringBuilder();
		builder.append(lastRound);
		final String result = builder.toString();
		
		dialogBoxTextArea.setHTML(result);
		flowPanelDialogBoxContents.add(dialogBoxTextArea);

		String okButtonString = constants.ok_button();
		final Button okButton = new Button(okButtonString, this);
		flowPanelDialogBoxContents.add(okButton);
		this.setWidget(flowPanelDialogBoxContents);
	};


	@Override
	public void onClick(final ClickEvent event) {
		hide();
		//eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	};
};
