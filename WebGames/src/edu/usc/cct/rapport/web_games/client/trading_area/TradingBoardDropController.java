package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class TradingBoardDropController extends SimpleDropController {

	final private TradingBoardWidget tradingBoardWidget;


	public TradingBoardDropController(final TradingBoardWidget tradingBoardWidget, final SimplePanel dropTarget) {
		super(dropTarget);
		this.tradingBoardWidget = tradingBoardWidget;
	};


	@Override
	public void onDrop(final DragContext context) {
		final SimplePanel dropTarget = (SimplePanel)getDropTarget();
		dropTarget.setWidget(context.draggable);
		super.onDrop(context);

		final Map<Image, Pair<AgentEnum, TradingObjectEnum>> sourcesOfDraggedObjects = this.getSourcesOfDraggedObjects(context.selectedWidgets);
		final Pair<AgentEnum, TradingObjectEnum> destinationInfo = tradingBoardWidget.decodeAgentAndTradingObjectFromWidgetId(dropTarget);

		final TradingBoardState tradingBoardState = tradingBoardWidget.getState();
		final int[][] tradingObjectAllocations = tradingBoardState.getTradingObjectAllocationsAsArray();

		for (final Pair<AgentEnum, TradingObjectEnum> sourceInfo: sourcesOfDraggedObjects.values()) {
			final int sourceAgentRowIndex = AgentEnum.getTradingBoardRowIndex(sourceInfo.getFirst());
			final int sourceTradingObjectIndex = tradingBoardState.getIndexByTradingObjectEnum(sourceInfo.getSecond());
			--tradingObjectAllocations[sourceAgentRowIndex][sourceTradingObjectIndex];
			final int destinationAgentRowIndex = AgentEnum.getTradingBoardRowIndex(destinationInfo.getFirst());
			++tradingObjectAllocations[destinationAgentRowIndex][sourceTradingObjectIndex];
		};

		final TradingBoardState newTradingBoardState = new TradingBoardState(tradingBoardState.getTradingObjectSetEnum(), tradingObjectAllocations);
		tradingBoardWidget.dropped = true;
		tradingBoardWidget.setState(newTradingBoardState);
	};


	@Override
	public void onPreviewDrop(final DragContext context) throws VetoDragException {

		// TODO: revisit this to attempt to allow more drops where user intent is clear (e.g., the middle of an inner 2x2 grid).
		// TODO: revisit this class to attempt to stop accidental drops also

		if (false == (tradingBoardWidget.isEnabled())) {
			throw new VetoDragException();
		};

		if (false == (context.draggable instanceof Image)) {
			throw new VetoDragException();
		};

		final SimplePanel dropTarget = (SimplePanel)getDropTarget();
		if (dropTarget.getWidget() != null) {
			throw new VetoDragException();
		};

		super.onPreviewDrop(context);
	};


	public Map<Image, Pair<AgentEnum, TradingObjectEnum>> getSourcesOfDraggedObjects(final List<Widget> selectedWidgets) {

		final HashMap<Image, Pair<AgentEnum, TradingObjectEnum>> result = new HashMap<Image, Pair<AgentEnum, TradingObjectEnum>>();

		for (final Widget widget: selectedWidgets) {
			if (false == widget instanceof Image) {
				throw new IllegalStateException("Non-image widget was successfully dragged, notwithstanding that TradingBoardDropController.onPreviewDrop ought to have prevented this.");
			};

			final Image image = (Image)widget;
			final Pair<AgentEnum, TradingObjectEnum> sourceOfDraggedTradingObject = tradingBoardWidget.decodeAgentAndTradingObjectFromWidgetId(widget);
			result.put(image, sourceOfDraggedTradingObject);
		};

		return result;
	};

};
