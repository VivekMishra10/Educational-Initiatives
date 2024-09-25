package utils;

import models.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeValidator {
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static boolean validateTimeFormat(String time) {
        try {
            timeFormat.setLenient(false);
            timeFormat.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isOverlap(Task existingTask, Task newTask) {
        try {
            return timeFormat.parse(newTask.getStartTime()).before(timeFormat.parse(existingTask.getEndTime())) &&
                    timeFormat.parse(newTask.getEndTime()).after(timeFormat.parse(existingTask.getStartTime()));
        } catch (ParseException e) {
            return false;
        }
    }
}
