package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

public class ComputeChangeInEmotionAsPerAntosReport implements IComputeChangeInEmotion {

	@Override
	public double computeChangeInEmotion(final double currentEmotionValue, final double expectationDeviation, final RelativePowerEnum relativePowerEnum) {

		final double result;

		switch (relativePowerEnum) {
		case high:
			if (expectationDeviation >= 0.0) {
				result = 0.15;
			} else if (expectationDeviation >= -5.0) {
				result = -0.1;
			} else if (expectationDeviation >= -15.0) {
				result = -0.3;
			} else {
				result = -0.4;
			};
			break;
		case balanced:
			if (expectationDeviation >= 0.0) {
				result = 0.15;
			} else if (expectationDeviation >= -5.0) {
				result = 0;
			} else if (expectationDeviation >= -15.0) {
				result = -0.2;
			} else {
				result = -0.3;
			};
			break;
		case low:
			if (expectationDeviation >= 0.0) {
				result = 0.35;
			} else if (expectationDeviation >= -5.0) {
				result = 0.1;
			} else if (expectationDeviation >= -15.0) {
				result = -0.1;
			} else {
				result = -0.2;
			};
			break;
		default:
			final IllegalStateException e = new IllegalStateException("Unhandled |" + relativePowerEnum.getClass().getName() + "| in |" + this.getClass().getName() + "|.computerChangeInEmotion().");
			throw e;
		};

		return result;
	};

};
