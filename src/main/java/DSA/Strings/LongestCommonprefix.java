package DSA.Strings;

import java.util.Arrays;

public class LongestCommonprefix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static String longestCommonPrefix(String[] strings) {
        Arrays.sort(strings);
        String firstString = strings[0];
        String lastString = strings[strings.length - 1];
        String lcp = "";
        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) != lastString.charAt(i)) {
                break;
            }
            lcp += firstString.charAt(i);

        }
        return lcp;
    }
}
