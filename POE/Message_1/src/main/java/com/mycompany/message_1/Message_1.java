/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.message_1;
import java.util.Objects;
/**
 *
 * @author RC_Student_lab
 */
public class Message_1 {
    private final String recipient;
    private final String message;
    private final String flag; // Sent, Stored, Disregard
    private final String messageID;
    private final String messageHash;

    public Message_1(String recipient, String message, String flag) {
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.messageID = generateMessageID();
        this.messageHash = generateMessageHash();
    }

    private String generateMessageID() {
        return message.length()+"/26";
    }

    private String generateMessageHash(String message) {
        return Integer.toHexString(Objects.hash(message));
    }
    //invoking getters
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getFlag() { return flag; }
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }

    @Override
    public String toString(){
        String messageId = null;
        return "Recipient:"
               +recipient
                +"/nMessage:"
                +message
                +"/nFlag:"
                +flag
                +"/nMessage ID:"
                +messageId
                +"/nHash:"
                +messageHash;
        
    }

    private String generateMessageHash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
