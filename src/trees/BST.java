package trees;
import java.util.Stack;
import java.util.LinkedList;

/**
 * Functions to implement -
 *
 * insert
 * preOrder
 * inOrder
 * postOrder
 * levelWise
 * delete
 * size
 * search
 * isEmpty
 * findMin
 * findMax
 * height
 * maxWidth
 *
 * Iterative approaches -
 *
 * iterativeInsert //TODO
 * iterativeDelete //TODO
 * iterativePreOrder
 * iterativeInOrder
 * iterativePostOrder
 * iterativeLevelWise
 * iterativeSearch //TODO
 * iterativeHeight //TODO
 **/

class Node{
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class BST {
    Node root;
    int counter;

    BST() {
        root = null;
        counter = 0;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    public Node insertRec(Node root, int val) {
        if(root == null)
            return new Node(val);
        if(val < root.val)
            root.left = insertRec(root.left, val);
        else if(val > root.val)
            root.right = insertRec(root.right, val);
        return root;
    }

    public Node search(Node root, int val) {
        if(root == null || root.val == val)
            return root;
        if(root.val < val)
            return search(root.right, val);
        else
            return search(root.left, val);
    }

    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    /**
     * inOrder successor - smallest in right subtree
     * inOrder predecessor - largest in left subtree
     */
    public Node delete(Node root, int val) {
        if(root == null)
            return root;
        if(val < root.val)
            root.left = delete(root.left, val);
        else if(val > root.val)
            root.right = delete(root.right, val);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            /**
             * Node with two children
             */
            root.val = findMin(root.right);
            root.right = delete(root.right, val);
        }
        return root;
    }

    public int findMin(Node root) {
        int min = root.val;
        while(root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public int findMax(Node root) {
        if(root == null)
            return -1;
        int max = root.val;
        while(root.right != null) {
            max = root.right.val;
            root = root.right;
        }
        return max;
    }

    public int height(Node root) {
        if(root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    public int width(Node root, int level) {
        if(root == null)
            return 0;
        if(level == 1)
            return 1;
        else if(level > 1)
            return width(root.left, level-1) + width(root.right, level -1);
        return 0;
    }

    public int maxWidth(Node root) {
        int maxWidth = 0;
        for(int i = 1; i <= height(root); i++) {
            int width = width(root, i);
            if(width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    public void printCurrLevel(Node root, int level) {
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.val + " ");
        else if(level > 1) {
            printCurrLevel(root.left, level - 1);
            printCurrLevel(root.right, level - 1);
        }
    }

    public void levelWise(Node root) {
        for(int i =1; i <= height(root); i++)
            printCurrLevel(root, i);
    }

    /**
     * Iterative Approaches to some of the above implementations
     */

    public void iterativeInsert(int val) {

    }

    public void iterativeDelete(int val) {

    }

    public void iterativeSearch(int val) {

    }

    public void iterativePreOrder() {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            Node temp = stack.pop();
            System.out.print(temp.val + " ");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }

    }

    public void iterativeInOrder() {
        if(root == null)
            return;

        Stack<Node>stack = new Stack<>();
        Node curr = root;

        while(curr != null || !stack.empty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public void iterativePostOrder() {
        if(root == null)
            return;
        Stack<Node> tempStack = new Stack<>();
        Stack<Node> finalStack = new Stack<>();
        tempStack.push(root);
        while(!tempStack.empty()) {
            Node tmp = tempStack.pop();
            finalStack.push(tmp);
            if(tmp.left != null)
                tempStack.push(tmp.left);
            if(tmp.right != null)
                tempStack.push(tmp.right);
        }
        while(!finalStack.empty()) {
            Node data = finalStack.pop();
            System.out.print(data.val + " ");
        }
    }

    public void iterativeLevelWise() {
        if(root == null)
            return;
        LinkedList<Node>list = new LinkedList<>();
        Node temp = root;
        while(temp != null) {
            System.out.print(temp.val + " ");
            if(temp.left != null)
                list.add(temp.left);
            if(temp.right != null)
                list.add(temp.right);
            temp = list.poll();
        }
    }

    public int iterativeHeight() {
        return 0;
    }
}
