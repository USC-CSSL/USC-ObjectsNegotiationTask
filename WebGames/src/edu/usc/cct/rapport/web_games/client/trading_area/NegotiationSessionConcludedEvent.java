package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class NegotiationSessionConcludedEvent extends GwtEvent<NegotiationSessionConcludedEventHandler> {

	static final Type<NegotiationSessionConcludedEventHandler> TYPE = new Type<NegotiationSessionConcludedEventHandler>();

	final private ExperimentInformation experimentInformation;


	public NegotiationSessionConcludedEvent(final ExperimentInformation experimentInformation) {
		this.experimentInformation = experimentInformation;
	};


	@Override
	public Type<NegotiationSessionConcludedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final NegotiationSessionConcludedEventHandler handler) {
		handler.onNegotiationSessionConclusion(this);
	};


	public Proposal getAcceptedProposal() {
		final Proposal result = this.experimentInformation.getNegotiationSession().getMostRecentTradingAction().getProposal();
		return result;
	};


	public ExperimentInformation getExperimentInformation() {
		return this.experimentInformation;
	};

};
