package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumMap;
import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public class PrespecifiedNonconcederFruits3 implements PlyRemainingIndexedProposalGenerator {

	public Proposal getPrespecifiedPotentialCounterproposal(final EnumSet<TradingObjectEnum> setOfTradingObjectEnum, final int plyRemaining) {

		final int turnsRemaining = plyRemaining / 3;
		if (turnsRemaining <= 0) {
			final IllegalStateException e = new IllegalStateException("No potential counterproposal is possible without a positive number of turns remaining in the negotiation.");
			throw e;
		};

		final EnumMap<TradingObjectEnum, Integer> potentialCounterproposal = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);
		final int[] prespecifiedTradingObjectCounts;

		switch (turnsRemaining) {
			case 1:
				prespecifiedTradingObjectCounts = new int[]{3, 4, 3};
				break;
			case 2:
				prespecifiedTradingObjectCounts = new int[]{3, 4, 3};
				break;
			case 3:
				prespecifiedTradingObjectCounts = new int[]{4, 4, 3};
				break;
			case 4:
				prespecifiedTradingObjectCounts = new int[]{4, 4, 4};
				break;
			case 5:
				prespecifiedTradingObjectCounts = new int[]{4, 5, 4};
				break;
			case 6:
				prespecifiedTradingObjectCounts = new int[]{5, 5, 4};
				break;
			default:
				prespecifiedTradingObjectCounts = new int[]{5, 5, 5};
		};

		int tradingObjectCountIndex = 0;
		for (final TradingObjectEnum tradingObjectEnum: setOfTradingObjectEnum) {
			potentialCounterproposal.put(tradingObjectEnum, prespecifiedTradingObjectCounts[tradingObjectCountIndex]);
			++tradingObjectCountIndex;
		};

		final Proposal result = new Proposal(AgentEnum.counterpart, potentialCounterproposal);
		return result;
	};

};
