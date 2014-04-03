package edu.usc.cct.rapport.web_games.client.trading_area;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


public class ExperimentInformation {

	final private ExperimentConditions experimentConditions;
	final private NegotiationSession negotiationSession;


	public ExperimentInformation(final ExperimentConditions experimentConditions, final NegotiationSession negotiationSession/*, final TradingActionEnum lastTradingAction*/) {
		this.experimentConditions = experimentConditions;
		this.negotiationSession = negotiationSession;
	};


	public String toLogInformationString() {

		final StringBuilder builder = new StringBuilder();
		builder.append(experimentConditions);
		builder.append(negotiationSession);

		final String result = builder.toString();
		return result;
	};


	public String to2DFormattedString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("Experiment Conditions\n");
		builder.append("=====================\n");
		builder.append(experimentConditions.to2DFormattedString());
		builder.append('\n');
		builder.append("Negotiation Session\n");
		builder.append("===================\n");
		builder.append(negotiationSession.to2DFormattedString());
		builder.append('\n');

		final String result = builder.toString();
		return result;
	};


	public ExperimentConditions getExperimentConditions() {
		return this.experimentConditions;
	};


	public NegotiationSession getNegotiationSession() {
		final NegotiationSession result = new NegotiationSession(this.negotiationSession, 0);
		return result;
	};


	@Deprecated
	public TradingAction getLastTradingAction() {
		return this.negotiationSession.getMostRecentTradingAction();
	};


	public ExperimentInformationDS generateDoublySerializable() {
		final ExperimentInformationDS result = new ExperimentInformationDS();
		result.setExperimentConditions(this.experimentConditions);
		result.setNegotiationSession(this.negotiationSession);
		return result;
	};

};
