package DSA.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {

        int A[] = {1, 6, 2, 3};
        int B[] = {6, 1, 3, 2};
        System.out.println();
        buildTreeII(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});

    }


    static Map<Integer, Integer> map = new HashMap<>();
    static int preIndex = 0;

    public static TreeNode buildTreeFromINPRE(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = helper(preorder, left, index - 1);
        root.right = helper(preorder, index + 1, right);
        return root;
    }


    static Map<Integer, Integer> map2 = new HashMap<>();
    static int postIndex=0;
    public static TreeNode buildTreeII(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map2.put(inorder[i], i);
        }
        return helperI(postorder, 0, inorder.length - 1);
    }


    static TreeNode helperI(int[] postorder, int left, int right ) {
        if (left > right) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int index = map2.get(rootVal);
        root.right = helperI(postorder, index + 1, right);
        root.left = helperI(postorder, left, index - 1);
        return root;
    }


}
