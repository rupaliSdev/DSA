package DSA.problemSolving;

import java.util.Arrays;
import java.util.Scanner;

//Given an integer array A of size N and an integer k, you have to print the same array after rotating it k times towards the right.
public class RotateArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 2;
        //1,2,3,4,5,6,7  k= 4
        //7,6,5,4,3,2,1(reverse)
        //4,5,6,7,1,2,3(reverse 0,k-1) (reverse k,n-1)


        //1,2,3,4,5,6,7   k=4
        //4,3,2,1,7,6,5 (reverse 0,k-1) (reverse k,n-1)
        //5,6,7,1,2,3,4 (reverse 0,n-1)


        //1,2,3,4,5,6,7   k=4
        //7,6,5,4,3,2,1 (reverse 0,n-1)
        //5,6,7,1,2,3,4(reverse 0,n-k-1) (reverse n-k,n-1)

        rotate("right", arr, 2); //i = (i+k)%n
        Arrays.stream(arr).forEach((a)-> System.out.print(a + ","));
        System.out.println();
        rotate("left", arr, 4);//i = (i -k+n)%n
        Arrays.stream(arr).forEach((a)-> System.out.print(a + ","));


    }

    public static void rotate(String dir, int[] arr, int k) {
        int n = arr.length;
        int move = dir.equals("right") ? k : n - k;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, move - 1);
        reverse(arr, move, n - 1);
    }

    public static void reverse(int[] A, int l, int r) {
        while (l <= r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }
}
