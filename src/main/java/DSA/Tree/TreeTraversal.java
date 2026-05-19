package DSA.Tree;

import java.util.*;

public class TreeTraversal {

    //               20
//	30                      10
//50 	    70              15       60
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(60);
        System.out.println(InorderIter(root));
        System.out.println(preOrderIter(root));
        System.out.println(postorderIter(root));
        System.out.println(levelOrderTraversal(root));
        System.out.println(zigzagLevelOrder(root));
    }

    //root left right
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    //process root then go to child
    public static List<Integer> preOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left); //want left to be processed and get stored in result

        }
        return res;
    }


    //left right root
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> postorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode curr = s1.pop();

            s2.push(curr);
            if (curr.left!=null) s1.push(curr.left);
            if (curr.right!=null) s1.push(curr.right);//last In first out so right will be processed first and stored in s2

        }

        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;

    }



    //left - root-right
    public static void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.println(root.val);
        Inorder(root.right);
    }


    public static List<Integer> InorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;

        }
        return res;
    }


    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                res.add(x.val);
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
            result.add(res);
        }
        return result;
    }

    //zigzagtraversal

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode q = queue.poll();
                if (leftToRight) res.addLast(q.val);
                else res.addFirst(q.val);
                if (q.left != null) queue.add(q.left);
                if (q.right != null) queue.add(q.right);
            }
            result.add(res);

            leftToRight = !leftToRight;

        }
        return result;
    }

}
