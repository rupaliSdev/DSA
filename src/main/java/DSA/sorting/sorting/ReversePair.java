package DSA.sorting.sorting;

public class ReversePair {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    public static int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);


    }


    public static int mergeSort(int[] nums, int s, int e) {
        if (s == e) {
            return 0;
        }
        int mid = (s + e) / 2;
        int count = 0;
        count += mergeSort(nums, s, mid);
        count += mergeSort(nums, mid + 1, e);
        count += countMerge(nums, s, mid, e);
        return count;
    }

    public static int countMerge(int[] nums, int s, int mid, int e) {
        int i = s, j = mid + 1;
        int count = 0;
        while (i <= mid && j <= e) {
            while ((long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        int[] temp = new int[e - s + 1];
        int l = s, r = mid + 1, k = 0;
        while (l <= mid && r <= e) {
            if (nums[l] <= nums[r]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = nums[l++];
        }
        while (r <= e) {
            temp[k++] = nums[r++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[s + p] = temp[p];
        }

        return count;
    }

}
