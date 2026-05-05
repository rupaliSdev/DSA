package DSA.Tree;

import java.util.ArrayList;

import static DSA.Tree.TreeTraversal.Inorder;

public class BinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(60);
        Inorder(root);
        findPath(root, 60);
        System.out.println(lst);
    }

    //find the path from root to given node k in a binary tree having unique values
    static ArrayList<Integer> lst = new ArrayList<>();

    public static boolean findPath(TreeNode root, int k) {
        if (root != null) {


            if (root.val == k) {
                lst.add(root.val);
                return true;
            }

            if (findPath(root.left, k) || findPath(root.right, k)) {
                lst.add(root.val);
                return true;
            }
        }
        return false;


    }



}