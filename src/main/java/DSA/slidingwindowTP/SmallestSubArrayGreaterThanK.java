package DSA.slidingwindowTP;

public class SmallestSubArrayGreaterThanK {
    //    Given an array arr[] of integers and a number x, the task is to find the smallest
//    subarray with a sum strictly greater than x.
    public static void main(String[] args) {
        int x = 51;
        int arr[] = {1, 4, 45, 6, 0, 19};
        int length = findSmallestSubArrayGreaterThanK(arr, x);
        System.out.println(length);
    }

    private static int findSmallestSubArrayGreaterThanK(int[] arr, int k) {
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (j < arr.length) {

            sum += arr[j];
            while (sum > k) {
                ans = Math.min(ans, j - i + 1);
                sum -= arr[i];
                i++;
            }
            j++;

        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
