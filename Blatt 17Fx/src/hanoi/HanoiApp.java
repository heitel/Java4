package hanoi;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HanoiApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainPane root = new MainPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Türme von Hanoi");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
