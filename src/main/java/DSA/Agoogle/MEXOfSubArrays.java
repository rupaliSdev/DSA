package DSA.Agoogle;

import java.util.Arrays;

public class MEXOfSubArrays {

    //https://www.perplexity.ai/search/35991c05-526c-4df0-8291-3a993433e692?sm=d
    //https://chatgpt.com/c/69f58043-bd58-8320-bc95-3a03982a27d0


    /*Define the MEX of an array to be the minimum non negative integer that is not contained in that array. for ex. [1,2,3] => 0
Given an array of length n that contains unique integer from 0 to n-1, return an array of length n+1 where array[i] = the number of contiguous subarray of arr such that mex(subarray) = i
For ex. if arr = [3,0,2,1] output = [4,4,0,1,1]
(four subarrays have mex 0, four subarray have mex 1 and so on.)
please explain and write brute force and optimised sol in java explain properly*/
    public static void main(String[] args) {
        long[] res = findMexArrayCount(new int[]{3, 0, 2, 1});
        Arrays.stream(res).forEach(System.out::println);


        /* smallest missing
         * [3]     mex = 0
         * [3,0]   mex = 1
         * [3,0,2] mex = 1
         * [3,0,2,1] mex = 4
         * [0] mex = 1
         * [0,2] mex = 1
         * [0,2,1] mex = 3
         * [2] mex = 0
         * [2,1] mex = 0
         * [1] mex = 0
         * */
    }

    public static long[] findMexArrayCount(int[] arr) {
        int n = arr.length;
        int[] pos = new int[n + 1];
        long[] res = new long[n + 1];

        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }


        //Arrays.stream(pos).forEach(System.out::println);
        //MEX =0
        long totalSubArrays = 1L * (n * (n + 1)) / 2;
        int p0 = pos[0];
        if (pos[0] != -1) {

            long left = p0;
            long right = n - p0 - 1; // excluding (p0+1) elements including 0
            res[0] = (left * (left + 1) / 2) + (right * (right + 1) / 2);
        } else {
            res[0] = totalSubArrays;
        }
        int left = p0, right = p0;
        for (int k = 1; k <= n; k++) {

            if (pos[k - 1] != -1) {
                if (pos[k - 1] < left) left = pos[k - 1];
                if (pos[k - 1] > right) right = pos[k - 1];
            }
            long totalContainingLR = 1L * (left + 1) * (n - right);
            long invalid = 0;
            if (k < n) {

                if (pos[k] >= left && pos[k] <= right) {
                    res[k] = 0;
                    continue;
                } else if (pos[k] < left) {
                    invalid = 1L * (pos[k] + 1) * (n - right);
                } else {
                    invalid = 1L * (left + 1) * (n - pos[k]);
                }
            }
            long valid = totalContainingLR - invalid;

            if (valid >= 0) {
                res[k] = valid;
            }
        }
        return res;


    }
}
