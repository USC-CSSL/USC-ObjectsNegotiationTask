package edu.usc.cct.rapport.web_games.client.support.immutable;

import java.util.Set;


/**
 * Wraps a <code>Set</code> in an immutability cloak, while preserving BaseObject functionality.
 */
public class ImmutableSet<T> extends ImmutableCollection<T> implements Set<T> {


	public ImmutableSet(final Set<T> set) {
		super(set);
	};

};
