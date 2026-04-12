package DSA.stack;

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {1,4,5,2,10,8,2};
//		int[] NSE = nearestSmallerElement(arr);
//		int[] INSE = InearestSmallerElement(arr);
		int[] NGE = nextGreaterElement(arr);
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(NSE[i] + "index"+INSE[i]);
//		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(NGE[i] );
		}
	}

	private static int[] nextGreaterElement(int[] arr) {
		// TODO Auto-generated method stub
        Stack<Integer> st = new Stack<>();
		int n = arr.length;
		int[] nge = new int[arr.length];
		nge[n-1]=-1;
		st.push(arr[n-1]);
		for(int i=n-2;i>=0;i--) {
			while(!st.isEmpty() && st.peek()<=arr[i]) {
				st.pop();
				
			}
			if(st.isEmpty()) {
				nge[i]= -1;
				st.push(arr[i]);
			}
			else {
				nge[i]= st.peek();
				st.push(arr[i]);
			}
		}
		return nge;
	}

	private static int[] InearestSmallerElement(int[] arr) {
		
        Stack<Integer> st = new Stack<>();
		
		int[] nse = new int[arr.length];
		nse[0]=-1;
		st.push(0);
		for(int i=1;i<arr.length;i++) {
			while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
				st.pop();
				
			}
			if(st.isEmpty()) {
				nse[i]= -1;
				st.push(i);
			}
			else {
				nse[i]= st.peek();
				st.push(i);
			}
		}
		return nse;
	}

	private static int[] nearestSmallerElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		
		int[] nse = new int[arr.length];
		nse[0]=-1;
		st.push(arr[0]);
		for(int i=1;i<arr.length;i++) {
			while(!st.isEmpty() && st.peek()>=arr[i]) {
				st.pop();
				
			}
			if(st.isEmpty()) {
				nse[i]= -1;
				st.push(arr[i]);
			}
			else {
				nse[i]= st.peek();
				st.push(arr[i]);
			}
		}
		return nse;
	}
	
	

}
