import java.util.*;

public class BinaryTree {
    public static class Node{
        int value;
        Node left, right;

        public Node(int item){
            value = item;
            left = right = null;
        }
    }

    Node root;

    public BinaryTree(){
        root = null;
    }

    public void insert(int value){
        root = insertRecur(root, value);
    }

    private Node insertRecur(Node current, int value){
        if(current == null){
            current = new Node(value);
            current.value = value;
            return current;
        }

        if(current.value < value)
            current.right = insertRecur(current.right, value);
        else
            current.left = insertRecur(current.left, value);
        return current;
    }

    public void inOrder(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node curr = root;

        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node curr = root;

        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }

            if(stack.isEmpty()){
                return;
            }
            curr = stack.pop();

            if(!stack.isEmpty() && stack.peek() == curr)
                curr = curr.right;
            else{
                System.out.print(curr.value + " ");
                curr = null;
            }
        }

    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(4);
        tree.insert(5);
        tree.insert(8);
        tree.insert(9);
        tree.insert(2);
        tree.insert(1);
        tree.insert(10);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);

        System.out.println("inOrder: ");
        tree.inOrder();
        System.out.println("\n");

        System.out.println("preOrder: ");
        tree.preOrder();
        System.out.println("\n");

        System.out.println("postOrder: ");
        tree.postOrder();
        System.out.println("\n");
    }
}
