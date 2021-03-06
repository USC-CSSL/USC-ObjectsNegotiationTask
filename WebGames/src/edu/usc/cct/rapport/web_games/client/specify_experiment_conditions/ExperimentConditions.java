package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.recording.DoublySerializable;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectSetEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.AlgorithmicCounterpartDecisionMakingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionModellingStrategyEnum;


public class ExperimentConditions implements DoublySerializable {

	static final private long serialVersionUID = 1L;

	private FacialExpressionStyleEnum facialExpressionStyleEnum;
	private TradingObjectSetEnum tradingObjectSetEnum;
	private int counterpartBATNA;
	private int playerBATNA;
	private boolean counterpartDealValueVisible;
	private boolean counterpartPayoffMatrixVisible;
	private boolean counterpartEmotionExpressionVisible;
	private boolean playerEmotionExpressionVisible;
	private int negotiationSessionPlyCount;
	private AgentEnum agentWhoActsLastIfNoAgreementIsReached;
	private AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart;
	private EmotionModellingStrategyEnum emotionalModellingStrategyOfAlgorithmicCounterpart;
	private String language;
	private boolean helpWindowsVisible;
	private boolean playerPayoffMatrixVisible;
	private boolean playerDealValueVisible;
	private int expScenario;
	
	//pre-questions
	private int SVValue;
	private int SVValueFood;
//	private int SVValueMoney;
	private int SVValueWater;
	private int SVValueSanitizer;
/*	private int importanceOfObject;
	private int moralIssueOfObject;

	
	//post-questions
	private int negotationFair;
	private int angeryWithDeal;
	private int otherConsideredYourNeeds;
	private int otherNegotationFair;
	private int otherAngeryWithDeal;*/
		
	// Moral Foundations Questions
	private int MFQ_01;
	private int MFQ_02;
	private int MFQ_03;
	private int MFQ_04;
	private int MFQ_05;
	private int MFQ_06;
	private int MFQ_07;
	private int MFQ_08;
	private int MFQ_09;
	private int MFQ_10;
	private int MFQ_11;
	private int MFQ_12;
	private int MFQ_13;
	private int MFQ_14;
	private int MFQ_15;
	private int MFQ_16;
	private int MFQ_17;
	private int MFQ_18;
	private int MFQ_19;
	private int MFQ_20;
	private int MFQ_21;
	private int MFQ_22;
	private int MFQ_23;
	private int MFQ_24;
	private int MFQ_25;
	private int MFQ_26;
	private int MFQ_27;
	private int MFQ_28;
	private int MFQ_29;
	private int MFQ_30;
	private int MFQ_31;
	private int MFQ_32;
	private int MFQ_filter;
	
	// Value of Expression Questions
	private int VEQ_01;
	private int VEQ_02;
	private int VEQ_03;
	private int VEQ_04;
	private int VEQ_05;
	private int VEQ_06;
	private int VEQ_07;
	private int VEQ_08;
	private int VEQ_09;
	private int VEQ_10;
	private int VEQ_11;
	
	private int ageOfParticipant;
	private int genderOfParticipant;
	private int educationOfParticipant;
	private int religiosityOfParticipant;
	private int ethnicityOfParticipant;
	private String commentOfParticipant;
	private String participantID;	

	

	/** This routine is not intended for client use.  It exists only because the GWT serialization mechanism requires it to. */
	public ExperimentConditions() {
		// There is intentionally no code here.
	};


