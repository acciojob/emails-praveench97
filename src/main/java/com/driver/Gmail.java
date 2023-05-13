package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Inbox> inboxList;
    ArrayList<Inbox> trashList;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inboxList = new ArrayList<>();
        trashList = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(!inboxList.isEmpty() && inboxCapacity == inboxList.size()){
            inboxList.remove(0);
        }
        inboxList.add(new Inbox(date, sender, message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0; i<inboxList.size(); i++){
            if(inboxList.get(i).getMessage().equals(message)){
                trashList.add(inboxList.get(i));
                inboxList.remove(i);
                return;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inboxList.size()==0){
            return null;
        }
        return inboxList.get(inboxList.size()-1).getMessage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inboxList.isEmpty())
            return null;
        return inboxList.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int startIndex = 0, endIndex =0;
        if(inboxList.isEmpty())
            return 0;
        for(int i= 0; i<inboxList.size(); i++){
            if(inboxList.get(i).getDate().compareTo(start)==0){
                startIndex = i;
                break;
            }
        }
        for(int i= 0; i<inboxList.size(); i++){
            if(inboxList.get(i).getDate().compareTo(end)==0){
                endIndex = i;
                break;
            }
        }
        return endIndex-startIndex+1;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inboxList.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashList.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trashList.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
