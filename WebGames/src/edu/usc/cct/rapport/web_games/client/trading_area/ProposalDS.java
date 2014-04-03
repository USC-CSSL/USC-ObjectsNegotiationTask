package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;
import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class ProposalDS implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private AgentEnum agentMakingProposal;
	private ArrayList<TradingObjectEnum> setOfTradingObjectEnum;
	private ArrayList<AllocationDS> tradingObjectsAllocation;


	public ProposalDS() {};


	public void setAgentMakingProposal(final AgentEnum agentMakingProposal) {
		this.agentMakingProposal = agentMakingProposal;
	};


	public void setSetOfTradingObjectEnum(final EnumSet<TradingObjectEnum> setOfTradingObjectEnum) {
		this.setOfTradingObjectEnum = new ArrayList<TradingObjectEnum>();
		for (final TradingObjectEnum tradingObjectEnum: setOfTradingObjectEnum) {
			this.setOfTradingObjectEnum.add(tradingObjectEnum);
		};
	};


	public void setTradingObjectsAllocation(final Map<Pair<AgentEnum, TradingObjectEnum>, Integer> tradingObjectsAllocation) {

		this.tradingObjectsAllocation = new ArrayList<AllocationDS>();

		// Enforce the ordering of the enums, instead of just looping through the key pairs.
		for (final AgentEnum agentEnum: AgentEnum.values()) {
			for (final TradingObjectEnum tradingObjectEnum: TradingObjectEnum.values()) {
				final Pair<AgentEnum, TradingObjectEnum> keyPair = new Pair<AgentEnum, TradingObjectEnum>(agentEnum, tradingObjectEnum);
				if (tradingObjectsAllocation.containsKey(keyPair)) {
					final AllocationDS allocation = new AllocationDS();
					allocation.setAgentMakingProposal(agentEnum);
					allocation.setTradingObjectEnum(tradingObjectEnum);
					allocation.setCount(tradingObjectsAllocation.get(keyPair));
					this.tradingObjectsAllocation.add(allocation);
				};
			};
		};
	};


	public AgentEnum getAgentMakingProposal() {
		return this.agentMakingProposal;
	};


	public ArrayList<TradingObjectEnum> getSetOfTradingObjectsEnum() {
		return this.setOfTradingObjectEnum;
	};


	public ArrayList<AllocationDS> getTradingObjectsAllocation() {
		return this.tradingObjectsAllocation;
	};

};
