package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import com.google.gwt.event.shared.GwtEvent;


public class ExperimentConditionsDecodedEvent extends GwtEvent<ExperimentConditionsDecodedEventHandler> {

    static final public Type<ExperimentConditionsDecodedEventHandler> TYPE = new Type<ExperimentConditionsDecodedEventHandler>();
    final private ExperimentConditions experimentConditions;


    public ExperimentConditionsDecodedEvent(final ExperimentConditions experimentConditions) {
        this.experimentConditions = experimentConditions;
    };


    @Override
    public Type<ExperimentConditionsDecodedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final ExperimentConditionsDecodedEventHandler handler) {
        handler.onExperimentConditionsDecoded(this);
    };


    public ExperimentConditions getExperimentConditions() {
        return experimentConditions;
    };

};
