package DSA.Agoogle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfVisiblePoints {

    //https://leetcode.com/problems/maximum-number-of-visible-points/description/
    public static void main(String[] args) {
        List<List<Integer>> points = List.of(
                List.of(2, 1),
                List.of(2, 2),
                List.of(3, 3)
        );

        System.out.println(visiblePoints(points, 90, List.of(1, 1)));
    }
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();

        int sameLocationCount = 0;
        int locX = location.get(0), locY = location.get(1);

        for (List<Integer> point : points) {
            int pointX = point.get(0);
            int pointY = point.get(1);
            if (pointX == locX && pointY == locY) {
                sameLocationCount++;

            } else {
                double angleRadians = Math.atan2(pointY - locY,pointX - locX);
                angles.add(angleRadians);
            }
        }

        Collections.sort(angles);
        int size =angles.size();
        for (int i=0;i<size;i++){
            angles.add(2 * Math.PI + angles.get(i));
        }
        double viewingAngleInRadians = angle * Math.PI/180;

        int maxVisiblePoints =0;
        int left =0;
        for(int right =0 ;right< 2*size;right++){
            while (left<right && angles.get(right)-angles.get(left)>viewingAngleInRadians){
                left++;
            }

            maxVisiblePoints = Math.max(maxVisiblePoints,right-left+1);
        }

        return maxVisiblePoints+sameLocationCount;
    }
}
