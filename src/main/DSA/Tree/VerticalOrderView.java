package DSA.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(30);
        root.right= new TreeNode(10);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(70);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(60);
        verticalOrderView(root);

	}
	
	static void verticalOrderView(TreeNode A){
		int maxL= 0;
		int minl=0;
		Queue<pair> q = new LinkedList<>();
		pair x= new pair(0,A);
		q.offer(x);
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		while(!q.isEmpty()) {
			pair z= q.poll();
			maxL= Math.max(maxL, z.key);
			minl= Math.min(minl, z.key);
			ArrayList<Integer> lst;
			if(map.containsKey(z.key)) {
				lst = map.get(z.key);
				lst.add(z.x.val);
				
			}
			else {
				lst = new ArrayList<>();
				lst.add(z.x.val);
				
			}
			map.put(z.key,lst);
			
			if(z.x.left!=null) {
				
				q.offer(new pair(z.key-1,z.x.left));
			}
            if(z.x.right!=null) {
				
				q.offer(new pair(z.key+1,z.x.right));
			}
		}
		while(minl<=maxL) {
			System.out.println(map.get(minl));
			
			minl++;
		}
		
		
		}
	
	

}

class pair{
	int key ;
	TreeNode x;
	
	pair(int k,TreeNode p){
		key =k;
		x=p;
	}
}
