package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Date;


public class TradingExpression {

	final private double timestamp;
	final private AgentEnum performingAgent;
	final private FacialExpressionEnum facialExpressionEnum;


	public TradingExpression(final AgentEnum performingAgent, final double timestamp, final FacialExpressionEnum facialExpressionEnum) {
		this.performingAgent = performingAgent;
		this.timestamp = timestamp;
		this.facialExpressionEnum = facialExpressionEnum;
	};


	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append(this.performingAgent);
		builder.append(", [");
		builder.append(new Date((long)this.timestamp));
		builder.append("|");
		builder.append((long)this.timestamp);
		builder.append("], ");
		builder.append(this.facialExpressionEnum.name());
		builder.append('}');

		final String result = builder.toString();
		return result;
	};


	public AgentEnum getPerformingAgent() {
		final AgentEnum result = AgentEnum.valueOf(this.performingAgent.name());
		return result;
	};


	public double getTimestamp() {
		return this.timestamp;
	};


	public FacialExpressionEnum getFacialExpressionEnum() {
		final FacialExpressionEnum result = FacialExpressionEnum.valueOf(this.facialExpressionEnum.name());
		return result;
	};


	public TradingExpressionDS generateDoublySerializable() {
		final TradingExpressionDS result = new TradingExpressionDS();
		result.setTimestamp(this.timestamp);
		result.setPerformingAgent(this.performingAgent);
		result.setFacialExpressionEnum(this.facialExpressionEnum);
		return result;
	};

};
