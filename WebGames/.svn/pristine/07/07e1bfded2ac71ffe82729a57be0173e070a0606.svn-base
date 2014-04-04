package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;
//import java.util.Random;

public enum EmotionModellingStrategyEnum {
	alwaysHappy,
	alwaysContent,
	alwaysNeutral,
	alwaysAngry,
	alwaysSad,
	chosenUniformlyAtRandom,
	chosenSimilarlyToMethodDescribedInAntosReport,
	chosenSimilarlyToCSharpCode,
	everyOtherTurnSad,
	everyOtherTurnAngry,
	randomEveryOtherTurnSadOrAngryOrNeutral;


	public EmotionModellingStrategy getEmotionModellingStrategy() {

		final IComputeChangeInEmotion computeChangeInEmotion;
		final IComputeFacialExpressionAndIntensity computeFacialExpressionAndIntensity;
//		Random random = new Random();
//		boolean whichEmotion = random.nextBoolean();
		
		switch (this) {
			case chosenSimilarlyToMethodDescribedInAntosReport:
				computeChangeInEmotion = new ComputeChangeInEmotionAsPerAntosReport();
				computeFacialExpressionAndIntensity = new ComputeFacialExpressionAndIntensityAsPerAntosReport();
				break;
			case chosenSimilarlyToCSharpCode:
				computeChangeInEmotion = new ComputeChangeInEmotionAsPerCSharpCode();
				computeFacialExpressionAndIntensity = new ComputeFacialExpressionAndIntensityAsPerCSharpCode();
				break;
			case chosenUniformlyAtRandom:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new UniformlyRandomEmotionalReaction();
				break;
			case alwaysHappy:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedEmotionalReaction(FacialExpressionEnum.happy);
				break;
			case alwaysContent:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedEmotionalReaction(FacialExpressionEnum.content);
				break;
			case alwaysNeutral:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedEmotionalReaction(FacialExpressionEnum.neutral);
				break;
			case alwaysAngry:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedEmotionalReaction(FacialExpressionEnum.angry);
				break;
			case alwaysSad:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedEmotionalReaction(FacialExpressionEnum.sad);
				break;
			case everyOtherTurnAngry:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedAngryNeutralReactionEveryOtherTurn(FacialExpressionEnum.angry_neutral);
				break;
			case everyOtherTurnSad:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedSadNeutralReactionEveryOtherTurn(FacialExpressionEnum.sad_neutral);
				break;
			case randomEveryOtherTurnSadOrAngryOrNeutral:
				computeChangeInEmotion = new DoNotBotherToComputeChangeInEmotion();
				computeFacialExpressionAndIntensity = new FixedSadNeutralReactionEveryOtherTurn(FacialExpressionEnum.sad_neutral);
				break;
			default:
				final IllegalStateException e = new IllegalStateException("Unhandled |" + EmotionModellingStrategyEnum.class.getName() + "| in |" + EmotionModellingStrategyEnum.class.getName() + "|.getEmotionModellingPolicy().");
				throw e;
		};

		final IComputeAnticipatedProposalUtility computeAnticipatedProposalUtility = new ComputeMeanAgentPerceivedUtilityOfOffersThatEachAvailableAlgorithmicCounterpartWouldHaveMade();
		final EmotionModellingStrategy result = new EmotionModellingStrategy(computeAnticipatedProposalUtility, computeChangeInEmotion, computeFacialExpressionAndIntensity);

		return result;
	};

};
