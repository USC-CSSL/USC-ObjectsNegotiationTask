package edu.usc.cct.rapport.web_games.client;


abstract public class WebGamesAbstractActivity implements IWebGamesActivity {

	@Override
	public String mayStop() {
		return null;
	};

	@Override
	public void onCancel() {
		// There is nothing to do here.
	};

	@Override
	public void onStop() {
		// There is nothing to do here.
	};

};
