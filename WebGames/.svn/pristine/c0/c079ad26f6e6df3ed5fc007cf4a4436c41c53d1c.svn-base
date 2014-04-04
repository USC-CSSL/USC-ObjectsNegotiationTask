package edu.usc.cct.rapport.web_games.client.factory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;

import edu.usc.cct.rapport.web_games.client.WebGamesPlaceController;

public class WebGamesGinjectionConfigurationModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).to(WebGamesPlaceController.class).in(Singleton.class);

		bind(IWebGamesPlaceFactory.class).to(WebGamesPlaceFactory.class).in(Singleton.class);
	};

};
