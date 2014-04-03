package edu.usc.cct.rapport.web_games.client.instructions;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AbsolutePanel;
//import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.TextArea;
//import com.google.gwt.user.client.ui.ValueBoxBase;
//import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
//import com.google.gwt.user.client.ui.Label;
import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;

public class InstructionsView extends WebGamesView implements IInstructionsView {



	final private SimpleLayoutPanel anchorPanel;
	final private AbsolutePanel viewBasePanel;

	final private InstructionsInternationalizationConstants constants = GWT.create(InstructionsInternationalizationConstants.class);


	@Inject
	public InstructionsView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new AbsolutePanel();
		anchorPanel.add(viewBasePanel);

	
		final RichTextArea textAreaInstructions = new RichTextArea();
		textAreaInstructions.setHTML(constants.textAreaInstructions());
		textAreaInstructions.setSize("600px", "450px");
		viewBasePanel.add(textAreaInstructions, 0, 0);
		final Button buttonUserHasReadInstructions = new Button(constants.buttonUserHasReadInstructions());

		buttonUserHasReadInstructions.setSize("108px", "23px");
		
		buttonUserHasReadInstructions.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				InstructionsView.this.eventBus.fireEvent(new UserConfirmsInstructionsReadEvent());
			};
		});
		viewBasePanel.add(buttonUserHasReadInstructions,10,470);

		viewBasePanel.setVisible(true);
		initWidget(viewBasePanel);
	};


	@Override
	public void add(final Widget w) {
		viewBasePanel.add(w);
	};


	@Override
	public void clear() {
		viewBasePanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = viewBasePanel.iterator();
		return result;
	};


	@Override
	public boolean remove(final Widget w) {
		final boolean result = viewBasePanel.remove(w);
		return result;
	};

};
