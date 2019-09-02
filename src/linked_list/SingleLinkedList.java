package linked_list;

/**
 * Function to implement -
 *
 * insert
 * traverse
 * delete
 * size
 * sort
 * reverse
 * isEmpty
 * contains
 **/

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class SingleLinkedList {
    Node head;
    int counter;

    SingleLinkedList() {
        head = null;
        counter = 0;
    }

     public SingleLinkedList insert(int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        counter++;
        if(this.head == null) {
            this.head = new_node;
        }else {
            Node last = this.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return this;
    }

    public boolean contains(int elem) {
        Node curr = this.head;
        while(curr != null) {
            if(curr.val == elem)
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void traverseList() {
        Node curr = this.head;
        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int size() {
        return counter;
    }

    /*
    * head
    * anywhere
    * last
    * */
    public SingleLinkedList delete(int val) {
        Node headNode = this.head;
        if(headNode == null)
            return this;
        if(headNode.next == null) {
            this.head = null;
        }
        while(headNode.next != null) {
            Node prevNode = headNode;
            headNode = headNode.next;
            if(headNode.val == val) {
                prevNode.next = headNode.next;
            }
        }
        counter--;
        return this;
    }

    public SingleLinkedList reverseList() {
        if(this.head == null || this.head.next == null)
            return this;
        if(this.head.next.next == null) {
            Node headNode = this.head;
            Node nextNode = this.head.next;
            nextNode.next = headNode;
            headNode.next = null;
            this.head = nextNode;
            return this;
        }
        Node headNode = this.head.next.next;
        Node curr = this.head.next;
        Node prev = this.head;
        prev.next = null;
        while(curr.next != null) {
            curr.next = prev;
            prev = curr;
            if(headNode != null) {
                curr = headNode;
                headNode = headNode.next;
            }
        }
        curr.next = prev;
        this.head = curr;
        return this;
    }

    public SingleLinkedList sort() {
        if(this.head == null || this.head.next == null)
            return this;

        Node headNode = this.head;
        while(headNode != null) {
            Node nextNode = headNode.next;
            while(nextNode != null) {
                if(headNode.val > nextNode.val) {
                    int tmpVal = nextNode.val;
                    nextNode.val = headNode.val;
                    headNode.val = tmpVal;
                }
                nextNode = nextNode.next;
            }
            headNode = headNode.next;
        }
        return this;
    }
}
