package DSA.stack;


import java.util.Stack;

class peakPattern {


    public static void main(String[] args) {
        int[] arr = {1, 0, 1, -4, -3};
        int[] arr1 = {3,5,0,3,4};
        System.out.println(find132pattern(arr1));
        System.out.println(find132pattern(arr));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> st = new Stack<>();

        int x=Integer.MIN_VALUE;
        for(int i =nums.length-1;i>=0 ;i--){

            if(x>nums[i]){
                return true;
            }

            while(!st.isEmpty() && st.peek()<nums[i]){
                x = st.pop();
            }

            st.push(nums[i]);

        }
        return false;
    }
}