	//public ExperimentConditions(final FacialExpressionStyleEnum facialExpressionStyleEnum, final TradingObjectSetEnum tradingObjectSetEnum, final int counterpartBATNA, final int playerBATNA, final boolean counterpartDealValueVisible, final boolean counterpartPayoffMatrixVisible, final boolean counterpartEmotionVisible, final int negotiationSessionPlyCount, final AgentEnum agentWhoActsLastIfNoAgreementIsReached, final AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart, final EmotionModellingStrategyEnum emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart, final boolean helpWindowsVisible, final boolean playerPayoffMatrixVisible, final boolean playerDealValueVisible) {
	public ExperimentConditions(final FacialExpressionStyleEnum facialExpressionStyleEnum, final TradingObjectSetEnum tradingObjectSetEnum, final int counterpartBATNA, final int playerBATNA, final boolean counterpartDealValueVisible, final boolean counterpartPayoffMatrixVisible, 
			final boolean counterpartEmotionVisible, final boolean playerEmotionVisible, final int negotiationSessionPlyCount, final AgentEnum agentWhoActsLastIfNoAgreementIsReached, final AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart, 
			final EmotionModellingStrategyEnum emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart, final boolean helpWindowsVisible, final boolean playerPayoffMatrixVisible, final boolean playerDealValueVisible, final int expScenario)
			{
			/*final int SVValue, final int importanceOfObject, final int moralIssueofObject, final int negotiationFair, 
			final int angryWithDeal, final int otherConsideredYourNeeds, final int otherNegotationFair,final int otherAngeryWithDeal,
			final int ageOfParticipant, final int genderOfParticipant, 
			final int educationOfParticipant, final int religiosityOfParticipant, final String commentOfParticipant) {*/

		this.facialExpressionStyleEnum = facialExpressionStyleEnum;
		this.tradingObjectSetEnum = tradingObjectSetEnum;
		this.counterpartBATNA = counterpartBATNA;
		this.playerBATNA = playerBATNA;
		this.counterpartDealValueVisible = counterpartDealValueVisible;
		this.counterpartPayoffMatrixVisible = counterpartPayoffMatrixVisible;
		this.counterpartEmotionExpressionVisible = counterpartEmotionVisible;
		this.playerEmotionExpressionVisible = playerEmotionVisible;
		assert(0 < negotiationSessionPlyCount);
		this.negotiationSessionPlyCount = negotiationSessionPlyCount;
		this.agentWhoActsLastIfNoAgreementIsReached = agentWhoActsLastIfNoAgreementIsReached;
		this.decisionMakingStrategyOfAlgorithmicCounterpart = decisionMakingStrategyOfAlgorithmicCounterpart;
		this.emotionalModellingStrategyOfAlgorithmicCounterpart = emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart;
		this.language = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		this.helpWindowsVisible = helpWindowsVisible;
		this.playerPayoffMatrixVisible = playerPayoffMatrixVisible;
		this.playerDealValueVisible= playerDealValueVisible;
		this.expScenario=expScenario;
		
		
		this.SVValue=0;
		this.SVValueFood=0;
		this.SVValueWater=0;
//		this.SVValueMoney=0;
		this.SVValueSanitizer=0;
/*		this.importanceOfObject=0;
		this.moralIssueOfObject=0;
		this.negotationFair=0;
		this.angeryWithDeal=0;
		this.otherConsideredYourNeeds=0;
		this.otherNegotationFair=0;
		this.otherAngeryWithDeal=0;*/
		this.ageOfParticipant=0;
		this.genderOfParticipant=0;
		this.educationOfParticipant=0;
		this.religiosityOfParticipant=0;
		this.ethnicityOfParticipant=0;
		this.commentOfParticipant= "";
		this.participantID="0";
				
		this.MFQ_01=0;
		this.MFQ_02=0;
		this.MFQ_03=0;
		this.MFQ_04=0;
		this.MFQ_05=0;
		this.MFQ_06=0;
		this.MFQ_07=0;
		this.MFQ_08=0;
		this.MFQ_09=0;
		this.MFQ_10=0;
		this.MFQ_11=0;
		this.MFQ_12=0;
		this.MFQ_13=0;
		this.MFQ_14=0;
		this.MFQ_15=0;
		this.MFQ_16=0;
		this.MFQ_17=0;
		this.MFQ_18=0;
		this.MFQ_19=0;
		this.MFQ_20=0;
		this.MFQ_21=0;
		this.MFQ_22=0;
		this.MFQ_23=0;
		this.MFQ_24=0;
		this.MFQ_25=0;
		this.MFQ_26=0;
		this.MFQ_27=0;
		this.MFQ_28=0;
		this.MFQ_29=0;
		this.MFQ_30=0;
		this.MFQ_31=0;
		this.MFQ_32=0;
		this.MFQ_filter=0;
		
		this.VEQ_01=0;
		this.VEQ_02=0;
		this.VEQ_03=0;
		this.VEQ_04=0;
		this.VEQ_05=0;
		this.VEQ_06=0;
		this.VEQ_07=0;
		this.VEQ_08=0;
		this.VEQ_09=0;
		this.VEQ_10=0;
		this.VEQ_11=0;
	};


