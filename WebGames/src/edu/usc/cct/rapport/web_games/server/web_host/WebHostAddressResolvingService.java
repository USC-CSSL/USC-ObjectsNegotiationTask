package edu.usc.cct.rapport.web_games.server.web_host;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.usc.cct.rapport.web_games.client.web_host.IWebHostAddressResolvingService;


@Deprecated
public class WebHostAddressResolvingService extends RemoteServiceServlet implements IWebHostAddressResolvingService {

	static public final long serialVersionUID = 1L;


	@Override
	public String getWebHostAddress() {
		String result;
		try {
			result = InetAddress.getLocalHost().getHostName();
		} catch (final UnknownHostException e) {
			final IllegalStateException e2 = new IllegalStateException(e);
			throw e2;
		};
		return result;
	};

};
