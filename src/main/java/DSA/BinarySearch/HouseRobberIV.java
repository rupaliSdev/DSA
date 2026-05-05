package DSA.BinarySearch;

public class HouseRobberIV {

    public int minCapability(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= cap) {
                count++;
                i++; // skip adjacent
            }
        }

        return count >= k;
    }
}
