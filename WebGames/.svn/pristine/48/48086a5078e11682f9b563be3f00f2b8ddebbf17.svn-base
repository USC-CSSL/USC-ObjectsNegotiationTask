package edu.usc.cct.rapport.web_games.client.testing;

import com.google.gwt.event.shared.GwtEvent;


public class TestingCompleteEvent extends GwtEvent<TestingCompleteEventHandler> {

    static final public Type<TestingCompleteEventHandler> TYPE = new Type<TestingCompleteEventHandler>();


    @Override
    public Type<TestingCompleteEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final TestingCompleteEventHandler handler) {
        handler.onTestingCompleteEvent(this);
    };

};
