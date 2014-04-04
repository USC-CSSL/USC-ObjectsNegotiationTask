package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class TradingAreaPanel extends FlowPanel {

	/**
	 * GWT 2.1.0 is throwing an ArrayIndexOutOfBoundsException.
	 * See http://code.google.com/p/gwt-dnd/issues/detail?id=113&colspec=ID%20Type%20Status%20Priority%20Milestone%20Stars%20Summary
	 */
	protected void insert(final Widget child, final Element container, int beforeIndex, boolean domInsert) {
		if ( beforeIndex <= this.getWidgetCount() ) {
			super.insert(child, container, beforeIndex, domInsert);
		} else {
			super.add(child, container);
		};
	};

};
