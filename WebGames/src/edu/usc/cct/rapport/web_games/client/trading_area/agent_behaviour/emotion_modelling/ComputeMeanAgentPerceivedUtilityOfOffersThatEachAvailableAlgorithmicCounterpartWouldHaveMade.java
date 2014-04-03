package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedConceder;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedNonconceder;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedConcederGentleSlope;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.PrespecifiedNonconcederSteepSlope;

public class ComputeMeanAgentPerceivedUtilityOfOffersThatEachAvailableAlgorithmicCounterpartWouldHaveMade implements IComputeAnticipatedProposalUtility {

	final PrespecifiedConceder prespecifiedConceder;
	final PrespecifiedNonconceder prespecifiedNonconceder;
//	final PrespecifiedConcederGentleSlope 	prespecifiedConcederGentleSlope;
//	final PrespecifiedNonconcederSteepSlope prespecifiedNonconcederSteepSlope;

	public ComputeMeanAgentPerceivedUtilityOfOffersThatEachAvailableAlgorithmicCounterpartWouldHaveMade() {
		this.prespecifiedConceder = new PrespecifiedConceder();
		this.prespecifiedNonconceder = new PrespecifiedNonconceder();
//		this.prespecifiedConcederGentleSlope 	= new PrespecifiedConcederGentleSlope();
//		this.prespecifiedNonconcederSteepSlope 	= new PrespecifiedNonconcederSteepSlope();
	};


	@Override
	public double computeAnticipatedProposalUtility(final int playerBATNA, final int counterpartBATNA, final NegotiationSession negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered) {

		final EnumSet<TradingObjectEnum> setOfTradingObjectEnum = negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered.getTradingObjectSetEnum().getSetOfTradingObjectEnum();
		final int plyRemaining = negotiationSessionAtPlyImmediatelyPriorToWhereAlternativesAreBeingConsidered.getPlyRemaining();

		final Proposal proposalPrespecifiedConcederWouldHaveOffered = this.prespecifiedConceder.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
		final Proposal proposalPrespecifiedNonconcederWouldHaveOffered = this.prespecifiedNonconceder.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
//		final Proposal proposalPrespecifiedConcederGentleSlopeWouldHaveOffered = this.prespecifiedConcederGentleSlope.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);
//		final Proposal proposalPrespecifiedNonconcederSteepSlopeWouldHaveOffered = this.prespecifiedNonconcederSteepSlope.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, plyRemaining);

		final double result = (proposalPrespecifiedConcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart) + proposalPrespecifiedNonconcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart))/2.0;
//		final double result = (proposalPrespecifiedConcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedNonconcederWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedConcederGentleSlopeWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				+ proposalPrespecifiedNonconcederSteepSlopeWouldHaveOffered.getProposalValueFromAgentPerspective(AgentEnum.counterpart)
//				)/4.0;
		return result;
	};

};
