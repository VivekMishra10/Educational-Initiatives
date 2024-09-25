package observer;

import models.Task;
import utils.Logger;

public class ConflictObserver implements Observer {
    @Override
    public void onConflict(Task existingTask, Task newTask) {
        Logger.error("Task conflict detected: New task \"" + newTask.getDescription() +
                "\" conflicts with existing task \"" + existingTask.getDescription() + "\".");
    }
}
