package edu.usc.cct.rapport.web_games.client.support.immutable;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;


/**
 * Wraps a <code>SortedSet</code> in an immutability cloak, while preserving BaseObject functionality.
 */
public class ImmutableSortedSet<T> extends ImmutableSet<T> implements SortedSet<T> {


	public ImmutableSortedSet(final Set<T> set) {
		super(set);
	};


	@Override
	public Comparator<? super T> comparator() {
		return ((SortedSet<T>)collection).comparator();
	};


	@Override
	public T first() {
		return ((SortedSet<T>)collection).first();
	};


	@Override
	public SortedSet<T> headSet(final T toElement) {
		return ((SortedSet<T>)collection).headSet(toElement);
	};


	@Override
	public T last() {
		return ((SortedSet<T>)collection).last();
	};


	@Override
	public SortedSet<T> subSet(final T fromElement, final T toElement) {
		return ((SortedSet<T>)collection).subSet(fromElement, toElement);
	};


	@Override
	public SortedSet<T> tailSet(final T fromElement) {
		return ((SortedSet<T>)collection).tailSet(fromElement);
	};

};
