package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.usc.cct.rapport.web_games.client.support.immutable.ImmutableList;

public class NegotiationSession implements Collection<TradingAction> {

	final private TradingObjectSetEnum tradingObjectSetEnum;
	final private int maximumPly;
	final private AgentEnum agentWhoActsLastIfNoAgreementIsReached;
	final private ArrayList<TradingAction> history;
	final private ArrayList<TradingExpression> expressionHistory;


	public NegotiationSession(final TradingObjectSetEnum tradingObjectSetEnum, final int maximumPly, final AgentEnum agentWhoActsLastIfNoAgreementIsReached) {
		this.tradingObjectSetEnum = tradingObjectSetEnum;
		this.history = new ArrayList<TradingAction>();
		this.expressionHistory = new ArrayList<TradingExpression>();
		this.maximumPly = maximumPly;
		this.agentWhoActsLastIfNoAgreementIsReached = agentWhoActsLastIfNoAgreementIsReached;
	};


	public NegotiationSession(final NegotiationSession other, final int omitLastNProposalsFromCopiedHistory) {
		this.tradingObjectSetEnum = other.tradingObjectSetEnum;
		this.maximumPly = other.maximumPly;
		this.agentWhoActsLastIfNoAgreementIsReached = other.agentWhoActsLastIfNoAgreementIsReached;
		this.history = new ArrayList<TradingAction>();
		TradingAction lastRetainedTradingAction = null;
		for (int tradingActionsCopied = 0; tradingActionsCopied != other.history.size() - omitLastNProposalsFromCopiedHistory; ++tradingActionsCopied) {
			lastRetainedTradingAction = other.get(tradingActionsCopied);
			this.history.add(lastRetainedTradingAction);
		};
		this.expressionHistory = new ArrayList<TradingExpression>();
		if (null != lastRetainedTradingAction) {
			for (final TradingExpression tradingExpression: other.expressionHistory) {
				if (tradingExpression.getTimestamp() > lastRetainedTradingAction.getTimestamp()) break;
				this.expressionHistory.add(tradingExpression);
			};
		};
	};


	public ArrayList<String> getObjectScalarFieldHeaders() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		result.add("tradingObjectSetEnum");
		result.add("maximumPly");
		result.add("agentWhoActsLastIfNoAgreementIsReached");

