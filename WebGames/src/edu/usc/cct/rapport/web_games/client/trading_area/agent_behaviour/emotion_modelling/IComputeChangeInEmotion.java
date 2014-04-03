package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

public interface IComputeChangeInEmotion {

	public double computeChangeInEmotion(final double currentEmotionValue, final double expectationDeviation, final RelativePowerEnum relativePowerEnum);
};
