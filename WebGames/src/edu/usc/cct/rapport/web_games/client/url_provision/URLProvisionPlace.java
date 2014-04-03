package edu.usc.cct.rapport.web_games.client.url_provision;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.WebGamesPlace;

public class URLProvisionPlace extends WebGamesPlace implements IURLProvisionPlace {

	static final String placeName = "urlProvision";

	@Inject
	public URLProvisionPlace(final EventBus eventBus, @Assisted final String token) {
		super(eventBus, placeName, token, false);
	};


/*
	@Override
	public WebGamesActivity getActivity(final WebGamesGinjector webGamesGinjector) {
		final WebGamesActivity result = null;
		webGamesGinjector.setURLProvisionPlace(this);
	    final WebGamesActivity result = webGamesGinjector.getURLProvisionActivity();
		return result;
	};
*/
};
