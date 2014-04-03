package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class LogExperimentInformationEvent extends GwtEvent<LogExperimentInformationEventHandler> {

	static final Type<LogExperimentInformationEventHandler> TYPE = new Type<LogExperimentInformationEventHandler>();

	@Override
	public Type<LogExperimentInformationEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final LogExperimentInformationEventHandler handler) {
		handler.onLogExperimentInformationEvent(this);
	};

};
