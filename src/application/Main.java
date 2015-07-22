package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;


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
			rotateLine(scene, line1);
			rotateLine(scene, line2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void rotateLine(Scene scene,Line line){
		final int STEP = 5;
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()){
				case UP:
					line.getTransforms().add(new Rotate(-STEP,50,50));
					break;
				case DOWN:
					line.getTransforms().add(new Rotate(STEP,50,50));
					break;
				case ENTER:
					//exit from here... 
					return;
				default:
					break;
				}
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
