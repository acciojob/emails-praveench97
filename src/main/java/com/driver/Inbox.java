package com.driver;

import java.util.Date;

public class Inbox {
    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Inbox(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }

    private Date date;
    private String sender;
    private String message;
}
