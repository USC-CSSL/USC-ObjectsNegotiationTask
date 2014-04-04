package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;

public class DeterBackingUpThroughPlaceHistoryHandler implements ValueChangeHandler<String>, ClosingHandler /*, PlaceChangeRequestEvent.Handler*/ {

	final private String deterBackingUpThroughHistoryToken = "deterBackingUpThroughHistoryToken";

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {
		final String historyToken = event.getValue();
		if (false == historyToken.equals(deterBackingUpThroughHistoryToken)) {
			History.newItem(deterBackingUpThroughHistoryToken);		
		};
	};

	@Override
	public void onWindowClosing(final ClosingEvent event) {
		// TODO: Determine whether this string actually becomes user-visible, and if so, then internationalize it.
		event.setMessage("Back button functionality is unsupported and will void the experiment.");
	};

};
