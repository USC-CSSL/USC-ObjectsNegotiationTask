package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class PartnerLabelDialogBox extends DialogBox {

	@SuppressWarnings("unused")

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	public PartnerLabelDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		
		super(false, true);
		
		String titleDiscription = constants.help_Window_Title();
		this.setText(titleDiscription);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");

		
		Integer partnerLabel = experimentConditions.getPartnerLabel();
		HTML showPartner = new HTML("");

		if (partnerLabel == 0) {
			showPartner.setHTML(constants.partner_computer());
		} else if(partnerLabel == 1) {			
			showPartner.setHTML(constants.partner_human());
		} else {
			showPartner.setHTML(constants.partner());
		}
		
//		showPartner.setStyleName("BigLabel-style");
		absolutePanel.add(showPartner , 110, 170);

	};

};
