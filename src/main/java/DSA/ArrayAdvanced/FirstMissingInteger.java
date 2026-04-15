package DSA.ArrayAdvanced;

public class FirstMissingInteger {

    public static void main(String[] args) {

        //https://leetcode.com/problems/first-missing-positive/description/
        System.out.println(firstMissingPositive(new int[]{-1,4,2,1,9,10}));

    }

    private static int firstMissingPositive(int[] A) {
        int n = A.length,i=0;
        while (i < n) {
            if (A[i] >= n || A[i] <= 0 || A[i] == i + 1 || A[i] == A[A[i] - 1]) {
                i++;continue;
            }
            int temp = A[i], j = A[i] - 1;
            A[i] = A[j];
            A[j] = temp;
        }
        for (int k = 0; k < n; k++) {
            if (A[k] != k + 1) {
                return k + 1;
            }
        }

        return n + 1;
    }


}

