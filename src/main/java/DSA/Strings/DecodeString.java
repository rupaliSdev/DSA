package DSA.Strings;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> repeated = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                repeated.push(k);
                strings.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder prev = strings.pop();
                StringBuilder sb = new StringBuilder(prev);
                int p = repeated.pop();
                for (int t = 0; t < p; t++) {
                    sb.append(curr);
                }
                curr = sb;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