	public ArrayList<String> getObjectFieldHeaders() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		
		result.add("facialExpressionStyleEnum");
		result.add("tradingObjectSetEnum");
		result.add("counterpartBATNA");
		result.add("playerBATNA");
		result.add("counterpartDealValueVisible");
		result.add("counterpartPayoffMatrixVisible");
		result.add("counterpartEmotionExpressionVisible");
		result.add("playerEmotionExpressionVisible");
		result.add("negotiationSessionPlyCount");
		result.add("agentWhoActsLastIfNoAgreementIsReached");
		result.add("decisionMakingStrategyOfAlgorithmicCounterpart");
		result.add("emotionalModellingStrategyOfAlgorithmicCounterpart");
		result.add("language");
		result.add("helpWindowsVisible");
		result.add("playerPayoffMatrixVisible");
		result.add("playerDealValueVisible");
		result.add("expScenario");
		
		result.add("SVValue");
		result.add("SVValueFood");
		result.add("SVValueWater");
//		result.add("SVValueMoney");
		result.add("SVValueSanitizer");
		
/*		result.add("importanceOfObject");
		result.add("moralIssueOfObject");
		
		result.add("negotationFair");
		result.add("angeryWithDeal");
		result.add("otherConsideredYourNeeds");	
		result.add("otherNegotationFair");
		result.add("otherAngeryWithDeal");*/
		result.add("ageOfParticipant");
		result.add("genderOfParticipant");
		result.add("educationOfParticipant");
		result.add("religiosityOfParticipant");
		result.add("ethnicityOfParticipant");
		result.add("commentOfParticipant");
		result.add("participantID");
				
		result.add("MFQ_01");
		result.add("MFQ_02");
		result.add("MFQ_03");
		result.add("MFQ_04");
		result.add("MFQ_05");
		result.add("MFQ_06");
		result.add("MFQ_07");
		result.add("MFQ_08");
		result.add("MFQ_09");
		result.add("MFQ_10");
		result.add("MFQ_11");
		result.add("MFQ_12");
		result.add("MFQ_13");
		result.add("MFQ_14");
		result.add("MFQ_15");
		result.add("MFQ_16");
		result.add("MFQ_17");
		result.add("MFQ_18");
		result.add("MFQ_19");
		result.add("MFQ_20");
		result.add("MFQ_21");
		result.add("MFQ_22");
		result.add("MFQ_23");
		result.add("MFQ_24");
		result.add("MFQ_25");
		result.add("MFQ_26");
		result.add("MFQ_27");
		result.add("MFQ_28");
		result.add("MFQ_29");
		result.add("MFQ_30");
		result.add("MFQ_31");
		result.add("MFQ_32");
		result.add("MFQ_filter");
		
		result.add("VEQ_01");
		result.add("VEQ_02");
		result.add("VEQ_03");
		result.add("VEQ_04");
		result.add("VEQ_05");
		result.add("VEQ_06");
		result.add("VEQ_07");
		result.add("VEQ_08");
		result.add("VEQ_09");
		result.add("VEQ_10");
		result.add("VEQ_11");
		
