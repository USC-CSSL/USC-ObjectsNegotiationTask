package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ReportSelfEmotionEvent extends GwtEvent<ReportSelfEmotionEventHandler> {

	static final Type<ReportSelfEmotionEventHandler> TYPE = new Type<ReportSelfEmotionEventHandler>();


	final private TradingAction tradingAction;


	public ReportSelfEmotionEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.reportSelfEmotion == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ReportSelfEmotionEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ReportSelfEmotionEventHandler handler) {
		handler.onReportSelfEmotion(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
