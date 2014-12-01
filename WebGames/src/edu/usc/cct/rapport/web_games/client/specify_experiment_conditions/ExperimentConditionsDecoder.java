package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.base64.IBase64DecodingService;
import edu.usc.cct.rapport.web_games.client.base64.IBase64DecodingServiceAsync;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectSetEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.AlgorithmicCounterpartDecisionMakingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionModellingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;


public class ExperimentConditionsDecoder implements AsyncCallback<Serializable> {

	static final private IBase64DecodingServiceAsync decoder = (IBase64DecodingServiceAsync)GWT.create(IBase64DecodingService.class);

	@SuppressWarnings("unused") final private Request decodingRequest;
	final private EventBus eventBus;
	final private String encodedExperimentConditions;
	private ExperimentConditions experimentConditions;


	@Inject
	public ExperimentConditionsDecoder(final EventBus eventBus, @Assisted final String base64StringToBeDecoded, final boolean stripLanguageFirst) {
		this.eventBus = eventBus;
		this.encodedExperimentConditions = base64StringToBeDecoded;
		this.experimentConditions = null;
		
		this.decodingRequest = this.getDecoder().decode(this.encodedExperimentConditions, stripLanguageFirst, this);
	};


	private IBase64DecodingServiceAsync getDecoder() {
		return decoder;
	};


	@Override
	public void onFailure(final Throwable caught) {
		throw new RuntimeException(caught);	
	};


	@Override
	public void onSuccess(final Serializable serializableObject) {


		if (serializableObject instanceof String) {
			//this.experimentConditions = (ExperimentConditions)serializableObject;
			//int placeCounter = 0;
			String decodedstring = (String)serializableObject;
			// split it and assign to experimentConditions
			String [] split = decodedstring.split("\\|");

	
			this.experimentConditions = new ExperimentConditions(

					FacialExpressionStyleEnum.valueOf(split[0]),
					TradingObjectSetEnum.valueOf(split[1]),
					Integer.parseInt(split[2]),
					Integer.parseInt(split[3]),
					Boolean.parseBoolean(split[4]),
					Boolean.parseBoolean(split[5]),
					Boolean.parseBoolean(split[6]),
					Boolean.parseBoolean(split[7]),
					Integer.parseInt(split[8]),
					AgentEnum.valueOf(split[9]),
					AlgorithmicCounterpartDecisionMakingStrategyEnum.valueOf(split[10]),
	    			EmotionModellingStrategyEnum.valueOf(split[11]),
	    			Boolean.parseBoolean(split[13]),
	    			Boolean.parseBoolean(split[14]),
	    			Boolean.parseBoolean(split[15])//,
//	    			Integer.parseInt(split[16])
	    			/*
	    			Integer.parseInt(split[16]),
	    			Integer.parseInt(split[17]),
	    			Integer.parseInt(split[18]),
	    			Integer.parseInt(split[19]),
	    			Integer.parseInt(split[20]),
	    			Integer.parseInt(split[21]),
	    			Integer.parseInt(split[22]),
	    			Integer.parseInt(split[23]),
	    			Integer.parseInt(split[24]),
	    			Integer.parseInt(split[25]),
	    			Integer.parseInt(split[26]),
	    			Integer.parseInt(split[27])
	    			//String.split[28]
	    			//String.valueOf(split[28])*/
					);
			
		} else {
			if (null == serializableObject) {
				throw new IllegalStateException("Unanticipated null object interpreted by ExperimentConditionsDecoder.");
			} else {
				throw new IllegalStateException(serializableObject.toString());
			}
		};
		

		


		emitEvent();
	};


	public String getEncodedExperimentCondition() {
		final String result = this.encodedExperimentConditions;
		return result;
	};



	private boolean emitEvent() {
		final ExperimentConditionsDecodedEvent newEvent = new ExperimentConditionsDecodedEvent(experimentConditions);
		eventBus.fireEvent(newEvent);
		final boolean result = true;
		return result;
	};

};
