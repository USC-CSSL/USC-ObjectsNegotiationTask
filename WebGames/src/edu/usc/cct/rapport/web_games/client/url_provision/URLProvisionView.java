package edu.usc.cct.rapport.web_games.client.url_provision;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.language_selection.SelectLanguagePlace;

public class URLProvisionView extends WebGamesView implements IURLProvisionView {

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;

	final private String encodedExperimentConditions;


	@Inject
	public URLProvisionView(final EventBus eventBus, final PlaceController placeController, final String encodedExperimentConditions) {
		super(eventBus, placeController);
		this.encodedExperimentConditions = encodedExperimentConditions;

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();
		anchorPanel.add(viewBasePanel);

		final Anchor anchor = this.generateAnchor();
		viewBasePanel.add(anchor);

		anchorPanel.setVisible(true);
		initWidget(anchorPanel);
	};


	private String generateToken() {

		final StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(SelectLanguagePlace.placeName);
		tokenBuilder.append(':');
		tokenBuilder.append(encodedExperimentConditions);

		final String result = tokenBuilder.toString();
		return result;
	};


	private Anchor generateAnchor() {

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.insert(0, GWT.getHostPageBaseURL());
		if (!GWT.isProdMode()) {
			stringBuilder.append("WebGames.html?gwt.codesvr=127.0.0.1:9997");
		};
		stringBuilder.append('#');

		final String token = this.generateToken();
		stringBuilder.append(token);

		final String url = stringBuilder.toString();

		final Anchor result = new Anchor(url, url);
		return result;
	};


	@Override
	public void add(final Widget w) {
		anchorPanel.add(w);
	};


	@Override
	public void clear() {
		anchorPanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = anchorPanel.iterator();
		return result;
	};


	@Override
	public boolean remove(final Widget w) {
		final boolean result = anchorPanel.remove(w);
		return result;
	};

};
