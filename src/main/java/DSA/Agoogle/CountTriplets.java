package DSA.Agoogle;

public class CountTriplets {
    //https://chatgpt.com/c/69f4d283-fd94-8320-bdd5-aad952f47c05



    /*
    You are given three sorted arrays A, B, and C, each of size n, and an integer D.
    The task is to count the number of unique tuples (i, j, k)
    where: i is an index in array A, j is an index in array B, k is an index in array C,
    such that the following conditions are satisfied:
    |A[i] - B[j]| ≤ D, |A[i] - C[k]| ≤ D, |B[j] - C[k]| ≤ D
    Input A, B, C: Lists of integers of length n, sorted in non-decreasing order. D: An integer representing the maximum allowable absolute difference.
    Output An integer representing the count of all valid tuples (i, j, k) that satisfy the conditions.

    * */


    public int countTriplets(int[] A, int[] B, int[] C, int D) {

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            //A[i]-B[i]<=D
            int lb = lowerBound(B, A[i] - D);
            int ub = upperBound(B, A[i] + D);

            for (int j = lb; j <ub; j++) {
                //A[i]-C[k] <=D and //B[i]-c[k]<=D
                int lbc= lowerBound(C, Math.max(A[i] - D, B[j] - D));
                int ubc = lowerBound(C, Math.min(A[i] + D, B[j] + D));
                count += (ubc - lbc);

            }
        }
        return count;
    }

    //first index >x
    private int upperBound(int[] b, int x) {
        int l = 0, r = b.length-1;
        int ans = b.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (b[mid] <= x) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }

    //first index >=x
    private int lowerBound(int[] b, int x) {
        int l = 0, r = b.length-1;
        int ans = b.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (b[mid] < x) {

                l = mid + 1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

}
