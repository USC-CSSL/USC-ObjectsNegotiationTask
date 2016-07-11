package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Random;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class TossCoinResultDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
//	public TossCoinResultDialogBox(final EventBus eventBus) {
	public TossCoinResultDialogBox(final EventBus eventBus, ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		
		setHTML(constants.tossCoin());
				
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("800px", "565px");
		
		Label lblCoinTossResult 		= new Label();
//		Label lblCoinTossDescription 	= new Label();
//		Label lblCoinTossDescription1 	= new Label();
//		Label lblCoinTossDescription2 	= new Label();
		
		Random random = new Random();
		final int tossCoinResult = random.nextInt(2);
		
		if(tossCoinResult == 0) {
//			experimentConditions.setCoinTossResult("tail");
			lblCoinTossResult.setText(constants.tail());
//			lblCoinTossDescription.setText(constants.tailDescription());
//			lblCoinTossDescription1.setText(constants.tailDescription1());
//			lblCoinTossDescription2.setText(constants.tailDescription2());
			flexTable.setHTML(3, 0, constants.tailDescriptionHTML());
		} else {
//			experimentConditions.setCoinTossResult("head");
			lblCoinTossResult.setText(constants.head());			
//			lblCoinTossDescription.setText(constants.headDescription());
//			lblCoinTossDescription1.setText(constants.headDescription1());
//			lblCoinTossDescription2.setText(constants.headDescription2());
			flexTable.setHTML(3, 0, constants.headDescriptionHTML());
		}

		
		lblCoinTossResult.setStylePrimaryName("BigLabel-style");
//		lblCoinTossDescription.setStylePrimaryName("BigLabel-style");
//		lblCoinTossDescription1.setStylePrimaryName("BigLabel-style");
//		lblCoinTossDescription2.setStylePrimaryName("BigLabel-style");
		flexTable.setWidget(0, 0, new Label(""));
		flexTable.setWidget(1, 0, lblCoinTossResult);
//		flexTable.setWidget(2, 0, lblCoinTossDescription);
		flexTable.setWidget(2, 0, new Label(""));
//		flexTable.setWidget(3, 0, lblCoinTossDescription1);
//		flexTable.setWidget(4, 0, lblCoinTossDescription2);
		flexTable.setWidget(5, 0, new Label(""));
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
//		flexTable.getFlexCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);
//		flexTable.getFlexCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
/*		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(2, 0, loadingImage); // image
		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);*/
	}
}
	

