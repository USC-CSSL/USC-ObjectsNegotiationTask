/**
 * Copyright 2010 University of Southern California.
 * All rights reserved.
 */
package edu.usc.cct.rapport.web_games.client;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * @author <a href="mailto:gomboc@ict.usc.edu">Dave Gomboc</a>
 */
public class DisplayUncaughtExceptionsOnClient implements UncaughtExceptionHandler {

	/*
	 * We hash throwables here as we build strings to report them. In this way,
	 * we can guarantee that we don't endlessly cycle should there be a loop
	 * (including exceptions that references themselves as their own cause).
	 */
	final private Set<Throwable> describedThrowables;


	public DisplayUncaughtExceptionsOnClient() {
		describedThrowables = new HashSet<Throwable>();
	};


	@Override
	public void onUncaughtException(final Throwable t) {
		final String errorReport = describeThisThrownExceptionAndItsLineage(t);
		System.err.print(errorReport);

		final DialogBox dialogBox = new DialogBox();
		final String htmlErrorReport = "<pre>" + errorReport.replaceAll("\n", "<br/>") + "</pre>";
		dialogBox.setHTML(htmlErrorReport);
		dialogBox.center();
	};


	private String describeThisThrownExceptionAndItsLineage(final Throwable t) {

		final StringBuilder builder = new StringBuilder();

		if (null == t) {
			// Do nothing.
		} else if (describedThrowables.contains(t)) {
			builder.append(t.toString()).append('\n');
			builder.append("This exception has been previously referenced.  Any available stack trace or causal information was also presented at that time.\n");
		} else {
			builder.append(describeThisThrownException(t));

			Throwable throwableJustDescribed = t;
			Throwable causeOfThrowableJustDescribed = t.getCause();

			while (null != causeOfThrowableJustDescribed) {
				builder.append("==========\n");
				builder.append("Caused by:\n");
				builder.append("==========\n");
				builder.append(describeThisThrownException(causeOfThrowableJustDescribed));
				throwableJustDescribed = causeOfThrowableJustDescribed;
				causeOfThrowableJustDescribed = throwableJustDescribed.getCause();
			};
		};

		final String result = builder.toString();
		return result;
	};


	private String describeThisThrownException(final Throwable t) {

		final StringBuilder builder = new StringBuilder();
		builder.append(t.toString()).append('\n');
		builder.append("============\n");
		builder.append("Stack trace:\n");
		builder.append("============\n");
		for (final StackTraceElement stackTraceElement: t.getStackTrace()) {
			builder.append(stackTraceElement.toString()).append('\n');
		};
		if (t instanceof UmbrellaException) {
			final UmbrellaException ue = (UmbrellaException)t;
			builder.append("========================================================\n");
			builder.append("Umbrella exception detected.  Listing nested exceptions.\n");
			builder.append("========================================================\n");
			for (final Throwable nestedThrowable: ue.getCauses()) {
				builder.append("Umbrella-wrapped exception:\n");
				builder.append(this.describeThisThrownException(nestedThrowable));
				builder.append("End of umbrella-wrapped exception.\n");
			};
		};

		final String result = builder.toString();
		return result;
	};

};
