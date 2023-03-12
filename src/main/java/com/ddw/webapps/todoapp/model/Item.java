package com.ddw.webapps.todoapp.model;

public class Item {
    private String task;
    private String startDate;
    private String endDate;
    private boolean completed;

    public String getTask() {
        return task;
    }

    public void setTask(String todo) {
        this.task = task;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
