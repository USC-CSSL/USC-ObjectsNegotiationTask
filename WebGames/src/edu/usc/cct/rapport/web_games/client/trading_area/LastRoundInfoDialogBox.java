package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;

public class LastRoundInfoDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public LastRoundInfoDialogBox(final EventBus eventBus, final int partnerLabel, final NegotiationSession negotiationSession) {
		super(false, true);
		this.eventBus = eventBus;

//		setHTML(constants.reviewingOffer());
		setHTML(constants.blank());
	
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("800px", "565px");
		
//		Label lblAcceptance = new HTML(constants.last_round());
//		String lastRound = "";
		HTML lastRound = new HTML("");
		
		if(partnerLabel == 0)
			lastRound.setHTML(constants.last_round_computer());
		else if(partnerLabel == 1)
			lastRound.setHTML(constants.last_round_human());
		else
			lastRound.setHTML(constants.last_round());	
		
//		final StringBuilder builder = new StringBuilder();
//		builder.append(lastRound);
//		final String result = builder.toString();
		
//		final RichTextArea dialogBoxTextArea = new RichTextArea();
//		dialogBoxTextArea.setSize("780px", "550px");
//		dialogBoxTextArea.setHTML(result);
//		flowPanelDialogBoxContents.add(dialogBoxTextArea);		

		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(0, 0, lastRound);
//		flexTable.setWidget(0, 0, lblAcceptance);
//		flexTable.setWidget(0, 0, dialogBoxTextArea);
	}
}
	

