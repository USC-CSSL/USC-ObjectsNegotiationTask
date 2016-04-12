package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;
/*import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedConceder;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedNonconceder;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedConcederGentleSlope;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedNonconcederSteepSlope;*/
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedSoftGentleSlopeStrategyFruits1;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedSoftSteepSlopeStrategyFruits3;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedToughGentleSlopeStrategyFruits5;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedToughSteepSlopeStrategyFruits7;

public class ComputeMeanAgentPerceivedUtilityOfOffersThatEachAvailableAlgorithmicCounterpartWouldHaveMade implements IComputeAnticipatedProposalUtility {

/*	final PrespecifiedConceder prespecifiedConceder;
	final PrespecifiedNonconceder prespecifiedNonconceder;
//	final PrespecifiedConcederGentleSlope 	prespecifiedConcederGentleSlope;
//	final PrespecifiedNonconcederSteepSlope prespecifiedNonconcederSteepSlope;*/
	final PrespecifiedSoftGentleSlopeStrategyFruits1 prespecifiedSoftGentleSlopeStrategyFruits1;
	final PrespecifiedSoftSteepSlopeStrategyFruits3 prespecifiedSoftSteepSlopeStrategyFruits3;
	final PrespecifiedToughGentleSlopeStrategyFruits5 prespecifiedToughGentleSlopeStrategyFruits5;
	final PrespecifiedToughSteepSlopeStrategyFruits7 prespecifiedToughSteepSlopeStrategyFruits7;

	public ComputeMeanAgentPerceivedUtilityOfOffersThatEachAvailableAlgorithmicCounterpartWouldHaveMade() {
/*		this.prespecifiedConceder = new PrespecifiedConceder();
		this.prespecifiedNonconceder = new PrespecifiedNonconceder();
//		this.prespecifiedConcederGentleSlope 	= new PrespecifiedConcederGentleSlope();
//		this.prespecifiedNonconcederSteepSlope 	= new PrespecifiedNonconcederSteepSlope();*/
		this.prespecifiedSoftGentleSlopeStrategyFruits1 	= new PrespecifiedSoftGentleSlopeStrategyFruits1();
		this.prespecifiedSoftSteepSlopeStrategyFruits3 	= new PrespecifiedSoftSteepSlopeStrategyFruits3();
		this.prespecifiedToughGentleSlopeStrategyFruits5 	= new PrespecifiedToughGentleSlopeStrategyFruits5();
		this.prespecifiedToughSteepSlopeStrategyFruits7 	= new PrespecifiedToughSteepSlopeStrategyFruits7();
	};


	@Override
	public double computeAnticipatedProposalUtility(final int playerBATNA, final int counterpartBATNA, final NegotiationSession negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered) {

		final EnumSet<TradingObjectEnum> setOfTradingObjectEnum = negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered.getTradingObjectSetEnum().getSetOfTradingObjectEnum();
		final int plyRemaining = negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered.getPlyRemaining();

		final Proposal proposalPrespecifiedSoftGentleSlopeStrategyWouldHaveOffered = this.prespecifiedSoftGentleSlopeStrategyFruits1.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
		final Proposal proposalPrespecifiedSoftSteepSlopeStrategyWouldHaveOffered = this.prespecifiedSoftSteepSlopeStrategyFruits3.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
		final Proposal proposalPrespecifiedToughGentleSlopeStrategyWouldHaveOffered = this.prespecifiedToughGentleSlopeStrategyFruits5.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
		final Proposal proposalPrespecifiedToughSteepSlopeStrategyWouldHaveOffered = this.prespecifiedToughSteepSlopeStrategyFruits7.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
/*		final Proposal proposalPrespecifiedConcederWouldHaveOffered = this.prespecifiedConceder.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
		final Proposal proposalPrespecifiedNonconcederWouldHaveOffered = this.prespecifiedNonconceder.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
//		final Proposal proposalPrespecifiedConcederGentleSlopeWouldHaveOffered = this.prespecifiedConcederGentleSlope.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
//		final Proposal proposalPrespecifiedNonconcederSteepSlopeWouldHaveOffered = this.prespecifiedNonconcederSteepSlope.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);*/

		final double result = (proposalPrespecifiedSoftGentleSlopeStrategyWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
				+ proposalPrespecifiedSoftSteepSlopeStrategyWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
				+ proposalPrespecifiedToughGentleSlopeStrategyWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
				+ proposalPrespecifiedToughSteepSlopeStrategyWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
				)/4.0;
/*		final double result = (proposalPrespecifiedConcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart) + proposalPrespecifiedNonconcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart))/2.0;
//		final double result = (proposalPrespecifiedConcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedNonconcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedConcederGentleSlopeWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedNonconcederSteepSlopeWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				)/4.0;*/
		return result;
	};

};
