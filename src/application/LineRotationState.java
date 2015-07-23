package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

/**
 * Описывает состояние, при котором нажатие стрелок наклоняет линию
 * Ничего не знает о менеджере, только выполняет super.finish(); при завершении
 */
public class LineRotationState extends State {

    private final static int STEP = 5;

    private final Scene scene;

    private final Line line;

    // Конструктор
    public LineRotationState(Scene scene, Line line) {
        this.scene = scene;
        this.line = line;
    }

    // Состояние стартует
    @Override
    public void start() {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        line.getTransforms().add(new Rotate(-STEP, 50, 50));
                        break;
                    case DOWN:
                        line.getTransforms().add(new Rotate(STEP, 50, 50));
                        break;
                    case ENTER:
                        finish();
                        return;
                    default:
                        break;
                }

            }

        });

    }

    // Состояние завершается
    // public = и снаружи, и изнутри.
    @Override
    public void finish() {
        // Очищаем сцену от себя
        scene.setOnKeyPressed(null);
        // Уведомляем менеджера
        super.finish();
    }
}
