package application;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class LineRotationStateManager {

    // Очередь состояний, новые добавляются в конец, выполненные - удаляются с головы
    private Queue<LineRotationState> stateQueue = new LinkedList<LineRotationState>();

    // Добавление в очередь
    public void addState(LineRotationState state) {
        state.setManager(this);
        stateQueue.add(state);
    }

    // Выполнение следующего состояния, если есть что выполнять
    public void runNextState() {
        LineRotationState state = stateQueue.poll();
        if (state != null) {
            state.start();
        }
    }

    // Вызывается State-ом
    public void onStateFinished() {
        // При завершении предыдущего, просто запускаем следующее
        runNextState();
    }
}
