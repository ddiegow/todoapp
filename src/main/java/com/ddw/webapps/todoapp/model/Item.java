package com.ddw.webapps.todoapp.model;

import java.util.UUID;

public class Item {
    private String ID;
    private String task;
    private String startDate;
    private String endDate;
    private boolean completed;

    protected Item() {

    }

    public Item(String ID, String task, String startDate, String endDate, boolean completed) {
        setID(ID);
        setTask(task);
        setStartDate(startDate);
        setEndDate(endDate);
        setCompleted(completed);
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
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