		return result;
	};


	public ArrayList<String> getObjectFieldData() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		
		result.add(this.facialExpressionStyleEnum.name());
		result.add(this.tradingObjectSetEnum.name());
		result.add(Integer.toString(this.counterpartBATNA));
		result.add(Integer.toString(this.playerBATNA));
		result.add(Boolean.toString(this.counterpartDealValueVisible));
		result.add(Boolean.toString(this.counterpartPayoffMatrixVisible));
		result.add(Boolean.toString(this.counterpartEmotionExpressionVisible));
		result.add(Boolean.toString(this.playerEmotionExpressionVisible));
		result.add(Integer.toString(this.negotiationSessionPlyCount));
		result.add(this.agentWhoActsLastIfNoAgreementIsReached.name());
		result.add(this.decisionMakingStrategyOfAlgorithmicCounterpart.name());
		result.add(this.emotionalModellingStrategyOfAlgorithmicCounterpart.name());
		result.add(this.language);
		result.add(Boolean.toString(this.helpWindowsVisible));
		result.add(Boolean.toString(this.playerPayoffMatrixVisible));
		result.add(Boolean.toString(this.playerDealValueVisible));
		result.add(Integer.toString(this.expScenario));
		
		
		result.add(Integer.toString(this.SVValue));
		result.add(Integer.toString(this.SVValueWater));
		result.add(Integer.toString(this.SVValueFood));
//		result.add(Integer.toString(this.SVValueMoney));
		result.add(Integer.toString(this.SVValueSanitizer));
