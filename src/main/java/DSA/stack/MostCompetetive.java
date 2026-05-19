package DSA.stack;

import java.util.Arrays;
import java.util.Stack;

public class MostCompetetive {
    public static void main(String[] args) {
        Arrays.stream(mostCompetitive(new int[]{71,18,52,29,55,73,24,42,66,8,80,2},3)).forEach(System.out::println);
    }

    public static int[] mostCompetitive(int[] nums, int k) {

        int i = 0,n=nums.length;
        int[] ans = new int[k];
        Stack<Integer> st = new Stack<>();
        while (i <nums.length) {
            int c = nums[i];
            while (!st.isEmpty() && st.size() +n-i-1 >= k && st.peek() > c) {
                st.pop();
            }
            if(st.size()<k)st.push(c);
            i++;
        }
        int p=k-1;
        while (!st.isEmpty()) {
            ans[p--]=st.pop();
        }

        return ans;
    }
}
