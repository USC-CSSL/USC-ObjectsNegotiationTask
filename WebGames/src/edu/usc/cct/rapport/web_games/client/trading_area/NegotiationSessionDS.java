package edu.usc.cct.rapport.web_games.client.trading_area;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;


public class NegotiationSessionDS implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private TradingObjectSetEnum tradingObjectSetEnum;
	private int maximumPly;
	private AgentEnum agentWhoActsLastIfNoAgreementIsReached;
	private ArrayList<TradingActionDS> history;
	private ArrayList<TradingExpressionDS> expressionHistory;


	public NegotiationSessionDS() {};


	public ArrayList<String> getObjectScalarFieldHeaders() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		result.add("tradingObjectSetEnum");
		result.add("maximumPly");
		result.add("agentWhoActsLastIfNoAgreementIsReached");

		return result;
	};


	public ArrayList<String> getObjectScalarFieldData() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		result.add(this.tradingObjectSetEnum.name());
		result.add(Integer.toString(this.maximumPly));
		result.add(this.agentWhoActsLastIfNoAgreementIsReached.name());

		return result;
	};


	public void setTradingObjectSetEnum(final TradingObjectSetEnum tradingObjectSetEnum) {
		this.tradingObjectSetEnum = tradingObjectSetEnum;
	};


	public void setMaximumPly(final Integer maximumPly) {
		this.maximumPly = maximumPly;
	};


	public void setAgentWhoActsLastIfNoAgreementIsReached(final AgentEnum agentWhoActsLastIfNoAgreementIsReached) {
		this.agentWhoActsLastIfNoAgreementIsReached = agentWhoActsLastIfNoAgreementIsReached;
	};


	public void setHistory(final ArrayList<TradingAction> history) {
		this.history = new ArrayList<TradingActionDS>();
		for (final TradingAction tradingAction: history) {
			this.history.add(tradingAction.generateDoublySerializable());
		};
	};


	public void setExpressionHistory(final ArrayList<TradingExpression> expressionHistory) {
		this.expressionHistory = new ArrayList<TradingExpressionDS>();
		for (final TradingExpression tradingExpression: expressionHistory) {
			this.expressionHistory.add(tradingExpression.generateDoublySerializable());
		};
	};


	public TradingObjectSetEnum getTradingObjectSetEnum() {
		final TradingObjectSetEnum result = TradingObjectSetEnum.valueOf(tradingObjectSetEnum.name());
		return result;
	};


	public AgentEnum getAgentWhoActsLastIfNoAgreementIsReached() {
		return this.agentWhoActsLastIfNoAgreementIsReached;
	};


	public int getPlyRemaining() {
		final int result = this.maximumPly - history.size();
		return result;
	};


	public List<TradingActionDS> getHistory() {
		final List<TradingActionDS> result = Collections.unmodifiableList(this.history);
		return result;
	};


	public List<TradingExpressionDS> getExpressionHistory() {
		final List<TradingExpressionDS> result = Collections.unmodifiableList(this.expressionHistory);
		return result;
	};

};
