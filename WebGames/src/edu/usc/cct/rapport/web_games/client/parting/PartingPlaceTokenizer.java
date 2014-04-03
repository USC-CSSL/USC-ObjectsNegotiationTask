package edu.usc.cct.rapport.web_games.client.parting;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.usc.cct.rapport.web_games.client.WebGamesPlaceTokenizer;

@Prefix(PartingPlace.placeName)
public class PartingPlaceTokenizer extends WebGamesPlaceTokenizer implements PlaceTokenizer<PartingPlace> {

	@Override
	public String getToken(final PartingPlace place) {
		return Boolean.toString(place.userGaveConsent());
	};


	@Override
	public PartingPlace getPlace(final String token) {
		final PartingPlace result = placeFactory.createPartingPlace(token);
		return result;
	};

};
