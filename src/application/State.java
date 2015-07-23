package application;

/**
 * Разделили логику, которая работает с менеджером от конкретной работы с линиями
 */
public abstract class State {

    // Никто снаружи не знает, когда завершится это состяние.
    // Пусть об этом узнает Менеджер и принимает дальнейшие решения
    private StateManager manager;

    // Сеттер
    public void setManager(StateManager manager) {
        this.manager = manager;
    }

    // Состояние стартует
    public abstract void start();

    // Состояние завершается
    // public = и снаружи, и изнутри.
    public void finish() {
        manager.onStateFinished();
    }
}
