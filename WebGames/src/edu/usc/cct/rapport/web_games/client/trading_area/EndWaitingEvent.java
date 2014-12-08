package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class EndWaitingEvent extends GwtEvent<EndWaitingEventHandler> {

	static final Type<EndWaitingEventHandler> TYPE = new Type<EndWaitingEventHandler>();


	final private TradingAction tradingAction;


	public EndWaitingEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.endWaiting == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<EndWaitingEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final EndWaitingEventHandler handler) {
		handler.onEndWaiting(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
