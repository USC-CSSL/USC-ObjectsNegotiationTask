package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

public class RoundInformationWidget extends Composite {

	static final private String roundInformationStyle = "ict-rapport-roundInformation";
	static final private String verticalAlignMiddle = "ict-rapport-verticalAlignMiddle";

	final private Label labelDisplayName;
	final private FlexTable flexTableBasePanel;


	public RoundInformationWidget() {

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.flexTableBasePanel.setVisible(true);

		this.labelDisplayName = new Label(" ");
		this.labelDisplayName.addStyleName(roundInformationStyle);
		this.labelDisplayName.addStyleName(verticalAlignMiddle);
		this.labelDisplayName.setWidth("800px");
		this.labelDisplayName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelDisplayName.setVisible(true);
		this.flexTableBasePanel.setWidget(0, 0, this.labelDisplayName);		
	};

	public void setRoundInformation(final Integer roundInfo) {
//		this.labelDisplayName.setText("Round "+Integer.toString(7-roundInfo/5)+" of 6");
		this.labelDisplayName.setText("Round "+Integer.toString(7-(roundInfo-3)/11)+" of 6");
		
	};
};
