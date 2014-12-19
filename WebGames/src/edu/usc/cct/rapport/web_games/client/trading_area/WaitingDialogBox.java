package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class WaitingDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public WaitingDialogBox(final EventBus eventBus, final String explanation) {
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML(constants.waiting());
				
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
//		flexTable.setSize("250px", "100px");
		flexTable.setSize("800px", "565px");
		
//		Label lblWaiting = new Label(constants.waiting_msg());
		Label lblWaiting = new Label();
		
		if(explanation.equals("waitAfterRejection")) {
			lblWaiting.setText("Please wait...");
		} else if(explanation.equals("coinTossing")) {
			lblWaiting.setText("Tossing a coin...");
		} else {
			lblWaiting.setText(constants.waiting_msg());			
		}
			

		lblWaiting.setStylePrimaryName("BigLabel-style");
		flexTable.setWidget(0, 0, lblWaiting);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(1, 0, loadingImage); // image
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
	}
}
	

