package DSA.stack;

import java.util.Stack;

public class LargestRectangeInHistogram {
    public static void main(String[] args) {

    }

    public int largestRectangleAreaBF(int[] heights) {
      int max_rectangle=0;
      for(int i =0;i<heights.length;i++){
          int l =i,r=i;

          while(l>=0 && heights[i]<=heights[l]){
              l--;
          }
          while(r<heights.length && heights[i]<=heights[r]){
              r++;
          }
          max_rectangle=Math.max(max_rectangle,heights[i]*(r-l-1));
      }
      return  max_rectangle;

    }

    public int largestRectangleArea(int[] heights) {
        int max_rectangle=0;
        Stack<Integer> stack= new Stack<>();
        for(int i =0;i<=heights.length;i++){
            int curr = (i==heights.length)?0 :heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]>curr){
                int x = stack.pop();
                int width;
                //no smaller element on left side// x was the smallest possible
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;

                max_rectangle=Math.max(max_rectangle,heights[x]*width);

            }
            stack.push(i);

        }
        return  max_rectangle;
    }


}
