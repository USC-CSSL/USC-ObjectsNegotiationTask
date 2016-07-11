package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ProposalResultDialogBox extends DialogBox implements ClickHandler {

	@SuppressWarnings("unused")

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

//	public ProposalResultDialogBox(final String result) {
	public ProposalResultDialogBox(final String result, final int partnerLabel) {
		super(false, true);
		
//		String titleDiscription = constants.help_Window_Title();
//		this.setText(titleDiscription);
		this.setHTML(constants.blank());

		String okButtonString = constants.ok_button();
		final Button okButton = new Button(okButtonString, this);
		
//		Label lblProposalResult = new Label("");
		String acceptedStr = "accepted";
		String rejectedStr = "rejected";

/*		if(result.equals(acceptedStr))
			lblProposalResult = new Label(constants.proposal_accepted());
		else if(result.equals(rejectedStr))
			lblProposalResult = new Label(constants.proposal_rejected());*/

/*		if(result.equals(acceptedStr))
			if(partnerLabel==0)
				lblProposalResult = new Label(constants.proposal_accepted_by_computer());
			else if(partnerLabel==1)
				lblProposalResult = new Label(constants.proposal_accepted_by_human());
			else
				lblProposalResult = new Label(constants.proposal_accepted());
		else if(result.equals(rejectedStr))
			if(partnerLabel==0)
				lblProposalResult = new Label(constants.proposal_rejected_by_computer());
			else if(partnerLabel==1)
				lblProposalResult = new Label(constants.proposal_rejected_by_human());
			else
				lblProposalResult = new Label(constants.proposal_rejected());*/
		
		HTML proposalResult = new HTML("");
		if(result.equals(acceptedStr)) {
			if(partnerLabel==0)
				proposalResult.setHTML(constants.proposal_accepted_by_computer());
			else if(partnerLabel==1)
				proposalResult.setHTML(constants.proposal_accepted_by_human());
			else
				proposalResult.setHTML(constants.proposal_accepted());
		} else if(result.equals(rejectedStr)) {
			if(partnerLabel==0)
				proposalResult.setHTML(constants.proposal_rejected_by_computer());
			else if(partnerLabel==1)
				proposalResult.setHTML(constants.proposal_rejected_by_human());
			else
				proposalResult.setHTML(constants.proposal_rejected());
		}


		FlexTable flexTable = new FlexTable();
//		setWidget(flexTable);
//		flexTable.setSize("800px", "565px");
		flexTable.setSize("780px", "380px");
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");
				
//		lblProposalResult.setStylePrimaryName("Label-style");
//		lblProposalResult.setStylePrimaryName("BiggerLabel-style");
//		flexTable.setWidget(0, 0, lblProposalResult);
//		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
//		flexTable.setWidget(1, 0, okButton);
		
		flexTable.setWidget(0, 0, proposalResult);
		absolutePanel.add(flexTable, 10, 10);

		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		absolutePanel.add(loadingImage, 390, 400);
//		Image loadingImage = new Image();
//		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
//		flexTable.setWidget(1, 0, loadingImage); // image
//		flexTable.getCellFormatter().setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
	};
	
	@Override
	public void onClick(final ClickEvent event) {
		hide();
	};
	
	protected void beginDragging(MouseDownEvent e)
	{
		e.preventDefault();
	}
}
	

