package edu.usc.cct.rapport.web_games.client.support.tuple;


/**
 * A mutable pair of objects, which are not necessarily of the same type.
 *
 * @param <T>  the type of the first item of the pair.
 * @param <U>  the type of the second item of the pair.
 */
final public class MutablePair<T, U> extends PairBase<T, U> {


	/** Default constructor. */
	public MutablePair() {
		super();
	};


	/** Live-object constructor.
	 * 
	 * @param t  the first item of the pair.
	 * @param u  the second item of the pair.
	 */
	public MutablePair(final T t, final U u) {
		super(t, u);
	};


	/** Sets the first object of the pair.
		@param newFirst
		the value to be assigned to the first object of the pair.
	*/
	public void setFirst (final T newFirst) {
		first  = newFirst;
	};


	/** Sets the second object of the pair.
		@param newSecond
		the value to be assigned to the second object of the pair.
	*/
	public void setSecond(final U newSecond) {
		second = newSecond;
	};

};
