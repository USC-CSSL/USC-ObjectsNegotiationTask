package edu.usc.cct.rapport.web_games.client.support.immutable;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;


/**
 * Wraps a <code>List</code> in an immutability cloak, while preserving BaseObject functionality.
 */
public class ImmutableList<T> extends ImmutableCollection<T> implements List<T> {


	public ImmutableList(final List<T> list) {
		super(list);
	};


	@Override
	public void add(final int index, final T value) {
		((List<T>)collection).add(index, value);
	};


	@Override
	public boolean addAll(final int index, Collection<? extends T> other) {
		return ((List<T>)collection).addAll(index, other);
	};


	@Override
	public T get(final int index) {
		return ((List<T>)collection).get(index);
	};


	@Override
	public int indexOf(final Object value) {
		return ((List<T>)collection).indexOf(value);
	};


	@Override
	public int lastIndexOf(final Object value) {
		return ((List<T>)collection).lastIndexOf(value);
	};


	@Override
	public ListIterator<T> listIterator() {
		return ((List<T>)collection).listIterator();
	};


	@Override
	public ListIterator<T> listIterator(final int index) {
		return ((List<T>)collection).listIterator(index);
	};


	@Override
	public T remove(final int index) {
		return ((List<T>)collection).remove(index);
	};


	@Override
	public T set(final int index, final T value) {
		return ((List<T>)collection).set(index, value);
	};


	@Override
	public List<T> subList(final int fromIndex, final int toIndex) {
		return ((List<T>)collection).subList(fromIndex, toIndex);
	};

};
