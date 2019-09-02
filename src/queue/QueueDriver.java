package queue;

public class QueueDriver {

    public static void main(String []args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Queue size: " + queue.size());
        queue.printQueue();
        if(!queue.isEmpty())
            System.out.println("Dequeue val: " + queue.qedueue());
        System.out.println("Queue size: " + queue.size());
        queue.printQueue();
    }

}
