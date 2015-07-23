package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Line line1 = new Line(50, 50, 400, 50);
			Line line2 = new Line(50, 50, 400, 50);
			line1.setStrokeWidth(4);
			line2.setStrokeWidth(4);
			line1.setStroke(Color.YELLOWGREEN);
			line2.setStroke(Color.CHARTREUSE);
			root.getChildren().add(line1);
			root.getChildren().add(line2);
//			rotateLine(scene, line1);
//			rotateLine(scene, line2);
			primaryStage.setScene(scene);
			primaryStage.show();

            StateManager manager = new StateManager();

            manager.addState(new LineRotationState(scene, line1));
            manager.addState(new LineRotationState(scene, line2));

            manager.runNextState();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
