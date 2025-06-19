/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messagemanagertest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class MessageManagerTest {
    @Test
    public void testSentMessagesPopulated() {
        MessageManager manager = new MessageManager();
        List<Message> testData = Arrays.asList(
            new Message("+27834557896", "Did you get the cake?", "Sent"),
            new Message("0838884567", "It is dinner time !", "Sent")
        );
        manager.populateMessages(testData);
        assertEquals(2, manager.sentMessages.size());
    }

    @Test
    public void testLongestSentMessage() {
        MessageManager manager = new MessageManager();
        List<Message> testData = Arrays.asList(
            new Message("+27834557896", "Short", "Sent"),
            new Message("0838884567", "It is dinner time !", "Sent")
        );
        manager.populateMessages(testData);
        assertEquals("It is dinner time !", manager.getLongestSentMessage());
    }

    @Test
    public void testSearchByMessageID() {
        MessageManager manager = new MessageManager();
        Message m = new Message("0838884567", "It is dinner time !", "Sent");
        manager.populateMessages(List.of(m));
        assertEquals("0838884567: It is dinner time !", manager.searchByMessageID(m.getMessageID()));
    }

    @Test
    public void testSearchByRecipient() {
        MessageManager manager = new MessageManager();
        Message m1 = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        Message m2 = new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
        manager.populateMessages(List.of(m1, m2));
        List<String> result = manager.searchByRecipient("+27838884567");
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteByHash() {
        MessageManager manager = new MessageManager();
        Message m = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        manager.populateMessages(List.of(m));
        String result = manager.deleteByMessageHash(m.getMessageHash());
        assertEquals("Message \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", result);
    }

    private void assertEquals(int i, int size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String message_Where_are_you_You_are_late_I_have, String result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


