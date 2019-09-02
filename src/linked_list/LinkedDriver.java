package linked_list;

public class LinkedDriver {

    public static void main(String []args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("Is empty: " + singleLinkedList.isEmpty());
        singleLinkedList.insert(50);
        singleLinkedList.insert(40);
        singleLinkedList.insert(30);
        singleLinkedList.insert(20);
        singleLinkedList.traverseList();
        System.out.println("Size: " + singleLinkedList.size());
        singleLinkedList.sort();
        singleLinkedList.traverseList();
        singleLinkedList.delete(20);
        System.out.println("contains 30: " + singleLinkedList.contains(30));
        singleLinkedList.reverseList();
    }

}
