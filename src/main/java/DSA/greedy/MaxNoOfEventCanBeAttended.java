package DSA.greedy;

import java.util.*;

public class MaxNoOfEventCanBeAttended {

    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
    public static void main(String[] args) {
        int[][] events = {{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}};

        System.out.println(maxNoOfEvents(events));
    }

    private static int maxNoOfEvents(int[][] events) {

        int noDay = 0, n = events.length;
        int ans = 0;
        for (int[] event : events) {
            noDay = Math.max(noDay, event[1]);
        }
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1, j = 0; i <= noDay; i++) {

            while (j < n && events[j][0] <= i) {
                priorityQueue.offer(events[j][1]);
                j++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek() < i) {
                priorityQueue.poll();
            }

            if (!priorityQueue.isEmpty()) {
                priorityQueue.poll();
                ans++;
            }


        }
        return ans;
    }

    public static int maxEvents(int[] firstDay, int[] lastDay) {
        int n = firstDay.length;
        // Create list of intervals (start, end)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{firstDay[i], lastDay[i]});
        }
        // Sort by end time
        meetings.sort(Comparator.comparingInt(a -> a[1]));
        Set<Integer> bookedDays = new HashSet<>();
        int maxCount = 0;
        for (int[] meeting : meetings) {
            for (int day = meeting[0]; day <= meeting[1]; day++) {
                if (!bookedDays.contains(day)) {
                    bookedDays.add(day);
                    maxCount++;
                    break;
                }
            }
        }
        return maxCount;
    }


    public static int maxMeetingsII(int[] firstDay, int[] lastDay) {
        int n = firstDay.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = firstDay[i];
            meetings[i][1] = lastDay[i];
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int maxCount = 0, day = 0;
        for (int i = 0; i < firstDay.length; i++) {
            day = Math.max(day, meetings[i][0]);
            //check whether valid or not
            if (day <= meetings[i][1]) {
                maxCount++;
                day++;
            }
        }
        return maxCount;
    }


}
