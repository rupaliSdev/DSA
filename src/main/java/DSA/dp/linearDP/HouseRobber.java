package DSA.dp.linearDP;

import DSA.Tree.TreeNode;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
       int nums[] = {2, 7, 9, 3, 1};
        System.out.println(robI(nums));
        System.out.println(robII(nums));
    }


    public static int rob(int[] nums) {
        int prevRob = 0;

        int maxRob = 0;
        for (int i =0;i<nums.length;i++){
            int temp =Math.max(prevRob+nums[i],maxRob);
            prevRob=maxRob;
            maxRob=temp;

        }
        return maxRob;
    }

    public static int robI(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0]=nums[0];dp[1]=nums[1];
        for (int i =2;i<nums.length;i++){
            int take = nums[i] + dp[i-2];
            int notake = dp[i-1];
            dp[i]= Math.max(take,notake);

        }
        return dp[nums.length-1];
    }

    //https://leetcode.com/problems/house-robber-ii/description/
    public static int robII(int[] nums) {
        int prevII=0,prevI =nums[0];
        for (int i =1;i<nums.length;i++){
            int take = nums[i] + prevII;
            int notake = prevI;
            prevII = prevI;
            prevI = Math.max(take,notake);

        }
        return prevI;
    }

   // https://leetcode.com/problems/house-robber-iii/description/

    HashMap<TreeNode ,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)return 0;

        if(map.containsKey(root)) return map.get(root);

        int robCurrent = root.val;
        if(root.left!=null){
            robCurrent += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right!=null){
            robCurrent += rob(root.right.left) + rob(root.right.right);
        }

        int skipCurrent = rob(root.left) + rob(root.right);

        int result = Math.max(robCurrent,skipCurrent);
        map.put(root,result);
        return result;

    }
}
