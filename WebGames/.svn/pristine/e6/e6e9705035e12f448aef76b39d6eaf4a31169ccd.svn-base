package edu.usc.cct.rapport.web_games.client.factory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceControllerProvider implements Provider<PlaceController> {

	final private EventBus eventBus;


	@Inject
	public PlaceControllerProvider(final EventBus eventBus) {
		this.eventBus = eventBus;
	};


	@Override
	public PlaceController get() {
		final PlaceController result = new PlaceController(eventBus);
		return result;
	};

};
