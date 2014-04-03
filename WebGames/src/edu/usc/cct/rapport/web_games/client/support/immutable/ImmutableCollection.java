package edu.usc.cct.rapport.web_games.client.support.immutable;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;


/**
 * Wraps a <code>Collection</code> in an immutability cloak, while preserving BaseObject functionality.
 */
abstract public class ImmutableCollection<T> implements Collection<T> {

	final protected Collection<T> collection;


	protected ImmutableCollection(final Collection<T> collection) {
		if (collection instanceof SortedSet<?>) {
			this.collection = Collections.unmodifiableSortedSet((SortedSet<T>)collection);
		} else if (collection instanceof Set<?>) {			
			this.collection = Collections.unmodifiableSet((Set<T>)collection);
		} else if (collection instanceof List<?>) {
			this.collection = Collections.unmodifiableList((List<T>)collection);
		} else {
			this.collection = Collections.unmodifiableCollection(collection);
		};
	};


	@Override
	public boolean add(final T value) {
		return collection.add(value);
	};


	@Override
	public boolean addAll(final Collection<? extends T> other) {
		return collection.addAll(other);
	};


	@Override
	public void clear() {
		collection.clear();
	};


	@Override
	public boolean contains(final Object value) {
		return collection.contains(value);
	};


	@Override
	public boolean containsAll(final Collection<?> other) {
		return collection.containsAll(other);
	};


	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	};


	@Override
	public Iterator<T> iterator() {
		return collection.iterator();
	};


	@Override
	public boolean remove(final Object value) {
		return collection.remove(value);
	};


	@Override
	public boolean removeAll(final Collection<?> other) {
		return collection.removeAll(other);
	};


	@Override
	public boolean retainAll(final Collection<?> other) {
		return collection.retainAll(other);
	};


	@Override
	public int size() {
		return collection.size();
	};


	@Override
	public Object[] toArray() {
		return collection.toArray();
	};


	@Override
	public <U> U[] toArray(final U[] targetArray) {
		return collection.toArray(targetArray);
	};

};
