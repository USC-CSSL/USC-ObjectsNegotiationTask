package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class CheckAgentsReportedEmotionEvent extends GwtEvent<CheckAgentsReportedEmotionEventHandler> {

	static final Type<CheckAgentsReportedEmotionEventHandler> TYPE = new Type<CheckAgentsReportedEmotionEventHandler>();


	final private TradingAction tradingAction;


	public CheckAgentsReportedEmotionEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.checkAgentsReportedEmotion == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<CheckAgentsReportedEmotionEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final CheckAgentsReportedEmotionEventHandler handler) {
		handler.onCheckAgentsReportedEmotion(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
