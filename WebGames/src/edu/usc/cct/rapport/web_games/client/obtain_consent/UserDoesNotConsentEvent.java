package edu.usc.cct.rapport.web_games.client.obtain_consent;

import com.google.gwt.event.shared.GwtEvent;


public class UserDoesNotConsentEvent extends GwtEvent<UserDoesNotConsentEventHandler> {

    static final public Type<UserDoesNotConsentEventHandler> TYPE = new Type<UserDoesNotConsentEventHandler>();


    @Override
    public Type<UserDoesNotConsentEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final UserDoesNotConsentEventHandler handler) {
        handler.onUserNotConsenting(this);
    };

};
