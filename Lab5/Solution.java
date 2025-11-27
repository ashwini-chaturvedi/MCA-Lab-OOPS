package Lab5;

class Node{
    Node left,right;
    int data;

    public Node(int data){
        this.data = data;
        left=right=null;
    }
    public Node RemoveHalfNodes(Node root) {
        if(root==null) return null;

        root.left=RemoveHalfNodes(root.left);
        root.right=RemoveHalfNodes(root.right);

        if(root.left==null && root.right==null){
            return root;
        }

        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }

        return root;

    }
    public void InOrder(Node root){
        if(root==null) return;
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }
}
public class Solution {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.InOrder(root);
        root.RemoveHalfNodes(root);

        root.InOrder(root);

    }
}
