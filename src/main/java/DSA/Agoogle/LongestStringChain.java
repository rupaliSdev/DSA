package DSA.Agoogle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    //https://leetcode.com/problems/longest-string-chain/submissions/1994266980/
    public static void main(String[] args) {

     String[] words = {"a","b","ba","bca","bda","bdca"};
     System.out.println(longestStringChain(words));

    }

    //s.substring takes -> O(L)

    public static int longestStringChain(String[] words){
        Arrays.sort(words,(a,b)->a.length()-b.length());

        Map<String,Integer> dp = new HashMap<>();
        int maxLength =1;
        for(String word :words){
            dp.put(word,1);
            for(int j =0;j<word.length();j++){
                String s = word.substring(0,j) + word.substring(j+1);
                if(dp.containsKey(s)){
                    dp.put(word,Math.max(dp.get(word),dp.get(s)+1));
                }
            }
            maxLength= Math.max(maxLength,dp.get(word));

        }
        return maxLength;
    }
}
