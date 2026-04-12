package DSA.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  arr = new int[] {10 ,1 ,8,9,7,6,5,11,3};
		
		int[] ans =findThesubarraymax(arr,3);
		System.out.println(Arrays.toString(ans));

	}

	 static int[] findThesubarraymax(int[] arr,int k) {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new LinkedList<>();
		
		int[] res = new int[arr.length-k+1];
		for(int i=0;i<arr.length;i++) {
			
			if(dq.size()>0 && i>=k && dq.peek()==arr[i-k]) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && dq.peekLast()<arr[i]) {
				dq.removeLast();
			}
			dq.offer(arr[i]);
//			System.out.print(dq);
			if(i>=k-1) {
				
				res[i-k+1]=dq.peek();
			}
		}
		return res;
	}

}
