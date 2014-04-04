package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class TenativeProposalUpdatedEvent extends GwtEvent<TenativeProposalUpdatedEventHandler> {

	static final private Type<TenativeProposalUpdatedEventHandler> TYPE = new Type<TenativeProposalUpdatedEventHandler>();

	@Override
	public Type<TenativeProposalUpdatedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final TenativeProposalUpdatedEventHandler handler) {
		handler.onProposalUpdate(this);
	};

};