/*		result.add(Integer.toString(this.importanceOfObject));
		result.add(Integer.toString(this.moralIssueOfObject));
		
		result.add(Integer.toString(this.negotationFair));
		result.add(Integer.toString(this.angeryWithDeal));
		result.add(Integer.toString(this.otherConsideredYourNeeds));
		result.add(Integer.toString(this.otherNegotationFair));
		result.add(Integer.toString(this.otherAngeryWithDeal));*/
		result.add(Integer.toString(this.ageOfParticipant));
		result.add(Integer.toString(this.genderOfParticipant));
		result.add(Integer.toString(this.educationOfParticipant));
		result.add(Integer.toString(this.religiosityOfParticipant));
		result.add(Integer.toString(this.ethnicityOfParticipant));
		result.add(this.commentOfParticipant);
		result.add(this.participantID);
		
		result.add(Integer.toString(this.MFQ_01));
		result.add(Integer.toString(this.MFQ_02));
		result.add(Integer.toString(this.MFQ_03));
		result.add(Integer.toString(this.MFQ_04));
		result.add(Integer.toString(this.MFQ_05));
		result.add(Integer.toString(this.MFQ_06));
		result.add(Integer.toString(this.MFQ_07));
		result.add(Integer.toString(this.MFQ_08));
		result.add(Integer.toString(this.MFQ_09));
		result.add(Integer.toString(this.MFQ_10));
		result.add(Integer.toString(this.MFQ_11));
		result.add(Integer.toString(this.MFQ_12));
		result.add(Integer.toString(this.MFQ_13));
		result.add(Integer.toString(this.MFQ_14));
		result.add(Integer.toString(this.MFQ_15));
		result.add(Integer.toString(this.MFQ_16));
		result.add(Integer.toString(this.MFQ_17));
		result.add(Integer.toString(this.MFQ_18));
		result.add(Integer.toString(this.MFQ_19));
		result.add(Integer.toString(this.MFQ_20));
		result.add(Integer.toString(this.MFQ_21));
		result.add(Integer.toString(this.MFQ_22));
		result.add(Integer.toString(this.MFQ_23));
		result.add(Integer.toString(this.MFQ_24));
		result.add(Integer.toString(this.MFQ_25));
		result.add(Integer.toString(this.MFQ_26));
		result.add(Integer.toString(this.MFQ_27));
		result.add(Integer.toString(this.MFQ_28));
		result.add(Integer.toString(this.MFQ_29));		
		result.add(Integer.toString(this.MFQ_30));
		result.add(Integer.toString(this.MFQ_31));
		result.add(Integer.toString(this.MFQ_32));
		result.add(Integer.toString(this.MFQ_filter));
		
		result.add(Integer.toString(this.VEQ_01));
		result.add(Integer.toString(this.VEQ_02));
		result.add(Integer.toString(this.VEQ_03));
		result.add(Integer.toString(this.VEQ_04));
		result.add(Integer.toString(this.VEQ_05));
		result.add(Integer.toString(this.VEQ_06));
		result.add(Integer.toString(this.VEQ_07));
		result.add(Integer.toString(this.VEQ_08));
		result.add(Integer.toString(this.VEQ_09));
		result.add(Integer.toString(this.VEQ_10));
		result.add(Integer.toString(this.VEQ_11));

		return result;
	};


	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("{");
		final Iterator<String> iterator = getObjectFieldData().iterator();
		assert (iterator.hasNext());

		builder.append(iterator.next());
		while (iterator.hasNext()) {
			builder.append(", ");
			builder.append(iterator.next());
		};
		builder.append("}");

		final String result = builder.toString();
		return result;
	};


	public String to2DFormattedString() {

		final StringBuilder builder = new StringBuilder();

		final Iterator<String> headerIterator = getObjectFieldHeaders().iterator();
		final Iterator<String> dataIterator = getObjectFieldData().iterator();
		assert(headerIterator.hasNext());
		assert(dataIterator.hasNext());

		builder.append(headerIterator.next()).append(" = ").append(dataIterator.next()).append('\n');
		while (headerIterator.hasNext()) {
			assert (dataIterator.hasNext());
			builder.append(headerIterator.next()).append(" = ").append(dataIterator.next()).append('\n');
		};
		assert(false == dataIterator.hasNext());

		final String result = builder.toString();
		return result;
	};


	public FacialExpressionStyleEnum getFacialExpressionStyleEnum() {
		final FacialExpressionStyleEnum result = FacialExpressionStyleEnum.valueOf(this.facialExpressionStyleEnum.name());
		return result;
	};


	void setFacialExpressionStyleEnum(final FacialExpressionStyleEnum facialExpressionStyleEnum) {
		this.facialExpressionStyleEnum = FacialExpressionStyleEnum.valueOf(facialExpressionStyleEnum.name());
	};


	public TradingObjectSetEnum getTradingObjectSetEnum() {
		final TradingObjectSetEnum result = TradingObjectSetEnum.valueOf(this.tradingObjectSetEnum.name());
		return result;
	};


	void setTradingObjectSetEnum(final TradingObjectSetEnum tradingObjectSetEnum) {
		this.tradingObjectSetEnum = TradingObjectSetEnum.valueOf(tradingObjectSetEnum.name());
	};


	public HashMap<AgentEnum, Integer> getBATNAValues() {
		final HashMap<AgentEnum, Integer> result = new HashMap<AgentEnum, Integer>();
		result.put(AgentEnum.player, getPlayerBATNA());
		result.put(AgentEnum.counterpart, getCounterpartBATNA());
		return result;
	};


	public int getCounterpartBATNA() {
		return this.counterpartBATNA;
	};


	void setCounterpartBATNA(final int counterpartBATNA) {
		this.counterpartBATNA = counterpartBATNA;
	};


	public int getPlayerBATNA() {
		return this.playerBATNA;
	};


	void setPlayerBATNA(final int playerBATNA) {
		this.playerBATNA = playerBATNA;
	};


	public boolean getCounterpartDealValueVisible() {
		return this.counterpartDealValueVisible;
	};


	void setCounterpartDealValueVisible(final boolean visible) {
		this.counterpartDealValueVisible = visible;
	};


	public boolean getCounterpartPayoffMatrixVisible() {
		return this.counterpartPayoffMatrixVisible;
	};


	void setCounterpartPayoffMatrixVisible(final boolean visible) {
		this.counterpartPayoffMatrixVisible = visible;
	};


	public boolean getCounterpartEmotionExpressionVisible() {
		return this.counterpartEmotionExpressionVisible;
	};

	void setCounterpartEmotionVisible(final boolean visible) {
		this.counterpartEmotionExpressionVisible = visible;
	};
	
	
	public boolean getPlayerEmotionExpressionVisible() {
		return this.playerEmotionExpressionVisible;
	};

	void setPlayerEmotionVisible(final boolean visible) {
		this.playerEmotionExpressionVisible = visible;
	};
	
	
	public void setHelpWindowsVisible(boolean helpWindowsVisible) {
		this.helpWindowsVisible = helpWindowsVisible;
	}


	public boolean getHelpWindowsVisible() {
		return this.helpWindowsVisible;
	};
	
	public void setPlayerPayoffMatrixVisible(boolean playerPayoffMatrixVisible) {
		this.playerPayoffMatrixVisible = playerPayoffMatrixVisible;
	}


	public boolean getPlayerPayoffMatrixVisible() {
		return this.playerPayoffMatrixVisible;
	};
	
	public void setPlayerDealValueVisible(boolean playerDealValueVisible) {
		this.playerDealValueVisible = playerDealValueVisible;
	}


	public boolean getPlayerDealValueVisible() {
		return this.playerDealValueVisible;
	};
	
	
	

	public int getNegotiationSessionPlyCount() {
		return this.negotiationSessionPlyCount;
	};


	void setNegotiationSessionPlyCount(final int negotiationSessionPlyCount) {
		this.negotiationSessionPlyCount = negotiationSessionPlyCount;
	};


	public AgentEnum getAgentWhoActsLastIfNoAgreementIsReached() {
		final AgentEnum result = AgentEnum.valueOf(this.agentWhoActsLastIfNoAgreementIsReached.name());
		return result;
	};


	void setAgentWhoActsLastIfNoAgreementIsReached(final AgentEnum agentWhoActsLastIfNoAgreementIsReached) {
		this.agentWhoActsLastIfNoAgreementIsReached = AgentEnum.valueOf(agentWhoActsLastIfNoAgreementIsReached.name());
	};


	public AlgorithmicCounterpartDecisionMakingStrategyEnum getDecisionMakingStrategyOfAlgorithmicCounterpart() {
		final AlgorithmicCounterpartDecisionMakingStrategyEnum result = AlgorithmicCounterpartDecisionMakingStrategyEnum.valueOf(decisionMakingStrategyOfAlgorithmicCounterpart.name());
		return result;
	};


	public void setDecisionMakingStrategyOfAlgorithmicCounterpart(final AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart) {
		this.decisionMakingStrategyOfAlgorithmicCounterpart = AlgorithmicCounterpartDecisionMakingStrategyEnum.valueOf(decisionMakingStrategyOfAlgorithmicCounterpart.name());
	};


	public EmotionModellingStrategyEnum getEmotionalModellingPolicyEnum() {
		final EmotionModellingStrategyEnum result = EmotionModellingStrategyEnum.valueOf(emotionalModellingStrategyOfAlgorithmicCounterpart.name());
		return result;
	};


	public void setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(final EmotionModellingStrategyEnum emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart) {
		this.emotionalModellingStrategyOfAlgorithmicCounterpart = EmotionModellingStrategyEnum.valueOf(emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart.name());
	};

	public void setLanguage(final String language) {
		this.language = language;
	};


	public String getLanguage() {
		return this.language;
	}

	
	public int getExpScenario() {
		return this.expScenario;
	};


	public void setExpScenario(final int expScenario) {
		this.expScenario = expScenario;
	}
	
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getParticipantID() {
		return this.participantID;
	};
	
	
	public void setSVValue(int SVValue) {
		this.SVValue = SVValue;
	}

	public int getSVValue() {
		return this.SVValue;
	};

	public void setSVValueFood(int SVValueFood) {
		this.SVValueFood = SVValueFood;
	}

	public int getSVValueFood() {
		return this.SVValueFood;
	};
	
