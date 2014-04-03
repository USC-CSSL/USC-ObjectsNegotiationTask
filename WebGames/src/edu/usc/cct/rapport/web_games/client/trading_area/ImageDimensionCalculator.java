package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class ImageDimensionCalculator {

	final private int boundingWidthInPixels;
	final private int boundingHeightInPixels;


	public ImageDimensionCalculator(final int boundingWidthInPixels, final int boundingHeightInPixels) {
		// TODO: verify that the specified image height and width are both positive.
		this.boundingWidthInPixels = boundingWidthInPixels;
		this.boundingHeightInPixels = boundingHeightInPixels;
	};


	public Pair<Integer, Integer> getImageBoundsInPixels() {
		final Pair<Integer, Integer> result = new Pair<Integer, Integer>(this.boundingWidthInPixels, this.boundingHeightInPixels);
		return result;
	};


	public Pair<Integer, Integer> getScaledImageDimensionsInPixels(final Image image, final boolean preserveImageAspectRatio) {

		// TODO: Document that image width and height are not available under
		// all circumstances. Metadata may provide width and height, but the
		// image may need to be explicitly loaded. See the image code internals
		// for further details.

		final int scaledWidthInPixels;
		final int scaledHeightInPixels;

		final double imageWidthInPixels = image.getWidth();
		final double imageHeightInPixels = image.getHeight();

		if (preserveImageAspectRatio && 0 != imageWidthInPixels && 0 != imageHeightInPixels) {
			final double widthRatio = boundingWidthInPixels / imageWidthInPixels;
			final double heightRatio = boundingHeightInPixels / imageHeightInPixels;
			final double scalingRatio = Math.min(widthRatio, heightRatio);
			scaledWidthInPixels = (int)Math.floor(imageWidthInPixels * scalingRatio);
			scaledHeightInPixels = (int)Math.floor(imageHeightInPixels * scalingRatio);
		} else {
			scaledWidthInPixels = boundingWidthInPixels;
			scaledHeightInPixels = boundingHeightInPixels;
		};
		final Pair<Integer, Integer> result = new Pair<Integer, Integer>(scaledWidthInPixels, scaledHeightInPixels);
		return result;
	};

};
