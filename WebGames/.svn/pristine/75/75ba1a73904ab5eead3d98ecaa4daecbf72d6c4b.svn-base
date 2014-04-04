package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;

public class ProposalResultDialogBox extends DialogBox implements ClickHandler {

	@SuppressWarnings("unused")

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	public ProposalResultDialogBox(final String result) {
		super(false, true);
		
		String titleDiscription = constants.help_Window_Title();
		this.setText(titleDiscription);

		String okButtonString = constants.ok_button();
		final Button okButton = new Button(okButtonString, this);
		
		Label lblProposalResult = new Label("");
		String acceptedStr = "accepted";
		String rejectedStr = "rejected";
		
		if(result.equals(acceptedStr))
			lblProposalResult = new Label(constants.proposal_accepted());
		else if(result.equals(rejectedStr))
			lblProposalResult = new Label(constants.proposal_rejected());

		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("250px", "100px");
		
		lblProposalResult.setStylePrimaryName("Label-style");
		flexTable.setWidget(0, 0, lblProposalResult);
		flexTable.setWidget(1, 0, okButton);
		flexTable.getCellFormatter().setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
	};
	
	@Override
	public void onClick(final ClickEvent event) {
		hide();
	};
}
	

