package edu.usc.cct.rapport.web_games.server.base64;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.usc.cct.rapport.web_games.client.base64.IBase64DecodingService;

public class Base64DecodingService extends RemoteServiceServlet implements IBase64DecodingService {

	static final public long serialVersionUID = 1L;

	static final private int decodingServiceBitFlags = Base64.DECODE | Base64.URL_SAFE;

	// TODO: Consider using WeakHashMap here.
	// TODO: Cache on the client side as well as (or perhaps instead of) the server side to reduce latency.
	static final private HashMap<String, Serializable> cache = new HashMap<String, Serializable>();


	@Override
	synchronized public Serializable decode(final String base64EncodedObject, final boolean stripLanguageFirst) {

		Serializable result;

		final String actualBase64EncodedObject;
		if (stripLanguageFirst) {
			actualBase64EncodedObject = base64EncodedObject.substring(3);
		} else {
			actualBase64EncodedObject = base64EncodedObject;
		};

		if (cache.containsKey(actualBase64EncodedObject)) {
			result = cache.get(actualBase64EncodedObject);
		} else {			
			try {
				result = (Serializable)Base64.decodeToObject(actualBase64EncodedObject, decodingServiceBitFlags, null);
				cache.put(actualBase64EncodedObject, result);
			} catch (final ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (final IOException e) {
				throw new RuntimeException(e);
			};
		};

		return result;
	};

};
