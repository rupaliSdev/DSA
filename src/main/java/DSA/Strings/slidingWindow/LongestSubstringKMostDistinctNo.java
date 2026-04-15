package DSA.Strings.slidingWindow;

import java.util.HashMap;

public class LongestSubstringKMostDistinctNo {

    //    https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
    public static void main(String[] args) {

        LongestSubstringKMostDistinctNo solutions = new LongestSubstringKMostDistinctNo();
        String s = "eceba";
        int k = 2;
        System.out.println(solutions.lengthOfLongestSubstringExactlyKDistinct(s, k));

    }

    public int lengthOfLongestSubstringExactlyKDistinct(String s, int k) {
        int left = 0, right = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int maxLen = 0;
        while (right < s.length()) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            while (count.size() > k) {
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                if (count.get(s.charAt(left)) == 0) count.remove(s.charAt(left));
                left++;
            }
            if (count.size() == k) maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen == 0 ? -1 : maxLen;
    }
}
//TC:o(n)
//sc: o(n)