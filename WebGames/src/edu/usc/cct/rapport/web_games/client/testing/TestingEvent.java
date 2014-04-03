package edu.usc.cct.rapport.web_games.client.testing;

import com.google.gwt.event.shared.GwtEvent;


public class TestingEvent extends GwtEvent<TestingEventHandler> {

    static final public Type<TestingEventHandler> TYPE = new Type<TestingEventHandler>();


    @Override
    public Type<TestingEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final TestingEventHandler handler) {
        handler.onTestingEvent(this);
    };

};
