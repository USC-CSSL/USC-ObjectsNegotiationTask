package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Composite;

abstract public class WebGamesView extends Composite implements IWebGamesView {

	final protected EventBus eventBus;
	final protected PlaceController placeController;

	public WebGamesView(final EventBus eventBus, final PlaceController placeController) {
		this.eventBus = eventBus;
		this.placeController = placeController;
	};

};
