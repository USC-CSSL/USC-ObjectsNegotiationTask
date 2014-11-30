package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

public class AgentDealValuationWidget extends Composite {

	static final private String agentDealValuationStyleName = "ict-rapport-agentDealValuationStyle";

	final private EnumMap<ValuationCategoryEnum, DescribedValueWidget> describedValueWidgets;
	final private FlexTable flexTableBasePanel;


	public AgentDealValuationWidget(final AgentEnum agentEnum, final int totalWidthHint) {

		this.describedValueWidgets = new EnumMap<ValuationCategoryEnum, DescribedValueWidget>(ValuationCategoryEnum.class);

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.flexTableBasePanel.setVisible(true);

		this.setStyleName(agentDealValuationStyleName);
		
		for (final ValuationCategoryEnum valuationCategoryEnum: ValuationCategoryEnum.values()) {
			final String description = agentEnum.getValuationDescription(valuationCategoryEnum);
			final DescribedValueWidget describedValueWidget = new DescribedValueWidget(description, null, totalWidthHint);
			this.describedValueWidgets.put(valuationCategoryEnum, describedValueWidget);
			this.flexTableBasePanel.setWidget(valuationCategoryEnum.ordinal(), 0, describedValueWidget);
		};
	};


	public int getDealValue(final ValuationCategoryEnum valuationCategoryEnum) {
		return describedValueWidgets.get(valuationCategoryEnum).getValue();
	};


	public void setDealValue(final ValuationCategoryEnum valuationCategoryEnum, final Integer dealValue) {
		describedValueWidgets.get(valuationCategoryEnum).setValue(dealValue);
	};

	public void setLabelVisibility (final ValuationCategoryEnum valuationCategoryEnum,final Boolean visible){
		describedValueWidgets.get(valuationCategoryEnum).setLabelVisibility(visible);
	}

	public void setLabelText (final ValuationCategoryEnum valuationCategoryEnum,String text){
		describedValueWidgets.get(valuationCategoryEnum).setText(text);
	}
};
