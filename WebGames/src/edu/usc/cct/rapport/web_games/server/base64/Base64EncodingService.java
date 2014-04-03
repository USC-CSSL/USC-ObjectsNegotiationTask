package edu.usc.cct.rapport.web_games.server.base64;

import java.io.IOException;
import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.usc.cct.rapport.web_games.client.base64.IBase64EncodingService;

public class Base64EncodingService extends RemoteServiceServlet implements IBase64EncodingService {

	static public final long serialVersionUID = 1L;

	static private final int encodingServiceBitFlags = Base64.ENCODE | Base64.URL_SAFE;

	@Override
	public String encode(final IsSerializable objectToBeBase64Encoded) {
		assert (null != objectToBeBase64Encoded);
		String result;
		try {
			result = Base64.encodeObject((Serializable)objectToBeBase64Encoded, encodingServiceBitFlags);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		};
		return result;
	};

	public String encode2(final Serializable objectToBeBase64Encoded) {
		assert (null != objectToBeBase64Encoded);
		String result;
		try {
			result = Base64.encodeObject((Serializable)objectToBeBase64Encoded, encodingServiceBitFlags);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		};
		return result;
	};
	
};
