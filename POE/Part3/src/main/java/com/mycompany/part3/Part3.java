/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part3;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class Part3 {
    public static void main(String[] args) {
        MessageManager_1 manager = new MessageManager_1();

        List<Message> testMessages = Arrays.asList(
            new Message("+27834557896", "Did you get the cake?", "Sent"),
            new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored"),
            new Message("+27834484567", "Yohoooo, I am at your gate.", "Disregard"),
            new Message("0838884567", "It is dinner time !", "Sent"),
            new Message("+27838884567", "Ok, I am leaving without you.", "Stored")
        );

        manager.populateMessages(testMessages);

        // Sample method calls
        manager.displaySentSendersAndRecipients();
        System.out.println("Longest Sent Message: " + manager.getLongestSentMessage());
        System.out.println("Messages to +27838884567: " + manager.searchByRecipient("+27838884567"));
        manager.displaySentReport();
    }
}



    



