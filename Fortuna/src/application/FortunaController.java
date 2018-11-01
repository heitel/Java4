package application;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class FortunaController {
	@FXML
	private BorderPane main;
	private ImageView pano = new ImageView(getClass().getResource("panorama.png").toString());
	private ImageView pfeil = new ImageView(getClass().getResource("pfeil.png").toString());
	
	public FortunaController() {		
	}
	
	@FXML
	private void initialize() {
		MyLayoutContainer container = new MyLayoutContainer(pano, pfeil);
		main.setCenter(container);
	}

	@FXML
	private void doFortuna() {
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), pano);
		double angle = (Math.random()-0.5) * 1440;
		rotateTransition.setByAngle(angle);
		rotateTransition.play();
	}
}
