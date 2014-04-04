package edu.usc.cct.rapport.web_games.client.factory;

import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;

abstract public class WebGamesCodeSplittingAsyncCallback implements RunAsyncCallback {

	static final private String errorMessage = "Code loading failed -- this is a fatal error.";

	@Override
	public void onFailure(final Throwable e) {
		Window.alert(errorMessage);
		throw new RuntimeException(e);
	};

};
