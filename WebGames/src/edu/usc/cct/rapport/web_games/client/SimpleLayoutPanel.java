package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimpleLayoutPanel extends LayoutPanel implements AcceptsOneWidget {

	private IsWidget isWidget;


	public SimpleLayoutPanel() {
		this.isWidget = null;
	};


	@Override
	public void setWidget(final IsWidget newWidgetOrNull) {
		if (null != this.isWidget) {
			super.remove(this.isWidget);
		};
		this.isWidget = newWidgetOrNull;
		final Widget widget = Widget.asWidgetOrNull(this.isWidget);
		if (null != widget) {
			// Hack: remove the position: relative style, which is causing it not to appear.
//			widget.getElement().removeAttribute("style");
			super.add(this.isWidget);
		};
	};

/*
	// Override to attempt to block misuse of SimpleLayoutPanel as anything other than the base panel for an ActivityManager.
	@Override
	public void add(final Widget w) {
		setWidget(w);
	};


	// Override to attempt to block misuse of SimpleLayoutPanel as anything other than the base panel for an ActivityManager.
	@Override
	public void insert(final Widget w, final int beforeIndex) {
		setWidget(w);
	};
*/

};
