package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class AgentObjectValuationWidget extends Composite {

	static final private TradingAreaInternationalizationConstants constants = GWT.create(TradingAreaInternationalizationConstants.class);
	static final private String agentObjectValuationStyleName = "ict-rapport-agentObjectValuationStyle";
	static final private String agentObjectValuationHeaderStyleName = "ict-rapport-agentObjectValuationHeaderStyle";

	final private AgentEnum agentEnum;
	final private TradingObjectSetEnum tradingObjectSetEnum;
	final private String width;
	final private EnumMap<TradingObjectEnum, DescribedValueWidget> describedValueWidgets;
	final private FlexTable flexTableBasePanel;


	public AgentObjectValuationWidget(final AgentEnum agentEnum, final TradingObjectSetEnum tradingObjectSetEnum, final String width) {

		this.agentEnum = agentEnum;
		this.tradingObjectSetEnum = tradingObjectSetEnum;
		this.width = width;
		this.describedValueWidgets = new EnumMap<TradingObjectEnum, DescribedValueWidget>(TradingObjectEnum.class);

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.addStyleName(agentObjectValuationStyleName);
		this.flexTableBasePanel.setVisible(true);

		populateFlexTableBasePanel(this.flexTableBasePanel, this.agentEnum, this.tradingObjectSetEnum, this.width);
	};


	private void populateFlexTableBasePanel(final FlexTable flexTableBasePanel, final AgentEnum agentEnum, final TradingObjectSetEnum tradingObjectSetEnum, final String width) {

		flexTableBasePanel.clear();

		final Label header = generateHeader(agentEnum, width);
		flexTableBasePanel.setWidget(0, 0, header);

		for (final TradingObjectEnum tradingObjectEnum: tradingObjectSetEnum.getSetOfTradingObjectEnum()) {
			final Image image = tradingObjectEnum.getImage();
			final DescribedValueWidget describedValueWidget = new DescribedValueWidget(image, tradingObjectEnum.getPayoff(agentEnum));
			this.describedValueWidgets.put(tradingObjectEnum, describedValueWidget);
			this.flexTableBasePanel.setWidget(1 + tradingObjectEnum.ordinal(), 0, describedValueWidget);
		};
	};


	private Label generateHeader(final AgentEnum agentEnum, final String width) {
		final Label result = new Label();
		result.setWidth(width);
		result.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		result.addStyleName(agentObjectValuationHeaderStyleName);
		switch (agentEnum) {
		case counterpart:
			result.setText(constants.labelCounterpartsPayoffMatrix());
			break;
		case player:
			result.setText(constants.labelPlayersPayoffMatrix());
			break;
		default:
			throw new IllegalStateException("Unhandled AgentEnum in AgentObjectValuationWidget.generateHeader().");
		};

		return result;
	};


	public TradingObjectSetEnum getTradingObjectSetEnum() {
		final TradingObjectSetEnum result = Enum.valueOf(TradingObjectSetEnum.class, this.tradingObjectSetEnum.name());
		return result;
	};


	public void setTradingObjectSetEnum(final TradingObjectSetEnum tradingObjectSetEnum) {
		if (false == this.tradingObjectSetEnum.equals(tradingObjectSetEnum)) {
			populateFlexTableBasePanel(this.flexTableBasePanel, this.agentEnum, tradingObjectSetEnum, this.width);
		};
	};


	public int getObjectValue(final TradingObjectEnum tradingObjectEnum) {
		return describedValueWidgets.get(tradingObjectEnum).getValue();
	};


	public void setObjectValue(final TradingObjectEnum tradingObjectEnum, final Integer objectValue) {
		describedValueWidgets.get(tradingObjectEnum).setValue(objectValue);
	};

};
