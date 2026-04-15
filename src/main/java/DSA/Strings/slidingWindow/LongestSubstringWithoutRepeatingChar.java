package DSA.Strings.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {

       // https://leetcode.com/problems/longest-substring-without-repeating-characters/
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println();

    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxLen = Math.max(maxLen, j - i + 1);
            j++;

        }
        return maxLen;
    }

    //TC:o(n)
    //sc:o(n)

    public static int lengthOfLongestSubstringHM(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char rightChar=s.charAt(right);
            if(map.containsKey(rightChar)) {
                left = Math.max(left,map.get(rightChar)+1);

            }
            map.put(rightChar,right);
            maxLen = Math.max(maxLen, right-left + 1);
            right++;

        }
        return maxLen;
    }
}
