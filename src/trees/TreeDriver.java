package trees;

public class TreeDriver {

    public static void main(String []args) {
        BST bst = new BST();
        System.out.println(bst.isEmpty());
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
//        System.out.println("Size: " + bst.size());
        System.out.println("\nLevel Order: ");
        bst.levelWise(bst.root);
        System.out.println("\nIterative Level Order: ");
        bst.iterativeLevelWise();
        System.out.println("\nPre-Order: ");
        bst.preOrder(bst.root);
        System.out.println("\nIterative Pre-Order: ");
        bst.iterativePreOrder();
        System.out.println("\nPost-Order: ");
        bst.postOrder(bst.root);
        System.out.println("\nIterative Post-Order: ");
        bst.iterativePostOrder();
//        Node temp = bst.search(bst.root, 80);
//        if(temp != null)
//            System.out.println("Value found: " + temp.val);
//        System.out.println("Max width: " + bst.maxWidth(bst.root));
//        System.out.println("Max element: " + bst.findMax(bst.root));
//        bst.delete(bst.root, 60);
        System.out.println("\nIn-Order: ");
        bst.inOrder(bst.root);
        System.out.println("\nIterative In-Order: ");
        bst.iterativeInOrder();
    }

}
