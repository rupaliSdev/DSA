package DSA.Strings.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

//    https://leetcode.com/problems/minimum-window-substring/description/
    public static void main(String[] args) {


       String s=  "ADOBECODEBANC",t ="ABC";
        System.out.println(minWindow(s,t));
        System.out.println(minWindow("cabwefgewcwaefgcf","cae"));
    }


    public static String minWindow(String s, String t) {

        int[] minWin =new int[3];
        minWin[0]= Integer.MAX_VALUE;
        Map<Character , Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        int left=0,right=0;
        for(char c:t.toCharArray())tMap.put(c,tMap.getOrDefault(c,0)+1);
        int formed=0,required = tMap.size();
        while (right<s.length()){
            char rightChar = s.charAt(right);
            sMap.put(rightChar,sMap.getOrDefault(rightChar,0)+1);
            if(tMap.containsKey(rightChar) && sMap.get(rightChar).intValue()==tMap.get(rightChar).intValue()){
                formed++;
            }
            while (formed==required && left<=right){
                if(minWin[0]==-1 || minWin[0]> right-left+1){
                    minWin[0]= right-left+1;
                    minWin[1]= left;minWin[2]=right;
                }

                char leftChar = s.charAt(left);
                left++;
                sMap.put(leftChar,sMap.getOrDefault(leftChar,0)-1);

                if(tMap.containsKey(leftChar) && tMap.get(leftChar).intValue()>sMap.get(leftChar).intValue()){
                    formed--;
                }
            }
         right++;

        }
        return minWin[0]!=Integer.MAX_VALUE?s.substring(minWin[1],minWin[2]+1):"";
    }
}
