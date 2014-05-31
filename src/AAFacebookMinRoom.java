/*
 * We have a list of scheduled meetings with begin and end time
 * return the minimal numbers of conference room which can hold
 * those meetings
 * 
 */
import java.util.*;
public class AAFacebookMinRoom {

    private class TimeStamp implements Comparable<TimeStamp> {
        public int timestamp;
        public boolean endFlag;
        public TimeStamp(int t, boolean f) {
            timestamp = t;
            endFlag = f;
        }
        public int compareTo(TimeStamp n) {
            return this.timestamp - n.timestamp;
        }
    }
    public int minRooms(Interval intervals[]) {
        if (intervals == null || intervals.length == 0)
            return 0;
        int maxD = 0;
        int curD = 0;
        if (intervals.length == 1)
            return 1;
        int i;
        TimeStamp timestamps[] = new TimeStamp[intervals.length*2];
        for (i = 0; i < intervals.length; i++) {
            timestamps[2*i] = new TimeStamp(intervals[i].start, false);
            timestamps[2*i+1] = new TimeStamp(intervals[i].end, true);
        }
        
        Arrays.sort(timestamps);

        // Actually we don't care the last item, but just leave it there
        for (i = 0; i < timestamps.length; i++) {
            if (timestamps[i].endFlag) {
                curD--;
            } else {
                curD++;
                maxD = Math.max(maxD, curD);
            }
        }
        
        return maxD;
    }
    
    
    public static void main(String args[]) {
        AAFacebookMinRoom f = new AAFacebookMinRoom();
        int case1_start[] = {1, 2, 5};
        int case1_end[] = {10, 4, 9};
        int case2_start[] = {1, 2, 3, 8};
        int case2_end[] = {10, 4, 6, 9};
        int case3_start[] = {1, 2, 5, 8};
        int case3_end[] = {2, 4, 6, 9};
        Interval it[] = Interval.getFromArray(case1_start, case1_end);
        System.out.println(f.minRooms(it));
        it = Interval.getFromArray(case2_start, case2_end);
        System.out.println(f.minRooms(it));
        it = Interval.getFromArray(case3_start, case3_end);
        System.out.println(f.minRooms(it));
    }
    
}
