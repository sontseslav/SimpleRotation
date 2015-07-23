package application;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class StateManager {

    // Очередь состояний, новые добавляются в конец, выполненные - удаляются с головы
    private Queue<State> stateQueue = new LinkedList<State>();

    // Добавление в очередь
    public void addState(State state) {
        state.setManager(this);
        stateQueue.add(state);
    }

    // Выполнение следующего состояния, если есть что выполнять
    public void runNextState() {
        State state = stateQueue.poll();
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
