package com.example.mynotes.model;

public class Notes {

    private int id;
    private String note;
    private String timestamp;

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
