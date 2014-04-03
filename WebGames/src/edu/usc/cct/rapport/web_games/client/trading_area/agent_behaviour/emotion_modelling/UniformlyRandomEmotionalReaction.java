package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class UniformlyRandomEmotionalReaction implements IComputeFacialExpressionAndIntensity {

	@Override
	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum) {
		final FixedEmotionalReaction fixedEmotionalReaction = new FixedEmotionalReaction(FacialExpressionEnum.getRandomValue());
		final Pair<FacialExpressionEnum, Double> result = fixedEmotionalReaction.computeFacialExpressionAndIntensity(emotionValue, relativePowerEnum);
		return result;
	};

};
