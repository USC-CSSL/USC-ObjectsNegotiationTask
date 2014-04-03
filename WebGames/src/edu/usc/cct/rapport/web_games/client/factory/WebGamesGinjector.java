package edu.usc.cct.rapport.web_games.client.factory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;


@GinModules(WebGamesGinjectionConfigurationModule.class)
public interface WebGamesGinjector extends Ginjector {

	EventBus getEventBus();
	PlaceController getPlaceController();

	IWebGamesPlaceFactory getWebGamesPlaceFactory();
};
