package DSA.greedy.intervals;

import java.util.*;

public class IntervalProblems {


    /*
     *  [a ,b]  [c,d] overlaps only if c<=b && d>=a
     *  2nd interval starts before first ends and 2nd interval ends after the first has started
     *
     *
     *
     *
     *
     * */


    public List<int[]> mergeIntervals(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev[] = intervals.get(0), i = 0, n = intervals.size();
        List<int[]> res = new ArrayList<>();
        while (i < n) {
            int[] curr = intervals.get(1);
            if (curr[0] < prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        return res;
    }

    public List<int[]> insertIntervals(List<int[]> intervals, int[] newInterval) {

        int i = 0, n = intervals.size();
        List<int[]> res = new ArrayList<>();
        //if !(b<=c)
        while (i < n && intervals.get(i)[1] < newInterval[0]) {
            res.add(intervals.get(i));
            i++;
        }
        //  d>=a overlap only be possible if s.start <= f.end if s.end >= f.start

        while (i < n && intervals.get(i)[0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals.get(i)[0]);
            newInterval[1] = Math.max(newInterval[1], intervals.get(i)[1]);
            i++;

        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

    public int countOverLappingIntervals(List<int[]> intervals) {
        int prev[] = intervals.get(0), i = 0, j = 0, n = intervals.size(), count = 0, max = 0;
        int start[] = new int[n], end[] = new int[n];
        for (int k = 0; k < n; k++) {
            start[k] = intervals.get(k)[0];
            end[k] = intervals.get(k)[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                count++;
                max = Math.max(count, max);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return max;
    }


}
