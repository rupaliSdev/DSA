package DSA.Tree;

public class Tree_traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right= new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(60);
        Inorder(root);
	}

	private static void Inorder(TreeNode root) {
		
		
	}

}