		return result;
	};


	public ArrayList<String> getObjectScalarFieldData() {

		final ArrayList<String> result = new ArrayList<String>();

		// Sadly, GWT support for Java reflection is quite limited.
		result.add(this.tradingObjectSetEnum.name());
		result.add(Integer.toString(this.maximumPly));
		result.add(this.agentWhoActsLastIfNoAgreementIsReached.name());

		return result;
	};


	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("{");
		final ArrayList<String> fieldData = getObjectScalarFieldData();
		fieldData.add(this.history.toString());
		fieldData.add(this.expressionHistory.toString());
		final Iterator<String> iterator = fieldData.iterator();
		assert (iterator.hasNext());

		builder.append(iterator.next());
		while (iterator.hasNext()) {
			builder.append(", ");
			builder.append(iterator.next());
		};
		builder.append("}");

		final String result = builder.toString();
		return result;
	};


	public String to2DFormattedString() {

		final StringBuilder builder = new StringBuilder();

		final ArrayList<String> fieldHeaders = getObjectScalarFieldHeaders();
		final ArrayList<String> fieldData = getObjectScalarFieldData();
		fieldHeaders.add("history");
		fieldData.add(this.history.toString());
		fieldHeaders.add("expressionHistory");
		fieldData.add(this.expressionHistory.toString());
		final Iterator<String> headerIterator = fieldHeaders.iterator();
		final Iterator<String> dataIterator = fieldData.iterator();

		builder.append(headerIterator.next()).append(" = ").append(dataIterator.next()).append('\n');
		while (headerIterator.hasNext()) {
			assert (dataIterator.hasNext());
			builder.append(headerIterator.next()).append(" = ").append(dataIterator.next()).append('\n');
		};
		assert(false == dataIterator.hasNext());

		final String result = builder.toString();
		return result;
	};


	public TradingObjectSetEnum getTradingObjectSetEnum() {
		final TradingObjectSetEnum result = TradingObjectSetEnum.valueOf(tradingObjectSetEnum.name());
		return result;
	};


	public TradingAction getMostRecentTradingAction() {

		final TradingAction result;

		if (this.isEmpty()) {
			result = null;
		} else {
			result = this.history.get(history.size()-1);
		};

		return result;
	};


	public Proposal getMostRecentProposal() {

		final Proposal result;

		final int currentSize = this.size();
		switch(currentSize) {
		case 0:
			result = null;
			break;
		case 1:
			result = this.get(currentSize-1).getProposal();
			break;
		default:
			final Proposal proposalOfLastTradingAction = this.get(currentSize-1).getProposal();
			if (null == proposalOfLastTradingAction) {
				result = this.get(currentSize-2).getProposal();
			} else {
				result = proposalOfLastTradingAction;
			};
		};

		return result;
	};


	public AgentEnum getWhoseTurnIsNext() {

		final AgentEnum result;

		final int size = this.size();
		if (this.maximumPly <= size) {
			result = null;
		} else if (this.isEmpty()) {
//			if (0 == maximumPly % 2) {
/*			if (4 == maximumPly % 5) {
				result = AgentEnum.getOtherAgent(this.agentWhoActsLastIfNoAgreementIsReached);
			} else {
				result = this.agentWhoActsLastIfNoAgreementIsReached;
			};*/
/*			if (4 == maximumPly % 6) {
				result = AgentEnum.getOtherAgent(this.agentWhoActsLastIfNoAgreementIsReached);
			} else {
				result = this.agentWhoActsLastIfNoAgreementIsReached;
			};*/
			if (6 == (maximumPly-2) % 11) {
				result = AgentEnum.getOtherAgent(this.agentWhoActsLastIfNoAgreementIsReached);
			} else {
				result = this.agentWhoActsLastIfNoAgreementIsReached;
			};
		} else {
//			result = AgentEnum.getOtherAgent(this.getMostRecentProposal().getAgentWhoMadeProposal());
/*			if (3 == (maximumPly - history.size()) % 5) {
				result = this.getMostRecentProposal().getAgentWhoMadeProposal();
			} else {
				result = AgentEnum.getOtherAgent(this.getMostRecentProposal().getAgentWhoMadeProposal());			
			};*/
			
/*			if ((0 == (maximumPly - history.size()) % 5) || (4 == (maximumPly - history.size()) % 5)) {
				result = AgentEnum.getOtherAgent(this.getMostRecentProposal().getAgentWhoMadeProposal());			
			} else {
				result = this.getMostRecentProposal().getAgentWhoMadeProposal();
			};*/
			
/*			if (4 == (maximumPly - history.size()+2) % 5) {
					result = AgentEnum.player;
			} else if (3 == (maximumPly - history.size()+2) % 5) {
				result = AgentEnum.player;
			} else if (2 == (maximumPly - history.size()+2) % 5) {
				result = AgentEnum.player;				
			} else if (1 == (maximumPly - history.size()+2) % 5) {
				result = AgentEnum.player;				
			} else {
				result = AgentEnum.counterpart;				
			}*/
			
/*			if (5 == (maximumPly - history.size()+2) % 6) {
				result = AgentEnum.player;
			} else if (4 == (maximumPly - history.size()+2) % 6) {
				result = AgentEnum.player;
			} else if (3 == (maximumPly - history.size()+2) % 6) {
				result = AgentEnum.player;
			} else if (2 == (maximumPly - history.size()+2) % 6) {
				result = AgentEnum.player;				
			} else if (1 == (maximumPly - history.size()+2) % 6) {
				result = AgentEnum.player;				
			} else {
				result = AgentEnum.counterpart;				
			}*/
			
			int currentSize = (maximumPly - history.size()) % 11;
			if (10 == currentSize || 9 == currentSize || 8 == currentSize || 7 == currentSize || 6 == currentSize ||
					5 == currentSize || 4 == currentSize || 3 == currentSize || 2 == currentSize || 1 == currentSize) {
				result = AgentEnum.player;
			} else {
				result = AgentEnum.counterpart;				
			}

		};

		return result;
	};


	public int getPlyRemaining() {
		final int result = this.maximumPly - history.size();
		return result;
	};


	public List<TradingAction> getHistory() {
		final List<TradingAction> result = Collections.unmodifiableList(this.history);
		return result;
	};


	public List<TradingExpression> getExpressionHistory() {
		final List<TradingExpression> result = Collections.unmodifiableList(this.expressionHistory);
		return result;
	};


	public boolean add(final TradingAction tradingAction) {
		assert ((null == tradingAction.getProposal()) || this.tradingObjectSetEnum.getSetOfTradingObjectEnum().equals(tradingAction.getProposal().getSetOfTradingObjectEnum()));
		assert ((null == tradingAction.getProposal()) || this.getWhoseTurnIsNext().equals(tradingAction.getProposal().getAgentWhoMadeProposal()));
		final boolean result = history.add(tradingAction);
		return result;
	};


	public boolean add(final TradingExpression tradingExpression) {
		final boolean result = expressionHistory.add(tradingExpression);
		return result;
	};


	public int size() {
		return history.size();
	};


	public TradingAction get(final int index) {
		final TradingAction result = history.get(index);
		return result;
	};


	@Override
	public Iterator<TradingAction> iterator() {
		final Iterator<TradingAction> result = new ImmutableList<TradingAction>(history).iterator();
		return result;
	};


	@Override
	public boolean isEmpty() {
		final boolean result = history.isEmpty();
		return result;
	};


	@Override
	public boolean contains(final Object o) {
		final boolean result = history.contains(o);
		return result;
	};


	@Override
	public Object[] toArray() {
		final Object[] result = history.toArray();
		return result;
	};


	@Override
	public <T> T[] toArray(final T[] a) {
		final T[] result = history.toArray(a);
		return result;
	};


	@Override
	public boolean remove(final Object o) {
		final UnsupportedOperationException e = new UnsupportedOperationException("It is not possible to remove a " + TradingAction.class.getName() + " from a " + this.getClass().getName() + ".");
		throw e;
	};


	@Override
	public boolean containsAll(final Collection<?> c) {
		final boolean result = history.containsAll(c);
		return result;
	};


	@Override
	public boolean addAll(final Collection<? extends TradingAction> c) {
		final UnsupportedOperationException e = new UnsupportedOperationException("It is not possible to simultaneously add multiple" + TradingAction.class.getName() + "s to a " + this.getClass().getName() + ".");
		throw e;
	};


	@Override
	public boolean removeAll(final Collection<?> c) {
		final UnsupportedOperationException e = new UnsupportedOperationException("It is not possible to remove a " + TradingAction.class.getName() + " from a " + this.getClass().getName() + ".");
		throw e;
	};


	@Override
	public boolean retainAll(final Collection<?> c) {
		final UnsupportedOperationException e = new UnsupportedOperationException("It is not possible to remove a " + TradingAction.class.getName() + " from a " + this.getClass().getName() + ".");
		throw e;
	};


	@Override
	public void clear() {
		final UnsupportedOperationException e = new UnsupportedOperationException("It is not possible to remove a " + TradingAction.class.getName() + " from a " + this.getClass().getName() + ".");
		throw e;
	};


	public NegotiationSessionDS generateDoublySerializable() {
		final NegotiationSessionDS result = new NegotiationSessionDS();
		result.setTradingObjectSetEnum(this.tradingObjectSetEnum);
		result.setMaximumPly(this.maximumPly);
		result.setAgentWhoActsLastIfNoAgreementIsReached(this.agentWhoActsLastIfNoAgreementIsReached);
		result.setHistory(this.history);
		result.setExpressionHistory(this.expressionHistory);
		return result;
	};

};
