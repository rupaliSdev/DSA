package DSA.slidingwindowTP;

import java.util.HashMap;

public class CountPairsSumDivByK {
    public static void main(String[] args) {

        int A[] = {2, 2, 1, 7, 5, 3}, K = 4;
        System.out.println(countKDiv(A, A.length, K));
        System.out.println(countKDivHashMap(A, A.length, K));


    }

    //https://www.geeksforgeeks.org/dsa/count-pairs-in-array-whose-sum-is-divisible-by-k/
    private static int countKDiv(int[] arr, int length, int k) {

        int[] freq = new int[k];
        for (int a : arr) {
            int rem = a % k;
            if (rem < 0) rem += k;
            freq[rem]++;
        }
        int sum = freq[0] * (freq[0] - 1) / 2;
        int left = 1, right = k - 1;
        while (left <= right) {

            if (left == right) {
                sum += freq[left] * (freq[left] - 1) / 2;
            } else {
                sum += freq[left] * freq[right];
            }
            left++;
            right--;
        }
        return sum;

    }
    //O(n+k) O(k)

    private static int countKDivHashMap(int[] arr, int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, count = 0;
        while (left < n) {
            int rem = arr[left] % k;
            if (rem < 0) rem += k;
            int complement = (k - rem) % k;
            if (map.containsKey(complement)) count += map.get(complement);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            left++;

        }
        return count;

    }

}
