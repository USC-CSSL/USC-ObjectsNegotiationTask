package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import com.google.gwt.event.shared.GwtEvent;


public class ExperimentConditionsEncodedEvent extends GwtEvent<ExperimentConditionsEncodedEventHandler> {

    static final public Type<ExperimentConditionsEncodedEventHandler> TYPE = new Type<ExperimentConditionsEncodedEventHandler>();
    final private String encodedExperimentConditions;


    public ExperimentConditionsEncodedEvent(final String encodedExperimentConditions) {
        this.encodedExperimentConditions = encodedExperimentConditions;
    };


    @Override
    public Type<ExperimentConditionsEncodedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final ExperimentConditionsEncodedEventHandler handler) {
        handler.onExperimentConditionsEncoded(this);
    };


    public String getEncodedExperimentConditions() {
        return encodedExperimentConditions;
    };

};
