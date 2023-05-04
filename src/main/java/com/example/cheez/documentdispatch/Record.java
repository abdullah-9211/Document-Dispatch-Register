package com.example.cheez.documentdispatch;

public class Record {
    String title;
    String senderID;
    String senderName;
    String reciever;
    String dept;

    public Record() {}

    public Record(String title, String senderID, String senderName, String reciever, String dept) {
        this.title = title;
        this.senderID = senderID;
        this.senderName = senderName;
        this.reciever = reciever;
        this.dept = dept;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
