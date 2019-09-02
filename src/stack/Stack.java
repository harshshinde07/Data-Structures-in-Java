package stack;

/**
 * Functions to implement -
 *
 * push
 * pop
 * isEmpty
 * size
 * peek
 * printStack
 **/

class Node {
    int val;
    Node link;

    Node(int val) {
        this.val = val;
    }
}
public class Stack {
    Node top;
    int counter;

    Stack() {
        top = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int size() {
        return counter;
    }

    public int peek() {
        return top.val;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if(this.top == null) {
            newNode.link = null;
            top = newNode;
        } else {
            newNode.link = top;
            top = newNode;
        }
        counter++;
    }

    public int pop() {
        if(this.top == null)
            return -1;
        Node temp = top;
        top = temp.link;
        counter--;
        return temp.val;
    }

    public void printStack() {
        Node temp = this.top;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.link;
        }
    }
}
