package edu.usc.cct.rapport.web_games.client;

import edu.usc.cct.rapport.web_games.client.factory.IWebGamesPlaceFactory;
import edu.usc.cct.rapport.web_games.client.factory.WebGamesGinjector;
import edu.usc.cct.rapport.web_games.client.factory.WebGamesGinjectorAccess;

public class WebGamesPlaceTokenizer {

	final protected IWebGamesPlaceFactory placeFactory;


	protected WebGamesPlaceTokenizer() {
		final WebGamesGinjector webGamesGinjector = new WebGamesGinjectorAccess().get();
		this.placeFactory = webGamesGinjector.getWebGamesPlaceFactory();
	};


	public String getToken(final WebGamesPlace place) {
		return place.getToken();
	};

};
