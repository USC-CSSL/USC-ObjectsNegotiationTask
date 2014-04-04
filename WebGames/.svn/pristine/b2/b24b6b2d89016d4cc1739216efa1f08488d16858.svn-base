package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

public class ImageDisplayManagementWidget extends Composite {

	final private class PositionScaleAndShowImage implements LoadHandler {

		final private int imageResourceWidthInPixels;
		final private int imageResourceHeightInPixels;


		public PositionScaleAndShowImage(final int imageResourceWidthInPixels, final int imageResourceHeightInPixels) {
			this.imageResourceWidthInPixels = imageResourceWidthInPixels;
			this.imageResourceHeightInPixels = imageResourceHeightInPixels;
		};


		@Override
		public void onLoad(final LoadEvent event) {

			final Image imageAlias = ImageDisplayManagementWidget.this.image;
			imageAlias.removeFromParent();

			final int scaledWidthInPixels;
			final int scaledHeightInPixels;
			final int horizontalOffsetInPixels;
			final int verticalOffsetInPixels;
			if (preserveImageAspectRatio) {
				final double widthRatio = (double)boundingWidthInPixels / imageResourceWidthInPixels;
				final double heightRatio = (double)boundingHeightInPixels / imageResourceHeightInPixels;
				final double scalingRatio = Math.min(widthRatio, heightRatio);
				scaledWidthInPixels = (int)Math.floor(scalingRatio / widthRatio * boundingWidthInPixels);
				scaledHeightInPixels = (int)Math.floor(scalingRatio / heightRatio * boundingHeightInPixels);
				horizontalOffsetInPixels = (boundingWidthInPixels - scaledWidthInPixels) / 2;
				verticalOffsetInPixels = (boundingHeightInPixels - scaledHeightInPixels) / 2;
			} else {
				scaledWidthInPixels = boundingWidthInPixels;
				scaledHeightInPixels = boundingHeightInPixels;
				horizontalOffsetInPixels = 0;
				verticalOffsetInPixels = 0;
			};

			imageAlias.setVisible(true);
			imageAlias.setPixelSize(scaledWidthInPixels, scaledHeightInPixels);

			final SimplePanel simplePanelImageSizingAndPlacement = new SimplePanel();
			simplePanelImageSizingAndPlacement.add(imageAlias);
			simplePanelImageSizingAndPlacement.setPixelSize(scaledWidthInPixels, scaledHeightInPixels);

			ImageDisplayManagementWidget.this.absolutePanelBackgroundSizing.insert(simplePanelImageSizingAndPlacement, horizontalOffsetInPixels, verticalOffsetInPixels, 0);
		};
	};


	final private int boundingWidthInPixels;
	final private int boundingHeightInPixels;
	final private boolean preserveImageAspectRatio;

	final private AbsolutePanel absolutePanelBackgroundSizing;
	private Image image;
	private String hoverTextOfImage;


	public ImageDisplayManagementWidget(final int boundingWidthInPixels, final int boundingHeightInPixels, final boolean preserveImageAspectRatio, final ImageResource initialImageResource, final String hoverTextOfImage) {
		this.boundingWidthInPixels = boundingWidthInPixels;
		this.boundingHeightInPixels = boundingHeightInPixels;
		this.preserveImageAspectRatio = preserveImageAspectRatio;

		this.absolutePanelBackgroundSizing = new AbsolutePanel();
		this.absolutePanelBackgroundSizing.setPixelSize(boundingWidthInPixels, boundingHeightInPixels);
		initWidget(this.absolutePanelBackgroundSizing);

		this.setTitle(hoverTextOfImage);
		this.image = null;
		this.setImageResource(initialImageResource);
		assert (null != this.image);
	};


	public void setImageResource(final ImageResource imageResource) {
		if (null != this.image) {
			this.image.removeFromParent();
		};
		this.image = new Image();
		this.image.setVisible(false);
		this.image.setTitle(this.hoverTextOfImage);
		this.image.addLoadHandler(new PositionScaleAndShowImage(imageResource.getWidth(), imageResource.getHeight()));
		this.image.setUrl(imageResource.getURL());
		this.absolutePanelBackgroundSizing.add(image);
	};


	public void setTitle(final String hoverTextOfImage) {
		this.hoverTextOfImage = hoverTextOfImage;
		if (null != this.image) {
			this.image.setTitle(this.hoverTextOfImage);
		};
	};

};
