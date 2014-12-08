package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class Proposal {

	static final private int itemsPerTradingObjectCategoryCount = 3;	// when there are 3 items each
//	static final private int itemsPerTradingObjectCategoryCount = 5;	// when there are 5 items each

	final private AgentEnum agentMakingProposal;
	final private EnumSet<TradingObjectEnum> setOfTradingObjectEnum;
	final private Map<Pair<AgentEnum, TradingObjectEnum>, Integer> tradingObjectsAllocation;


	public Proposal(final AgentEnum agentMakingProposal, final EnumMap<TradingObjectEnum, Integer> tradingObjectsRetainedByAgent) {

		this.agentMakingProposal = agentMakingProposal;
		this.setOfTradingObjectEnum = EnumSet.noneOf(TradingObjectEnum.class);
		this.tradingObjectsAllocation = new HashMap<Pair<AgentEnum, TradingObjectEnum>, Integer>();

		for (final TradingObjectEnum tradingObjectEnum: tradingObjectsRetainedByAgent.keySet()) {
			this.setOfTradingObjectEnum.add(tradingObjectEnum);
			final int tradingObjectsRetained = tradingObjectsRetainedByAgent.get(tradingObjectEnum);
			assert ((0 <= tradingObjectsRetained) && (tradingObjectsRetained <= itemsPerTradingObjectCategoryCount));
			this.tradingObjectsAllocation.put(new Pair<AgentEnum, TradingObjectEnum>(this.agentMakingProposal, tradingObjectEnum), tradingObjectsRetained);
			this.tradingObjectsAllocation.put(new Pair<AgentEnum, TradingObjectEnum>(AgentEnum.getOtherAgent(this.agentMakingProposal), tradingObjectEnum), itemsPerTradingObjectCategoryCount - tradingObjectsRetained);
		};
	};

	public int getItemsPerTradingObjectCategoryCount() {
		return itemsPerTradingObjectCategoryCount;
	}

	public AgentEnum getAgentWhoMadeProposal() {
		final AgentEnum result = Enum.valueOf(AgentEnum.class, this.agentMakingProposal.name());
		return result;
	};


	public EnumSet<TradingObjectEnum> getSetOfTradingObjectEnum() {
		final EnumSet<TradingObjectEnum> result = EnumSet.copyOf(this.setOfTradingObjectEnum);
		return result;
	};


	public int getProposalValueFromAgentPerspective(final AgentEnum agentEnum) {

		int result = 0;
		for (final Pair<AgentEnum, TradingObjectEnum> agentEnumTradingObjectEnumPair: tradingObjectsAllocation.keySet()) {
			if (false == agentEnumTradingObjectEnumPair.getFirst().equals(agentEnum)) {
				continue;
			};
			final TradingObjectEnum tradingObjectEnum = agentEnumTradingObjectEnumPair.getSecond();
			final int payoffForOneOfThisTradingObject = tradingObjectEnum.getPayoff(agentEnum);
			final int quantityOfthisTradingObject = tradingObjectsAllocation.get(agentEnumTradingObjectEnumPair);
			final int payoffForAllAllocatedOfThisTradingObject = payoffForOneOfThisTradingObject * quantityOfthisTradingObject;
			result += payoffForAllAllocatedOfThisTradingObject;
		};

		return result;
	};


	public int getMaximumPossibleProposalValueFromAgentPerspective(final AgentEnum agentEnum) {

		int result = 0;
		for (final Pair<AgentEnum, TradingObjectEnum> agentEnumTradingObjectEnumPair: tradingObjectsAllocation.keySet()) {
			if (false == agentEnumTradingObjectEnumPair.getFirst().equals(agentEnum)) {
				continue;
			};
			final TradingObjectEnum tradingObjectEnum = agentEnumTradingObjectEnumPair.getSecond();
			final int payoffForOneOfThisTradingObject = tradingObjectEnum.getPayoff(agentEnum);
			final int payoffForMaximumOfThisTradingObject = payoffForOneOfThisTradingObject * itemsPerTradingObjectCategoryCount;
			result += payoffForMaximumOfThisTradingObject;
		};

		return result;
	};


	public Map<Pair<AgentEnum, TradingObjectEnum>, Integer> getTradingObjectsAllocation() {
		final Map<Pair<AgentEnum, TradingObjectEnum>, Integer> result = Collections.unmodifiableMap(this.tradingObjectsAllocation);
		return result;
	};


	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append(setOfTradingObjectEnum.toString());
		builder.append(", ");
		builder.append(agentMakingProposal.toString());
		for (final TradingObjectEnum tradingObjectEnum: setOfTradingObjectEnum) {
			builder.append(", ");
			builder.append(tradingObjectEnum.toString());
			builder.append("=P");
			builder.append(tradingObjectsAllocation.get(new Pair<AgentEnum, TradingObjectEnum>(AgentEnum.player, tradingObjectEnum)));
			builder.append("/C");
			builder.append(tradingObjectsAllocation.get(new Pair<AgentEnum, TradingObjectEnum>(AgentEnum.counterpart, tradingObjectEnum)));
		};
		builder.append(", payoff=P");
		builder.append(this.getProposalValueFromAgentPerspective(AgentEnum.player));
		builder.append("/C");
		builder.append(this.getProposalValueFromAgentPerspective(AgentEnum.counterpart));
		builder.append('}');

		final String result = builder.toString();
		return result;
	};


	public ProposalDS generateDoublySerializable() {
		final ProposalDS result = new ProposalDS();
		result.setAgentMakingProposal(this.agentMakingProposal);
		result.setSetOfTradingObjectEnum(this.setOfTradingObjectEnum);
		result.setTradingObjectsAllocation(this.tradingObjectsAllocation);
		return result;
	};

};
