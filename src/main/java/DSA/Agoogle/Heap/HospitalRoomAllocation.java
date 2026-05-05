package DSA.Agoogle.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HospitalRoomAllocation {

    /*Problem Statement:
There is a Hospital which contain N rooms from 1 to N -1. There is a Queue of Patients outside the Hospital. Each patient will be served in a single room and each patient has a time duration that it will take for the treatment. The rooms are allocated to patients by the lowest index (if the room is free). Initially room1 will be given to the patient, then if the 2nd patient comes and the 1st room is still busy, then the room2 will be given to the 2nd patient. now suppose the 1st patient treatment is completed, and the room1 is free now, and a new patient comes, then room1 will be given to the new patient. Each Patient has a start time also (Consider this as appointment time for him, it needs not to be a time format, use Integer for this).

The patients standing in the queue are in non decreasing order of their start time. means if the first patient start time = 1, then the second patient start time will be >= 1. Now the rooms will be allocated to each patients one by one. we have to calculate that by the end when all the patients are treatment done, Which is the room in which the maximum no of patients have been entered?

Example:
if N = 2 rooms, and the patients are = 3, which are below

 patient-1 = {start: 1, duration: 8}
 patient-2 = {start: 1, duration: 2}
 patient-3 = {start: 6, duration: 4}
Now first patient will be assigned to room-1, second patient comes at the same time he will be allocated to room-2, now after time 2, room-2 will become free, but patient 3 will come at time 6 and at that time he will be allocated to room-2 as well. so finally room-2 is the room in which the max number of patients have entered.*/
    public static void main(String[] args) {

    }

    public int mostUsedRoom(int n, int[][] patients) {
        Arrays.sort(patients, (a, b) -> a[0] - b[0]);

        // free rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.add(i);

        // busy rooms -> {endTime, roomNumber}
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] p : patients) {
            int start = p[0];
            int duration = p[1];

            // free up rooms
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int room = (int) busyRooms.poll()[1];
                freeRooms.add(room);
            }

            int room;
            long endTime;

            if (!freeRooms.isEmpty()) {
                // assign immediately
                room = freeRooms.poll();
                endTime = start + duration;
            } else {
                // wait → take earliest finishing room
                long[] earliest = busyRooms.poll();
                room = (int) earliest[1];
                endTime = earliest[0] + duration;
            }

            busyRooms.add(new long[]{endTime, room});
            count[room]++;
        }

        // find max used room
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }


}
