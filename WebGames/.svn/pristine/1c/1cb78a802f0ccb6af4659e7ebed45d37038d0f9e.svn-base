package edu.usc.cct.rapport.web_games.client.testing;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

import edu.usc.cct.rapport.web_games.client.WebGamesPlaceTokenizer;

@Prefix("testing")
public class TestingPlaceTokenizer extends WebGamesPlaceTokenizer implements PlaceTokenizer<TestingPlace> {

	@Inject Provider<TestingPlace> provider;


	@Override
	public String getToken(final TestingPlace place) {
		return super.getToken(place);
	};


	@Override
	public TestingPlace getPlace(final String token) {
		final TestingPlace result = placeFactory.createTestingPlace(token);
		return result;
	};

};
