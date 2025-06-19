/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messagemanager_1;
import java.util.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;


/**
 *
 * @author RC_Student_lab
 */
public class MessageManager_1 {
    public List<Message> sentMessages = new ArrayList<>();
    public List<Message> storedMessages = new ArrayList<>();
    public List<Message> disregardedMessages = new ArrayList<>();
    public List<String> messageHashes = new ArrayList<>();
    public List<String> messageIDs = new ArrayList<>();

    public void populateMessages(List<Message> messages) {
        for (Message m : messages) {
            switch (m.getFlag().toLowerCase()) {
                case "sent":
                    sentMessages.add(m);
                    break;
                case "stored":
                    storedMessages.add(m);
                    break;
                case "disregard":
                    disregardedMessages.add(m);
                    break;
            }
            messageHashes.add(m.getMessageHash());
            messageIDs.add(m.getMessageID());
        }
    }

    public void readStoredMessagesFromJSON(String filename) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filename));
            for (Object obj : jsonArray) {
                JSONObject jsonMsg = (JSONObject) obj;
                String recipient = (String) jsonMsg.get("recipient");
                String message = (String) jsonMsg.get("message");
                storedMessages.add(new Message(recipient, message, "stored"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void displaySentSendersAndRecipients() {
        for (Message m : sentMessages) {
            System.out.println("Recipient: " + m.getRecipient());
        }
    }

   
    public String getLongestSentMessage() {
        String longest = "";
        for (Message m : sentMessages) {
            if (m.getMessage().length() > longest.length()) {
                longest = m.getMessage();
            }
        }
        return longest;
    }

    
    public String searchByMessageID(String id) {
        for (Message m : sentMessages) {
            if (m.getMessageID().equals(id)) {
                return m.getRecipient() + ": " + m.getMessage();
            }
        }
        return "Message ID not found.";
    }

    
    public List<String> searchByRecipient(String recipient) {
        List<String> result = new ArrayList<>();
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(recipient)) {
                result.add(m.getMessage());
            }
        }
        for (Message m : storedMessages) {
            if (m.getRecipient().equals(recipient)) {
                result.add(m.getMessage());
            }
        }
        return result;
    }

   
    public String deleteByMessageHash(String hash) {
        for (Iterator<Message> it = storedMessages.iterator(); it.hasNext(); ) {
            Message m = it.next();
            if (m.getMessageHash().equals(hash)) {
                it.remove();
                return "Message \"" + m.getMessage() + "\" successfully deleted.";
            }
        }
        return "Message not found.";
    }

   
    public void displaySentReport() {
        for (Message m : sentMessages) {
            System.out.println(m.toString());
        }
    }
}

