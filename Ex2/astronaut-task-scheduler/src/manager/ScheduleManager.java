package manager;

import models.Task;
import observer.ConflictObserver;
import observer.Observer;
import utils.Logger;
import utils.TimeValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final Observer conflictObserver;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        conflictObserver = new ConflictObserver();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task newTask) {
        if (!TimeValidator.validateTimeFormat(newTask.getStartTime()) || !TimeValidator.validateTimeFormat(newTask.getEndTime())) {
            Logger.error("Invalid time format. Please use HH:MM format.");
            return;
        }

        for (Task existingTask : tasks) {
            if (TimeValidator.isOverlap(existingTask, newTask)) {
                conflictObserver.onConflict(existingTask, newTask);
                return;
            }
        }

        tasks.add(newTask);
        Logger.info("Task added successfully: " + newTask.getDescription());
    }

    public void editTask(String description, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        Task taskToEdit = tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    
        if (taskToEdit == null) {
            Logger.error("Task not found: " + description);
        } else {
            if (newDescription != null && !newDescription.isEmpty()) taskToEdit.setDescription(newDescription);
            if (newStartTime != null && !newStartTime.isEmpty()) taskToEdit.setStartTime(newStartTime);
            if (newEndTime != null && !newEndTime.isEmpty()) taskToEdit.setEndTime(newEndTime);
            if (newPriority != null && !newPriority.isEmpty()) taskToEdit.setPriority(newPriority);
            Logger.info("Task edited successfully: " + taskToEdit.getDescription());
        }
    }

    public void viewTasksByPriority(String priority) {
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .sorted(Comparator.comparing(Task::getStartTime))
                .toList();
    
        if (filteredTasks.isEmpty()) {
            Logger.info("No tasks found with priority: " + priority);
        } else {
            filteredTasks.forEach(task -> Logger.info(task.toString()));
        }
    }
    
    public void markTaskAsCompleted(String description) {
        Task taskToComplete = tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    
        if (taskToComplete == null) {
            Logger.error("Task not found: " + description);
        } else {
            taskToComplete.setCompleted(true);
            Logger.info("Task marked as completed: " + taskToComplete.getDescription());
        }
    }
    
    

    public void removeTask(String description) {
        Task taskToRemove = tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);

        if (taskToRemove == null) {
            Logger.error("Task not found: " + description);
        } else {
            tasks.remove(taskToRemove);
            Logger.info("Task removed successfully: " + description);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            Logger.info("No tasks scheduled for the day.");
        } else {
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            tasks.forEach(task -> Logger.info(task.toString()));
        }
    }
}
