package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class NegotiationConclusionAcknowledgedEvent extends GwtEvent<NegotiationConclusionAcknowledgedEventHandler> {

	static final Type<NegotiationConclusionAcknowledgedEventHandler> TYPE = new Type<NegotiationConclusionAcknowledgedEventHandler>();

	@Override
	public Type<NegotiationConclusionAcknowledgedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final NegotiationConclusionAcknowledgedEventHandler handler) {
		handler.onNegotiationConclusionAcknowledgement(this);
	};

};
