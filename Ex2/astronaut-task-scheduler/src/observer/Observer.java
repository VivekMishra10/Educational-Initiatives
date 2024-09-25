package observer;

import models.Task;

public interface Observer {
    void onConflict(Task existingTask, Task newTask);
}
