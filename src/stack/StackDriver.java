package stack;

public class StackDriver {

    public static void main(String []args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());
        stack.printStack();
        if(!stack.isEmpty())
            System.out.println("Popped: " + stack.pop());
        stack.printStack();
    }

}
