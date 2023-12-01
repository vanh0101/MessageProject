/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messageproject;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author admin
 */
class BufferQueue {
    private final Queue<String> queue;
    private final int maxSize ;

    public BufferQueue(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void enqueue(String item) {
        if (queue.size() < maxSize) {
            queue.offer(item);
        } else {
            System.out.println("Buffer queue is full. Cannot enqueue more messages.");
        }
    }

    public String dequeue() {
        if (!isEmpty()) {
            return queue.poll();
        }
        return null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class MessageStack {
    private final Stack<String> stack;

    public MessageStack() {
        this.stack = new Stack<>();
    }

    public void push(String item) {
        stack.push(item);
    }

    public String pop() {
        if (!isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return stack.peek();
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class Test1 {
    public static void main(String[] args) {
        int maxSize = 5; // Define maximum size for buffer queue
        BufferQueue bufferQueue = new BufferQueue(maxSize);
        MessageStack messageStack = new MessageStack();
        Scanner scanner = new Scanner(System.in);

        // Input messages from the keyboard
        System.out.println("Enter messages (press 'e' to send the message):");
        String userInput;
        while (!(userInput = scanner.nextLine()).equals("e")) {
           if (userInput.length() <= 250) {
                bufferQueue.enqueue(userInput);
            } else {
                System.out.println("Message exceeds 250 characters limit. Please enter a shorter message.");
            }
        }

        // Dequeue messages and push them to the message stack
        while (!bufferQueue.isEmpty()) {
            String message = bufferQueue.dequeue();
            if (message != null) {
                messageStack.push(message);
            }
        }

        // Pop messages from the message stack and display
        while (!messageStack.isEmpty()) {
            System.out.println("message is sended to stack: " + messageStack.pop());
        }

        scanner.close();
    }
}
