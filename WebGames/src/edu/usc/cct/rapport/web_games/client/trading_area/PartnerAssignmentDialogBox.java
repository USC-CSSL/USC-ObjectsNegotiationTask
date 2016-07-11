package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class PartnerAssignmentDialogBox extends DialogBox {

	@SuppressWarnings("unused")

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	public PartnerAssignmentDialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		
		super(false, true);
		
//		String titleDiscription = constants.help_Window_Title();
//		this.setText(titleDiscription);
		setHTML(constants.blank());
		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("800px", "565px");
		
		FlexTable flexTable = new FlexTable();
		flexTable.setSize("780px", "380px");
		
		Integer partnerLabel = experimentConditions.getPartnerLabel();
		HTML partnerAssignment = new HTML("");

		if (partnerLabel == 0) {
			partnerAssignment.setHTML(constants.partnerAssignment_computer());
		} else if(partnerLabel == 1) {			
			partnerAssignment.setHTML(constants.partnerAssignment_human());
		} else {
			partnerAssignment.setHTML(constants.partnerAssignment());
		}
		
		flexTable.setWidget(0, 0, partnerAssignment);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		absolutePanel.add(flexTable, 10, 10);
//		absolutePanel.add(partnerAssignment , 110, 170);

		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		absolutePanel.add(loadingImage, 390, 400);
	};

	protected void beginDragging(MouseDownEvent e)
	{
		e.preventDefault();
	}

};
