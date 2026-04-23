package DSA.maths;

import java.util.HashMap;

import static DSA.maths.RecoverArrayFromGCDArray.gcd;


public class CountPairProductDivisibleByK {
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/count-array-pairs-divisible-by-k/submissions/1979700222/
    public long countPairs(int[] nums, int k) {


        HashMap<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcd = gcd(nums[i], k);
            gcdMap.put(gcd, gcdMap.getOrDefault(gcd, 0) + 1);
        }
        long count=0;
        for(int g1 :gcdMap.keySet()){
            for(int g2 :gcdMap.keySet()){

                if((long)g1 * g2 % k ==0){
                    if(g1==g2) {
                        int freq = gcdMap.get(g1);
                        count+= (long)freq * (freq-1) /2;
                    }
                    else if(g1<g2){
                        count +=(long) gcdMap.get(g1) * gcdMap.get(g2) ;
                    }
                }
            }
        }
        return count;
    }
}
