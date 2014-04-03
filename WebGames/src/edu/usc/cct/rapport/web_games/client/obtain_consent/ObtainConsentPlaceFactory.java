package edu.usc.cct.rapport.web_games.client.obtain_consent;

import javax.inject.Inject;

import com.google.gwt.event.shared.EventBus;

public class ObtainConsentPlaceFactory implements IObtainConsentPlaceFactory {

	final private EventBus eventBus;

	@Inject
	public ObtainConsentPlaceFactory(final EventBus eventBus) {
		this.eventBus = eventBus;
	};


	@Override
	public ObtainConsentPlace create(final String token) {
		final ObtainConsentPlace result = new ObtainConsentPlace(eventBus, token);
		return result;
	};

};
