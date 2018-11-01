package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class MyLayoutContainer extends Region {
	private ImageView pano;
	private ImageView pfeil;

	public MyLayoutContainer(ImageView pano, ImageView pfeil) {
		this.pano = pano;
		this.pfeil = pfeil;
		getChildren().addAll(pano, pfeil);
	}

	@Override
	protected void layoutChildren() {
		double width = getWidth();
		double height = getHeight();
		double y = 0;
		double faktor = 1;

		Image image = pano.getImage();
		if (image != null) {
			double imWidth = image.getWidth();
			double imHeight = image.getHeight();
			faktor = Math.min(width / imWidth, height / imHeight);
			double w = imWidth * faktor;
			double h = imHeight * faktor;
			pano.setFitWidth(w);
			pano.setFitHeight(h);
			pano.setX((width - w) / 2);
			y = (height - h) / 2;
			pano.setY(y);

			image = pfeil.getImage();
			if (image != null) {
				double imWidthP = image.getWidth();
				double imHeightP = image.getHeight();
				faktor /= 2;
				double wP = imWidthP * faktor;
				double hP = imHeightP * faktor;
				pfeil.setFitWidth(wP);
				pfeil.setFitHeight(hP);
				pfeil.setX((width - wP) / 2);
				pfeil.setY(y);
			}
		}
	}
}
