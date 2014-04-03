package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import com.google.gwt.event.shared.GwtEvent;


public class ExperimentConditionsSpecifiedEvent extends GwtEvent<ExperimentConditionsSpecifiedEventHandler> {

    static final public Type<ExperimentConditionsSpecifiedEventHandler> TYPE = new Type<ExperimentConditionsSpecifiedEventHandler>();
	final private ExperimentConditions experimentConditions;


    public ExperimentConditionsSpecifiedEvent(final ExperimentConditions tradingObjectSetEnum) {
        this.experimentConditions = tradingObjectSetEnum;
    };


    @Override
    public Type<ExperimentConditionsSpecifiedEventHandler> getAssociatedType() {
        return TYPE;
    };


    @Override
    protected void dispatch(final ExperimentConditionsSpecifiedEventHandler handler) {
        handler.onExperimentConditionsSpecified(this);
    };


    public ExperimentConditions getExperimentConditions() {
        return experimentConditions;
    };

};
