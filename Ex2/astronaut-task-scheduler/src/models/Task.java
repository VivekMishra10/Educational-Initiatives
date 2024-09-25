package models;

public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;
    private boolean completed;


    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
    return startTime + " - " + endTime + ": " + description + " [" + priority + "]" + (completed ? " [Completed]" : "");
}

}