/*	public void setSVValueMoney (int SVValueMoney) {
		this.SVValueMoney = SVValueMoney;
	}

	public int getSVValueMoney() {
		return this.SVValueMoney;
	};*/
	
	public void setSVValueSanitizer (int SVValueSanitizer) {
		this.SVValueSanitizer = SVValueSanitizer;
	}

	public int getSVValueSanitizer() {
		return this.SVValueSanitizer;
	};
	
	public void setSVValueWater(int SVValueWater) {
		this.SVValueWater = SVValueWater;
	}

	public int getSVValueWater() {
		return this.SVValueWater;
	};
	
/*	public void setNegotationFair(int negotationFair) {
		this.negotationFair = negotationFair;
	}

	public int getNegotationFair() {
		return this.negotationFair;
	};
	

	
	public void setAngeryWithDeal(int angeryWithDeal) {
		this.angeryWithDeal = angeryWithDeal;
	}

	public int getAngeryWithDeal() {
		return this.angeryWithDeal;
	};
	
	
	
	public void setOtherConsideredYourNeeds(int otherConsideredYourNeeds) {
		this.otherConsideredYourNeeds = otherConsideredYourNeeds;
	}

	public int getOtherConsideredYourNeeds() {
		return this.otherConsideredYourNeeds;
	};

	
	
	public void setOtherNegotationFair(int otherNegotationFair) {
		this.otherNegotationFair = otherNegotationFair;
	}

	public int getOtherNegotationFair() {
		return this.otherNegotationFair;
	};

	
	
	public void setOtherAngeryWithDeal(int otherAngeryWithDeal) {
		this.otherAngeryWithDeal = otherAngeryWithDeal;
	}

	public int getOtherAngeryWithDeal() {
		return this.otherAngeryWithDeal;
	};*/

	
	
	public void setAgeOfParticipant(int ageOfParticipant) {
		this.ageOfParticipant = ageOfParticipant;
	}

	public int getAgeOfParticipant() {
		return this.ageOfParticipant;
	};

	
	
	public void setGenderOfParticipant(int genderOfParticipant) {
		this.genderOfParticipant = genderOfParticipant;
	}

	public int getGenderOfParticipant() {
		return this.genderOfParticipant;
	};

	
	
	public void setEducationOfParticipant(int educationOfParticipant) {
		this.educationOfParticipant = educationOfParticipant;
	}

	public int getEducationOfParticipant() {
		return this.educationOfParticipant;
	};

	
	
	public void setReligiosityOfParticipant(int religiosityOfParticipant) {
		this.religiosityOfParticipant = religiosityOfParticipant;
	}

	public int getReligiosityOfParticipant() {
		return this.religiosityOfParticipant;
	};

	public void setEthnicityOfParticipant(int ethnicityOfParticipant) {
		this.ethnicityOfParticipant = ethnicityOfParticipant;
	}

	public int getEthnicityOfParticipant() {
		return this.ethnicityOfParticipant;
	};	
	
	public void setCommentOfParticipant(String commentOfParticipant) {
		this.commentOfParticipant = commentOfParticipant;
	}

	public String getCommentOfParticipant() {
		return this.commentOfParticipant;
	};
	
	
	
