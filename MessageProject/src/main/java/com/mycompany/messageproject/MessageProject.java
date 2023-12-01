/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messageproject;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
class QueueClass {
    private final Queue<String> queue;
    private final int maxSize ;

    public QueueClass(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void enqueue(String item) {
        if (queue.size() < maxSize) {
            queue.offer(item);
        } else {
            System.out.println("queue is full. Cannot enqueue more messages.");
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

class ClassStack {
    private final Stack<String> stack;

    public ClassStack() {
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
public class MessageProject {

    public static void main(String[] args) {
         int maxSize = 5; // Define maximum size for buffer queue
        QueueClass queueClass = new QueueClass(maxSize);
        ClassStack classStack = new ClassStack();
        Scanner scanner = new Scanner(System.in);

        // Input messages from the keyboard
        System.out.println("Enter messages (press 'e' stop the program):");
        String userInput;
        while (!(userInput = scanner.nextLine()).equals("e")) {
           if (userInput.length() <= 250) {
                queueClass.enqueue(userInput);
            } else {
                System.out.println("Message exceeds 250 characters limit."
                        + " Please enter a shorter message.");
            }
        }

        // Dequeue messages and push them to the message stack
        //check queue is empty có thể cho vào check lỗi planlist
        // giải thích kỹ thuật toán đẻ biết được complexity như thế nào
        while (!queueClass.isEmpty()) {
            String message = queueClass.dequeue();
            if (message != null) {
                classStack.push(message);
            }
        }

        // Pop messages from the message stack and display
        while (!classStack.isEmpty()) {
            System.out.println("message is sended to stack: " + classStack.pop());
        }

        scanner.close();
    }
   }

