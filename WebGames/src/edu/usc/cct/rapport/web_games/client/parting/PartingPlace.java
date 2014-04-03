package edu.usc.cct.rapport.web_games.client.parting;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.WebGamesPlace;

public class PartingPlace extends WebGamesPlace implements IPartingPlace {

	static final String placeName = "parting";

	final private boolean userGaveConsent;


	@Inject
	public PartingPlace(final EventBus eventBus, @Assisted final boolean userGaveConsent) {
		super(eventBus, placeName, null, false);
		this.userGaveConsent = userGaveConsent;
	};


	public boolean userGaveConsent() {
		return this.userGaveConsent;
	};

/*
	@Override
	public WebGamesActivity getActivity(final WebGamesGinjector webGamesGinjector) {
		final WebGamesActivity result = null;
		webGamesGinjector.setPartingAreaPlace(this);
	    final WebGamesActivity result = webGamesGinjector.getURLProvisionActivity();
		return result;
	};
*/
};
