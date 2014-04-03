package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public interface IComputeFacialExpressionAndIntensity {

	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum);
};
