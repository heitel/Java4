package application;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class FortunaController {
	@FXML
	private BorderPane bp;
	private ResizeableImageView iv;

	public FortunaController() {

	}
	
	@FXML
	private void initialize() {
		URL url = getClass().getResource("panorama.png");
		iv = new ResizeableImageView(url.toString());
		bp.setCenter(iv);
	}

}
