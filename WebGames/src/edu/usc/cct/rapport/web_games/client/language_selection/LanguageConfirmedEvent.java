package edu.usc.cct.rapport.web_games.client.language_selection;

import com.google.gwt.event.shared.GwtEvent;


public class LanguageConfirmedEvent extends GwtEvent<LanguageConfirmedEventHandler> {

    static final public Type<LanguageConfirmedEventHandler> TYPE = new Type<LanguageConfirmedEventHandler>();

    final private String language;


    public LanguageConfirmedEvent(final String selectedLanguage) {
        this.language = selectedLanguage;
    };


    @Override
    public Type<LanguageConfirmedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final LanguageConfirmedEventHandler handler) {
        handler.onLanguageConfirmed(this);
    };


    public String getLanguage() {
        return language;
    };

};
