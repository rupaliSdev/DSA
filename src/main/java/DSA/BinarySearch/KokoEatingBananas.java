package DSA.BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr= {3,6,7,11};
        System.out.println(minEatingSpeed(arr,8));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans =-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if(isValid(piles,h,mid)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid +1;
            }
        }
        return ans;

    }
    public static boolean isValid(int[] piles,int h , int speed){
        int hour =0;
        for(int i =0;i<piles.length;i++){
            hour+= Math.ceil((double)piles[i]/speed);
            if(hour>h){
                return false;
            }
        }
        return true;
    }
}
