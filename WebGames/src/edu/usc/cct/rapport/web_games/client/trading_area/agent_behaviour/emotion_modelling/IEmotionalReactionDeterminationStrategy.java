package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;

public interface IEmotionalReactionDeterminationStrategy {

	public FacialExpressionEnum determineEmotion(final int valueOfBestAlternativeToNegotiatedAction, final NegotiationSession negotiationSession);
//	public FacialExpressionEnum determineEmotion(final HashMap<AgentEnum, Integer> valueOfBestAlternativeToNegotiatedAction, final NegotiationSession negotiationSession);

};
