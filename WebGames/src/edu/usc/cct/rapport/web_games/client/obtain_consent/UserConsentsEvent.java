package edu.usc.cct.rapport.web_games.client.obtain_consent;

import com.google.gwt.event.shared.GwtEvent;


public class UserConsentsEvent extends GwtEvent<UserConsentsEventHandler> {

    static final public Type<UserConsentsEventHandler> TYPE = new Type<UserConsentsEventHandler>();


    @Override
    public Type<UserConsentsEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final UserConsentsEventHandler handler) {
        handler.onUserConsenting(this);
    };

};
