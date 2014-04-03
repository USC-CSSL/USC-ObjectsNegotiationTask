package edu.usc.cct.rapport.web_games.client.obtain_consent;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.usc.cct.rapport.web_games.client.WebGamesPlaceTokenizer;


@Prefix(ObtainConsentPlace.placeName)
public class ObtainConsentPlaceTokenizer extends WebGamesPlaceTokenizer implements PlaceTokenizer<ObtainConsentPlace> {

	@Override
	public String getToken(final ObtainConsentPlace place) {
		return super.getToken(place);
	};


	@Override
	public ObtainConsentPlace getPlace(final String token) {
		final ObtainConsentPlace result = placeFactory.createObtainConsentPlace(token);
		return result;
	};

};
