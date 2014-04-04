package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Date;


public class TradingAction {

	final private double timestamp;
	final private AgentEnum performingAgent;
	final private TradingActionEnum tradingActionEnum;
	final private Proposal proposal;


	public TradingAction(final AgentEnum performingAgent, final double timestamp, final TradingActionEnum tradingActionEnum, final Proposal proposal) {
		this.performingAgent = performingAgent;
		this.timestamp = timestamp;
		this.tradingActionEnum = tradingActionEnum;
		this.proposal = proposal;
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
		builder.append(this.tradingActionEnum.name());
		builder.append(", ");
		builder.append(this.proposal);
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


	public TradingActionEnum getTradingActionEnum() {
		final TradingActionEnum result = TradingActionEnum.valueOf(this.tradingActionEnum.name());
		return result;
	};


	public Proposal getProposal() {
		return this.proposal;
	};

	
	public TradingActionDS generateDoublySerializable() {
		final TradingActionDS result = new TradingActionDS();
		result.setTimestamp(this.timestamp);
		result.setPerformingAgent(this.performingAgent);
		result.setTradingActionEnum(this.tradingActionEnum);
		result.setProposal(this.proposal);
		return result;
	};

};
