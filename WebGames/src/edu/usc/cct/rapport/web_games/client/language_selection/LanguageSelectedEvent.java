package edu.usc.cct.rapport.web_games.client.language_selection;

import com.google.gwt.event.shared.GwtEvent;


public class LanguageSelectedEvent extends GwtEvent<LanguageSelectedEventHandler> {

    static final public Type<LanguageSelectedEventHandler> TYPE = new Type<LanguageSelectedEventHandler>();

    final private String selectedLanguage;


    public LanguageSelectedEvent(final String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    };


    @Override
    public Type<LanguageSelectedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final LanguageSelectedEventHandler handler) {
        handler.onLanguageSelection(this);
    };


    public String getSelectedLanguage() {
        return selectedLanguage;
    };

};
