package DSA.problemSolving;

import java.util.Scanner;

//Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.
public class rotateArray {
   
	public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }

        int B = sc.nextInt();
        B=B%N;
        A=reverse(A,0,N-1);
        A=reverse(A,0,B-1);
        A=reverse(A,B,N-1);
        for(int i=0;i<N;i++){
            System.out.print(A[i]+ " ");
        }
    }

    public static int[] reverse(int[] A,int l,int r){
        while(l<=r){
            int temp = A[l];
            A[l]= A[r];
            A[r]=temp;
            l++;
            r--;
        }
    return A;
    }
}
