package DSA.stack;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("9", 1));
        System.out.println(returnKdigitsLargestSubSequence("142857", 2));
    }

    public static String removeKdigits(String num, int k) {

        int discards = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        while (i < num.length()) {
            char c = num.charAt(i);
            while (discards < k && !st.isEmpty() && st.peek() > c) {
                st.pop();
                discards++;
            }
            st.push(c);
            i++;

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        if (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();
    }

    public static String returnKdigitsLargestSubSequence(String num, int k) {

        int i = num.length() - 1;
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        while (i >= 0) {
            char c = num.charAt(i);
            while (st.size() >= k && st.peek() < c) {
                st.pop();
            }
            st.push(c);
            i--;
        }
        while (st.size() > k) {
            st.pop();
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        if (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();
    }
}
