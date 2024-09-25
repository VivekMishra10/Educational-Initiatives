package main;

import manager.ScheduleManager;
import models.TaskFactory;
import utils.Logger;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Logger.info("Astronaut Schedule Management System Started...");
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Logger.info("Enter a command (add, remove, view, viewbypriority, edit, complete, quit): ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    Logger.info("Enter task description: ");
                    String description = scanner.nextLine();

                    Logger.info("Enter task start time (HH:MM): ");
                    String startTime = scanner.nextLine();

                    Logger.info("Enter task end time (HH:MM): ");
                    String endTime = scanner.nextLine();

                    Logger.info("Enter task priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();

                    scheduleManager.addTask(TaskFactory.createTask(description, startTime, endTime, priority));
                    break;

                case "remove":
                    Logger.info("Enter task description to remove: ");
                    String taskDescription = scanner.nextLine();
                    scheduleManager.removeTask(taskDescription);
                    break;

                case "view":
                    scheduleManager.viewTasks();
                    break;
                
                    case "viewbypriority":
                    Logger.info("Enter priority level (High, Medium, Low): ");
                    String prioritylevel = scanner.nextLine();
                    scheduleManager.viewTasksByPriority(prioritylevel);
                    break;
        
                case "edit":
                    Logger.info("Enter task description to edit: ");
                    String taskToEdit = scanner.nextLine();
        
                    Logger.info("Enter new description (or press Enter to keep current): ");
                    String newDescription = scanner.nextLine();
        
                    Logger.info("Enter new start time (or press Enter to keep current): ");
                    String newStartTime = scanner.nextLine();
        
                    Logger.info("Enter new end time (or press Enter to keep current): ");
                    String newEndTime = scanner.nextLine();
        
                    Logger.info("Enter new priority (or press Enter to keep current): ");
                    String newPriority = scanner.nextLine();
        
                    scheduleManager.editTask(taskToEdit, newDescription, newStartTime, newEndTime, newPriority);
                    break;
        
                case "complete":
                    Logger.info("Enter task description to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    scheduleManager.markTaskAsCompleted(taskToComplete);
                    break;

                case "quit":
                    Logger.info("Exiting Astronaut Schedule Management System.");
                    scanner.close();
                    return;

                default:
                    Logger.error("Invalid command. Please try again.");
            }
        }
    }
}
