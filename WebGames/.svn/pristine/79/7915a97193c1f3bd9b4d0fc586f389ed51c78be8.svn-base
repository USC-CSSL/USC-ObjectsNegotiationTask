package edu.usc.cct.rapport.web_games.client.support.tuple;


/**
 * An abstract base class for Pair and MutablePair.
 *
 * @param <T>  the type of the first item of the pair.
 * @param <U>  the type of the second item of the pair.
 */
abstract public class PairBase<T, U> {

	static final private int arbitraryPrimeNumber = 23;

	protected T first;
	protected U second;


	/** Default constructor. */
	public PairBase() {
		first = null;
		second = null;
	};


	/** Live-object constructor.
	 * 
	 * @param t  the first item of the pair.
	 * @param u  the second item of the pair.
	 */
	public PairBase(final T t, final U u) {
		first = t;
		second = u;
	};


	/** Gets the first object of the pair.
		@return
		the first object of the pair.
	*/
	public T getFirst() {
		return first;
	};


	/** Gets the second object of the pair.
		@return
		the second object of the pair.
	*/
	public U getSecond() {
		return second;
	};


	/** Obtain a new pair with the same contents as the current one that is guaranteed to be mutable.
	 * 
	 * @return
	 * A distinct mutable pair initialized to the same values as this pair.
	 */
	public MutablePair<T, U> getMutableEquivalent() {
		return new MutablePair<T, U>(first, second);
	};


	/** Obtain a new pair with the same contents as the current one that is guaranteed to be immutable.
	 * 
	 * @return
	 * A distinct immutable pair initialized to the same values as this pair.
	 */
	public Pair<T, U> getImmutableEquivalent() {
		return new Pair<T, U>(first, second);
	};


	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();
		buffer.append('(').append(first).append(',').append(' ').append(second).append(')');
		return buffer.toString();
	};


	@Override
	public boolean equals(final Object otherObject) {

		if (this == otherObject) {
			return true;
		};

		if (null == otherObject) {
			return false;
		};

		if (getClass() != otherObject.getClass()) {
			return false;
		};

		@SuppressWarnings("unchecked") final Pair<T, U> other = (Pair<T, U>) otherObject;

		if (this.first != other.first) {
			return false;
		};

		if (this.second != other.second) {
			return false;
		};

		return true;
	};


	@Override
	public int hashCode() {
		return first.hashCode() * arbitraryPrimeNumber + second.hashCode();
	};

};
