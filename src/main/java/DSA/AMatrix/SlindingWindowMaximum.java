package DSA.AMatrix;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlindingWindowMaximum {

    /*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Test Cases:

[1,3,-1,-3,-5,3,6,7]

[3,3,5,5,6,7]

 deque 1,3 -1 -3
  */
    public static void main(String[] args) {

        int[] test = new int[]{1, 3, -1, -3, -5, 3, 6, 7};
        int[] res = maxSlidingWindowI(test, 3);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int[] maxSlidingWindowI(int[] nums,int k){
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int index= 0;

        for (int i =0;i<nums.length;i++){


            while (!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }


            while (!deque.isEmpty() && nums[deque.peekFirst()]<nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);
            if(i>=k-1 && !deque.isEmpty()){
                res[index++]= nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
