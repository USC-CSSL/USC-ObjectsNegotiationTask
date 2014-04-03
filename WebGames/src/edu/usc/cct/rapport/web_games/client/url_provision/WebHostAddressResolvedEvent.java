package edu.usc.cct.rapport.web_games.client.url_provision;

import com.google.gwt.event.shared.GwtEvent;


public class WebHostAddressResolvedEvent extends GwtEvent<WebHostAddressResolvedEventHandler> {

    static final public Type<WebHostAddressResolvedEventHandler> TYPE = new Type<WebHostAddressResolvedEventHandler>();
    final private String resolvedWebHostAddress;


    public WebHostAddressResolvedEvent(final String resolvedWebHostAddress) {
        this.resolvedWebHostAddress = resolvedWebHostAddress;
    };


    @Override
    public Type<WebHostAddressResolvedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final WebHostAddressResolvedEventHandler handler) {
        handler.onWebHostAddressResolution(this);
    };


    public String getResolvedWebHostAddress() {
        return resolvedWebHostAddress;
    };

};