/*	public void setImportanceOfObject(int importanceOfObject) {
		this.importanceOfObject = importanceOfObject;
	}


	public int getImportanceOfObject() {
		return this.importanceOfObject;
	};
	
	public void setMoralIssueOfObject(int moralIssueOfObject) {
		this.moralIssueOfObject = moralIssueOfObject;
	}


	public int getMoralIssueOfObject() {
		return this.moralIssueOfObject;
	};*/
	
	
	public void setVEQ_01(int VEQ_01) {
		this.VEQ_01 = VEQ_01;
	}
	
	public void setVEQ_02(int VEQ_02) {
		this.VEQ_02 = VEQ_02;
	}

	public void setVEQ_03(int VEQ_03) {
		this.VEQ_03 = VEQ_03;
	}

	public void setVEQ_04(int VEQ_04) {
		this.VEQ_04 = VEQ_04;
	}

	public void setVEQ_05(int VEQ_05) {
		this.VEQ_05 = VEQ_05;
	}

	public void setVEQ_06(int VEQ_06) {
		this.VEQ_06 = VEQ_06;
	}

	public void setVEQ_07(int VEQ_07) {
		this.VEQ_07 = VEQ_07;
	}

	public void setVEQ_08(int VEQ_08) {
		this.VEQ_08 = VEQ_08;
	}

	public void setVEQ_09(int VEQ_09) {
		this.VEQ_09 = VEQ_09;
	}

	public void setVEQ_10(int VEQ_10) {
		this.VEQ_10 = VEQ_10;
	}

	public void setVEQ_11(int VEQ_11) {
		this.VEQ_11 = VEQ_11;
	}
	
	public void setMFQ_01(int MFQ_01) {
		this.MFQ_01 = MFQ_01;
	}
	
	public void setMFQ_02(int MFQ_02) {
		this.MFQ_02 = MFQ_02;
	}

	public void setMFQ_03(int MFQ_03) {
		this.MFQ_03 = MFQ_03;
	}

	public void setMFQ_04(int MFQ_04) {
		this.MFQ_04 = MFQ_04;
	}

	public void setMFQ_05(int MFQ_05) {
		this.MFQ_05 = MFQ_05;
	}

	public void setMFQ_06(int MFQ_06) {
		this.MFQ_06 = MFQ_06;
	}

	public void setMFQ_07(int MFQ_07) {
		this.MFQ_07 = MFQ_07;
	}

	public void setMFQ_08(int MFQ_08) {
		this.MFQ_08 = MFQ_08;
	}

	public void setMFQ_09(int MFQ_09) {
		this.MFQ_09 = MFQ_09;
	}

	public void setMFQ_10(int MFQ_10) {
		this.MFQ_10 = MFQ_10;
	}

	public void setMFQ_11(int MFQ_11) {
		this.MFQ_11 = MFQ_11;
	}
	
	public void setMFQ_12(int MFQ_12) {
		this.MFQ_12 = MFQ_12;
	}

	public void setMFQ_13(int MFQ_13) {
		this.MFQ_13 = MFQ_13;
	}

	public void setMFQ_14(int MFQ_14) {
		this.MFQ_14 = MFQ_14;
	}

	public void setMFQ_15(int MFQ_15) {
		this.MFQ_15 = MFQ_15;
	}

	public void setMFQ_16(int MFQ_16) {
		this.MFQ_16 = MFQ_16;
	}

	public void setMFQ_17(int MFQ_17) {
		this.MFQ_17 = MFQ_17;
	}

	public void setMFQ_18(int MFQ_18) {
		this.MFQ_18 = MFQ_18;
	}

	public void setMFQ_19(int MFQ_19) {
		this.MFQ_19 = MFQ_19;
	}

	public void setMFQ_20(int MFQ_20) {
		this.MFQ_20 = MFQ_20;
	}

	public void setMFQ_21(int MFQ_21) {
		this.MFQ_21 = MFQ_21;
	}
	
	public void setMFQ_22(int MFQ_22) {
		this.MFQ_22 = MFQ_22;
	}

	public void setMFQ_23(int MFQ_23) {
		this.MFQ_23 = MFQ_23;
	}

	public void setMFQ_24(int MFQ_24) {
		this.MFQ_24 = MFQ_24;
	}

	public void setMFQ_25(int MFQ_25) {
		this.MFQ_25 = MFQ_25;
	}

	public void setMFQ_26(int MFQ_26) {
		this.MFQ_26 = MFQ_26;
	}

	public void setMFQ_filter(int MFQ_filter) {
		this.MFQ_filter = MFQ_filter;
	}

	public void setMFQ_27(int MFQ_27) {
		this.MFQ_27 = MFQ_27;
	}

	public void setMFQ_28(int MFQ_28) {
		this.MFQ_28 = MFQ_28;
	}

	public void setMFQ_29(int MFQ_29) {
		this.MFQ_29 = MFQ_29;
	}
	public void setMFQ_30(int MFQ_30) {
		this.MFQ_30 = MFQ_30;
	}

	public void setMFQ_31(int MFQ_31) {
		this.MFQ_31 = MFQ_31;
	}
	
	public void setMFQ_32(int MFQ_32) {
		this.MFQ_32 = MFQ_32;
	}

};
