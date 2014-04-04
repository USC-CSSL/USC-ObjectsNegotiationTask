package edu.usc.cct.rapport.web_games.client.trading_area;

import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;


public class TradingExpressionDS implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private double timestamp;
	private AgentEnum performingAgent;
	private FacialExpressionEnum facialExpressionEnum;


	public TradingExpressionDS() {};


	public void setTimestamp(final double timestamp) {
		this.timestamp = timestamp;
	};


	public void setPerformingAgent(final AgentEnum performingAgent) {
		this.performingAgent = performingAgent;
	};


	public void setFacialExpressionEnum(final FacialExpressionEnum facialExpressionEnum) {
		this.facialExpressionEnum = facialExpressionEnum;
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

};
