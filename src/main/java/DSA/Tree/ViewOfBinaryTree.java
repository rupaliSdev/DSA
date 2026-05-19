package DSA.Tree;

import java.util.*;

public class ViewOfBinaryTree {


//                   1
//                 /   \
//                 2    3
//               / \   / \
//              4   5 6  7
//                 /
//                 8

//    ans 1,3,7,8 right
    // 1 2 4 8 6 7 3
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println((root).toString());

    }

    private static void rightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                if (i == 0) System.out.print(x.val);
                if (x.right != null) q.offer(x.right);
                if (x.left != null) q.offer(x.left);

            }
            System.out.println();
        }

    }

    private static void leftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                if (i == 0) System.out.print(x.val);
                if (x.left != null) q.offer(x.left);
                if (x.right != null) q.offer(x.right);
            }
            System.out.println();
        }
    }


}
