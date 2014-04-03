package edu.usc.cct.rapport.web_games.client.instructions;

import com.google.gwt.event.shared.GwtEvent;


public class UserConfirmsInstructionsReadEvent extends GwtEvent<UserConfirmsInstructionsReadEventHandler> {

    static final public Type<UserConfirmsInstructionsReadEventHandler> TYPE = new Type<UserConfirmsInstructionsReadEventHandler>();


    @Override
    public Type<UserConfirmsInstructionsReadEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final UserConfirmsInstructionsReadEventHandler handler) {
        handler.onUserConfirmationThatInstructionsRead(this);
    };

};
