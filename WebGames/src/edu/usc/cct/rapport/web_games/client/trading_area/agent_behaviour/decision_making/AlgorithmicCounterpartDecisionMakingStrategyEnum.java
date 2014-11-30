package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;



public enum AlgorithmicCounterpartDecisionMakingStrategyEnum {
/*	prespecifiedConcederLastOfferFixed,
	prespecifiedConcederFirstOfferFixed,
	prespecifiedNonconcederLastOfferFixed,
	prespecifiedNonconcederFirstOfferFixed;*/
	prespecifiedAgentForTrial,
	prespecifiedConceder,
	prespecifiedConcederFruits2,
	prespecifiedConcederFruits3,
	prespecifiedConcederFruits4,
	prespecifiedConcederFruits5,
	prespecifiedConcederFruits6,
	prespecifiedNonconceder,
	prespecifiedNonconcederFruits2,
	prespecifiedNonconcederFruits3,
	prespecifiedNonconcederFruits4,
	prespecifiedNonconcederFruits5,
	prespecifiedNonconcederFruits6;
/*	prespecifiedConcederGentleSlope,
	prespecifiedNonconcederSteepSlope,
	randomStrategy2,
	randomStrategy,
	prespecifiedSymbolicAgent,
	prespecifiedFinancialAgent,
	SymbolicOrFinancialAgents,
	titfortat;*/

	public String toString() {

		final String result;

		switch (this) {
/*		case prespecifiedConcederFirstOfferFixed:
			result = "Conceder, using its most greedy preprogrammed offers";
			break;*/
		case prespecifiedAgentForTrial:
			result = "Prespecified agent for trial game (veggie set)";
			break;
		case prespecifiedConceder:
//			result = "Conceder, using its least greedy preprogrammed offers";
			result = "Conceder for fruits1 set";
			break;
		case prespecifiedConcederFruits2:
			result = "Conceder for fruits2 set";
			break;
		case prespecifiedConcederFruits3:
			result = "Conceder for fruits3 set";
			break;
		case prespecifiedConcederFruits4:
			result = "Conceder for fruits4 set";
			break;
		case prespecifiedConcederFruits5:
			result = "Conceder for fruits5 set";
			break;
		case prespecifiedConcederFruits6:
			result = "Conceder for fruits6 set";
			break;
		case prespecifiedNonconceder:
//			result = "Non-conceder, using its most greedy preprogrammed offers";
			result = "Non-conceder for fruits1 set";
			break;
		case prespecifiedNonconcederFruits2:
			result = "Non-conceder for fruits2 set";
			break;
		case prespecifiedNonconcederFruits3:
			result = "Non-conceder for fruits3 set";
			break;
		case prespecifiedNonconcederFruits4:
			result = "Non-conceder for fruits4 set";
			break;
		case prespecifiedNonconcederFruits5:
			result = "Non-conceder for fruits5 set";
			break;
		case prespecifiedNonconcederFruits6:
			result = "Non-conceder for fruits6 set";
			break;
/*		case prespecifiedConcederGentleSlope:
			result = "Conceder2, using its 2nd least greedy preprogrammed offers";
			break;			
		case prespecifiedNonconcederSteepSlope:
			result = "Non-conceder2, using its 2nd most greedy preprogrammed offers";
			break;
//		case prespecifiedNonconcederLastOfferFixed:
//			result = "Non-conceder, using its least greedy preprogrammed offers.";
//			break;
		case prespecifiedSymbolicAgent:
			result = "Symbolic agent, symbolic concessions in the second half";
			break;
		case prespecifiedFinancialAgent:
			result = "Financial agent, financial concessions in the second half";
			break;
		case randomStrategy2:
			result = "Random2: Non-conceder or Conceder";
			break;
		case randomStrategy:
			result = "Random: Non-conceder, Non-conceder2, Conceder or Conceder2";
			break;
		case SymbolicOrFinancialAgents:
			result = "Random: Symbolic agent, Financial agent";
			break;
		case titfortat:
			result = "Tit for tat";
			break;*/
		default:
			final IllegalStateException e = new IllegalStateException("Unhandled " + this.getClass().getName() + " in " + this.getClass().getName() + ".toString()");
			throw e;
		};

		return result;
	};


	public ProposalDecisionMakingStrategy getProposalDecisionMakingStrategy(final int negotiationSessionPlyCount) {

/*		final PlyRemainingIndexedProposalGenerator proposalGenerator;		
		switch (this) {
		//case prespecifiedConcederLastOfferFixed:
		case prespecifiedConceder:
			proposalGenerator = new PrespecifiedConceder();
			break;
		//case prespecifiedNonconcederLastOfferFixed:
		case prespecifiedNonconceder:
			proposalGenerator = new PrespecifiedNonconceder();
			break;
		case randomStrategy:
			proposalGenerator = new PrespecifiedNonconceder();
			break;
		case titfortat:
			proposalGenerator = new Titfortat();
			break;
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");
		};

		final int plyAdjustmentOffset;
		switch (this) {
		//case prespecifiedConcederLastOfferFixed:
		case prespecifiedConceder:
			//plyAdjustmentOffset = 0;
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		//case prespecifiedConcederFirstOfferFixed:
		case prespecifiedNonconceder:
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		case titfortat:
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");		
		};*/

		// Added Tit for Tat
		final ProposalDecisionMakingTactic tactic;
		switch (this) {
		case prespecifiedAgentForTrial:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedAgentForTrial(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConceder:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConceder(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederFruits2:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederFruits2(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederFruits3:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederFruits3(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederFruits4:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederFruits4(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederFruits5:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederFruits5(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederFruits6:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederFruits6(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconceder:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconceder(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederFruits2:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederFruits2(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederFruits3:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederFruits3(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederFruits4:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederFruits4(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederFruits5:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederFruits5(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederFruits6:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederFruits6(), 24 - negotiationSessionPlyCount);
			break;
/*		case prespecifiedConcederGentleSlope:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederGentleSlope(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederSteepSlope:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederSteepSlope(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedSymbolicAgent:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedSymbolicAgent(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedFinancialAgent:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedFinancialAgent(), 24 - negotiationSessionPlyCount);
			break;
		case titfortat:
			tactic = new TitfortatPotentialCounterproposalTactic();
			break;*/
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");		
		}
		
//		final ProposalDecisionMakingTactic tactic = new PrespecifiedPotentialCounterproposalTactic(proposalGenerator, plyAdjustmentOffset);
		final ProposalDecisionMakingStrategy result = new RationalProposalDecisionMakingStrategy(tactic);
		return result;
	};

};
