/*
 * Given a set of non-overlapping intervals, insert a new 
 * interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted 
according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as
 [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
 in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
import java.util.*;
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> out = new ArrayList<Interval>();
        
        if (newInterval == null) {
            return intervals;
        } else if (intervals == null || intervals.size() == 0) {
            out.add(newInterval);
            return out;
        }
        
        int len = intervals.size();
        Interval n = new Interval(newInterval.start, newInterval.end);

        int i = 0;
        while (i < len) {
            Interval p = intervals.get(i);
            if (p.end < n.start) {
                // left of new interval
                out.add(p);
            } else if (p.start > n.end) {
                // right of new interval
                out.add(n);
                n = p;
            } else {
                // Merge the overlap
                n.start = Math.min(n.start, p.start);
                n.end = Math.max(n.end, p.end);
            }
            i++;
        }

        out.add(n);
            
        return out;
    }

}
