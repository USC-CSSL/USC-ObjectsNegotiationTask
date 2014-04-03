package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumMap;
import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingActionEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public class TitfortatPotentialCounterproposalTactic implements ProposalDecisionMakingTactic {

	public Pair<TradingActionEnum, Proposal> acceptProposalOrOfferCounterproposal(final NegotiationSession negotiationSession, final int counterpartBestAlternativeToNegotiatedActionValue) {

		final EnumSet<TradingObjectEnum> setOfTradingObjectEnum = negotiationSession.getTradingObjectSetEnum().getSetOfTradingObjectEnum();
		final Proposal potentialCounterproposal;
		final Proposal mostRecentlyOfferedProposal = negotiationSession.getMostRecentProposal();
		final int valueOfMostRecentlyOfferedProposal;
		if (null == mostRecentlyOfferedProposal) {
			valueOfMostRecentlyOfferedProposal = Integer.MIN_VALUE;
			
			final EnumMap<TradingObjectEnum, Integer> firstproposal = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);
 			final int[] prespecifiedTradingObjectCounts = new int[]{1, 1, 1, 0};
 			int tradingObjectCountIndex = 0;
			for (final TradingObjectEnum tradingObjectEnum: setOfTradingObjectEnum) {
				firstproposal.put(tradingObjectEnum, prespecifiedTradingObjectCounts[tradingObjectCountIndex]);
				++tradingObjectCountIndex;
			};

			potentialCounterproposal = new Proposal(AgentEnum.counterpart, firstproposal);
		} else {
			final EnumMap<TradingObjectEnum, Integer> counterproposal = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);

			for (final Pair<AgentEnum, TradingObjectEnum> agentEnumTradingObjectEnumPair: mostRecentlyOfferedProposal.getTradingObjectsAllocation().keySet()) {
				if (false == agentEnumTradingObjectEnumPair.getFirst().equals(AgentEnum.player)) {
					continue;
				};
				final TradingObjectEnum tradingObjectEnum = agentEnumTradingObjectEnumPair.getSecond();
				int quantityOfthisTradingObject = mostRecentlyOfferedProposal.getTradingObjectsAllocation().get(agentEnumTradingObjectEnumPair);
				counterproposal.put(tradingObjectEnum, quantityOfthisTradingObject);
			};

			potentialCounterproposal = new Proposal(AgentEnum.counterpart, counterproposal);
			valueOfMostRecentlyOfferedProposal = mostRecentlyOfferedProposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
		};

		final int valueOfPotentialCounterproposal = potentialCounterproposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
		final Pair<TradingActionEnum, Proposal> result;
		if (valueOfMostRecentlyOfferedProposal >= valueOfPotentialCounterproposal) {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.acceptProposal, null);
		} else {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.makeCounterproposal, potentialCounterproposal);
		};

		return result;
	};

};
