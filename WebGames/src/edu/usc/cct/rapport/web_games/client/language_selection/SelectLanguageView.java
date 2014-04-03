package edu.usc.cct.rapport.web_games.client.language_selection;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentPlace;

public class SelectLanguageView extends WebGamesView implements ISelectLanguageView {

	static final private String[] supportedLocales = {"en", "fa", "fr", "tr", "ko"};

//	static final private String largeFontSizeStyleName = "ict-rapport-largeFontSize";

	static final private SafeHtml separatingLineFeed = SafeHtmlUtils.fromSafeConstant("<br/>");

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;

	@SuppressWarnings("unused") final private String encodedExperimentConditions;

//	final private ListBox listBoxAvailableLanguages;
//	final private HashMap<String, Integer> listBoxIndices;


	@Inject
	public SelectLanguageView(final EventBus eventBus, final PlaceController placeController, final String encodedExperimentConditions) {
		super(eventBus, placeController);
		this.encodedExperimentConditions = encodedExperimentConditions;

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();
		anchorPanel.add(viewBasePanel);

//		final SelectLanguageInternationalizationConstants constants = GWT.create(SelectLanguageInternationalizationConstants.class);
//		final Label labelQueryNegotiationSessionPlyCount = new Label(constants.selectLanguagePrompt());
//		labelQueryNegotiationSessionPlyCount.addStyleName(largeFontSizeStyleName);
//		viewBasePanel.add(labelQueryNegotiationSessionPlyCount);
/*
		listBoxAvailableLanguages = new ListBox();
		listBoxIndices = new HashMap<String, Integer>();
		int listBoxIndex = 0;
		for (final String localeName: supportedLocales) {
			final String nativeDisplayName = LocaleInfo.getLocaleNativeDisplayName(localeName);
			listBoxAvailableLanguages.addItem(nativeDisplayName, localeName);
			listBoxIndices.put(localeName, listBoxIndex++);
			listBoxAvailableLanguages.addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(final ChangeEvent event) {
					final String selectedLanguage = listBoxAvailableLanguages.getValue(listBoxAvailableLanguages.getSelectedIndex());
					final LanguageSelectedEvent languageSelectedEvent = new LanguageSelectedEvent(selectedLanguage);
					eventBus.fireEvent(languageSelectedEvent);
				};
			});
		};
		anchorPanel.setVisible(false);
		viewBasePanel.add(listBoxAvailableLanguages);
*/

		for (final String languageAbbreviation: supportedLocales) {
			final Anchor anchor = generateAnchor(languageAbbreviation, encodedExperimentConditions);
			viewBasePanel.add(anchor);
			viewBasePanel.add(new InlineHTML(separatingLineFeed));
		};

		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
/*
		final Button buttonSpecifyLanguage = new Button(constants.proceed());
		buttonSpecifyLanguage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final String selectedLanguage = listBoxAvailableLanguages.getValue(listBoxAvailableLanguages.getSelectedIndex());
				final LanguageConfirmedEvent languageConfirmedEvent = new LanguageConfirmedEvent(selectedLanguage);
				eventBus.fireEvent(languageConfirmedEvent);
			};
		});
		viewBasePanel.add(buttonSpecifyLanguage);
*/

		anchorPanel.setVisible(true);
		initWidget(anchorPanel);
	};

/*
	@Override
	public void focusLanguage(final String language) {
		final Integer listBoxIndex = listBoxIndices.get(language);
		listBoxAvailableLanguages.setSelectedIndex(listBoxIndex);
		anchorPanel.setVisible(true);
	};
**/


	private Anchor generateAnchor(final String languageAbbreviation, final String encodedExperimentConditions) {

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.insert(0, GWT.getHostPageBaseURL());
		stringBuilder.append("WebGames.html?");
		if (!GWT.isProdMode()) {
			stringBuilder.append("gwt.codesvr=127.0.0.1:9997&");
		};
		stringBuilder.append("locale=");
		stringBuilder.append(languageAbbreviation);
		stringBuilder.append('#');

		final String token = this.generateToken(languageAbbreviation, encodedExperimentConditions);
		stringBuilder.append(token);

		final String url = stringBuilder.toString();

		final Anchor result = new Anchor(LocaleInfo.getLocaleNativeDisplayName(languageAbbreviation), url);
		return result;
	};


	private String generateToken(final String languageAbbreviation, final String encodedExperimentConditions) {

		final StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(ObtainConsentPlace.placeName);
		tokenBuilder.append(':');
		tokenBuilder.append(languageAbbreviation);
		tokenBuilder.append(':');
		tokenBuilder.append(encodedExperimentConditions);

		final String result = tokenBuilder.toString();
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
