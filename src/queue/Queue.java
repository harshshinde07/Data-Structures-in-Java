package queue;

/**
 * Functions to implement -
 *
 * enqueue
 * dequeue
 * size
 * isEmpty
 * printQueue
 **/

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
public class Queue {
    Node head;
    int counter;

    Queue() {
        head = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int size() {
        return counter;
    }

    public void printQueue() {
        Node headNode = this.head;
        while(headNode != null) {
            System.out.println(headNode.val);
            headNode = headNode.next;
        }
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        newNode.next = null;
        if(this.head == null) {
            head = newNode;
        } else {
            Node temp = this.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        counter++;
    }

    public int qedueue() {
        if(this.head == null)
            return -1;
        if(this.head.next == null) {
            int data = this.head.val;
            this.head = null;
            counter--;
            return data;
        } else {
            Node temp = this.head;
            head = head.next;
            counter--;
            return temp.val;
        }
    }
}
