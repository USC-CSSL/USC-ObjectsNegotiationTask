package edu.usc.cct.rapport.web_games.client.base64;

import java.io.Serializable;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IBase64DecodingServiceAsync {
	Request decode(final String base64EncodedObject, final boolean stripLanguageFirst, final AsyncCallback<Serializable> callback);
};
