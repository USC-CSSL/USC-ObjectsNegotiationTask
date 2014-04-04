package edu.usc.cct.rapport.web_games.client.url_provision;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.usc.cct.rapport.web_games.client.web_host.IWebHostAddressResolvingService;
import edu.usc.cct.rapport.web_games.client.web_host.IWebHostAddressResolvingServiceAsync;

public class WebHostAddressResolver implements AsyncCallback<String> {

	static final private IWebHostAddressResolvingServiceAsync resolver = (IWebHostAddressResolvingServiceAsync)GWT.create(IWebHostAddressResolvingService.class);

	@SuppressWarnings("unused") final private Request resolutionRequest;
	private String resolvedWebHostAddress;
	private EventBus eventBus;


	public WebHostAddressResolver() {
		this.eventBus = null;
		resolutionRequest = resolver.getWebHostAddress(this);
	};


	@Override
	public void onFailure(final Throwable caught) {
		throw new RuntimeException(caught);		
	};


	@Override
	public void onSuccess(final String resolvedWebHostAddress) {
		if (null == resolvedWebHostAddress) {
			throw new IllegalStateException("Null web host address.");
		} else {
			this.resolvedWebHostAddress = resolvedWebHostAddress;
		};
		emitEventIfPossible();
	};


	public void specifyEventBusToBroadcastResultUpon(final EventBus eventBus) {
		this.eventBus = eventBus;
		emitEventIfPossible();
	};


	private boolean emitEventIfPossible() {

		boolean result = false;

		if ((null != eventBus) && (null != resolvedWebHostAddress)) {
			final WebHostAddressResolvedEvent newEvent = new WebHostAddressResolvedEvent(resolvedWebHostAddress);
			eventBus.fireEvent(newEvent);
			result = true;
		};

		return result;
	};

};
