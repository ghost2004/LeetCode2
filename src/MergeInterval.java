/*
 * Given a collection of intervals, merge all 
 * overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
import java.util.*;
public class MergeInterval {
    
    static final Comparator<Interval> Int_compare = new Comparator<Interval>(){
        public int compare(Interval i, Interval j){
            return new Integer(i.start).compareTo(new Integer(j.start));
        }
    };
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() < 2)
            return intervals;
        
        int len = intervals.size();
        
        Collections.sort(intervals, Int_compare);
        
        Interval intval = intervals.get(0);
        
        int start = intval.start;
        int end = intval.end;
        
        for (int i = 1; i < len; i++) {
            intval =  intervals.get(i);
            
            if (intval.start > end) {
                Interval t = new Interval(start, end);
                result.add(t);
                start = intval.start;
                end = intval.end;
            } else {
                end = Math.max(end, intval.end);
            }
            
        }
        Interval t = new Interval(start, end);
        result.add(t);
        return result;
    }
}
