package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ProposalResultDelayDialogBox extends DialogBox implements ClickHandler {

	@SuppressWarnings("unused")

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	public ProposalResultDelayDialogBox(final String result, final int partnerLabel) {
		super(false, true);
		
		this.setHTML(constants.blank());
		
		HTML proposalDelayResult = new HTML("");
		proposalDelayResult.setHTML(constants.proposal_delay());

		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("800px", "565px");
				
		flexTable.setWidget(0, 0, proposalDelayResult);
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(1, 0, loadingImage); // image

		flexTable.getCellFormatter().setAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
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
	

