package edu.usc.cct.rapport.web_games.client.trading_area;

import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


public class ExperimentInformationDS implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private ExperimentConditions experimentConditions;
	private NegotiationSessionDS negotiationSession;


	public ExperimentInformationDS() {};


	public void setExperimentConditions(final ExperimentConditions experimentConditions) {
		this.experimentConditions = experimentConditions;
	};


	public void setNegotiationSession(final NegotiationSession negotiationSession) {
		this.negotiationSession = negotiationSession.generateDoublySerializable();
	};


	public ExperimentConditions getExperimentConditions() {
		return this.experimentConditions;
	};


	public NegotiationSessionDS getNegotiationSession() {
		return this.negotiationSession;
	};

};
