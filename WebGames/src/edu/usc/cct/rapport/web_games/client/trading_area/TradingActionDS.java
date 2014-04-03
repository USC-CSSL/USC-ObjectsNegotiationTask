package edu.usc.cct.rapport.web_games.client.trading_area;

import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;


public class TradingActionDS implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private double timestamp;
	private AgentEnum performingAgent;
	private String tradingActionEnum;
	private ProposalDS proposal;


	public TradingActionDS() {};


	public void setTimestamp(final double timestamp) {
		this.timestamp = timestamp;
	};


	public void setPerformingAgent(final AgentEnum performingAgent) {
		this.performingAgent = performingAgent;
	};


	public void setTradingActionEnum(final TradingActionEnum tradingActionEnum) {
		this.tradingActionEnum = tradingActionEnum.name();
	};


	public void setProposal(final Proposal proposal) {
		if (null == proposal) {
			this.proposal = null;
		} else {
			this.proposal = proposal.generateDoublySerializable();
		};
	};


	public AgentEnum getPerformingAgent() {
		final AgentEnum result = AgentEnum.valueOf(this.performingAgent.name());
		return result;
	};


	public double getTimestamp() {
		return this.timestamp;
	};


	public String getTradingActionEnum() {
		return this.tradingActionEnum;
	};


	public ProposalDS getProposal() {
		return this.proposal;
	};

};
