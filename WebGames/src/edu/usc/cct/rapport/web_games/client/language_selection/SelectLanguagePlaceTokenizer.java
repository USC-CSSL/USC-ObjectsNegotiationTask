package edu.usc.cct.rapport.web_games.client.language_selection;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.usc.cct.rapport.web_games.client.WebGamesPlaceTokenizer;

@Prefix(SelectLanguagePlace.placeName)
public class SelectLanguagePlaceTokenizer extends WebGamesPlaceTokenizer implements PlaceTokenizer<SelectLanguagePlace> {

	@Override
	public String getToken(final SelectLanguagePlace place) {
		return super.getToken(place);
	};


	@Override
	public SelectLanguagePlace getPlace(final String token) {
		final SelectLanguagePlace result = placeFactory.createLanguageSelectionPlace(token);
		return result;
	};

};
