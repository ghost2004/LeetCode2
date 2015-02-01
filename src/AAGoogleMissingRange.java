/*
 *  Given a number N and a sorted array of integers, find out all the missing numbers in N range
 *  For example N = 5, array = {1,3}
 *  Output should be 2, 4-5
 */
import java.util.*;
public class AAGoogleMissingRange {
   private class Range {
       int start;
       int end;
   }
   
   public void printRange (ArrayList<Range> in) {
       if (in == null || in.size() == 0)
           return;
       
       Iterator<Range> it = in.iterator();
       
       while (it.hasNext()) {
           Range r= it.next();
           if (r.start == r.end)
               System.out.print(r.start);
           else
               System.out.print(r.start+"-"+r.end);
           if (it.hasNext())
               System.out.print(", ");
       }
       
       System.out.println();
   }
    
   public ArrayList<Range> missingRange(int N, int[] array) {
       ArrayList<Range> out = new ArrayList<Range>();
       Range range;
       if (N == 0)
           return out;
       if (array == null || array.length == 0) {
           range = new Range();
           range.start = 1;
           range.end = N;
           out.add(range);
           return out;
       }
           
       int idx = 0;
       int expect = 1;
       
       while (idx < array.length) {
           if (array[idx] != expect) {
               range = new Range();
               range.start = expect;
               range.end = array[idx] -1;
               expect = array[idx] + 1;
               out.add(range);
               
           } else {
               expect++;
           }
           idx++;
       }
       
       if (expect <= N) {
           range = new Range();
           range.start = expect;
           range.end = N;
           out.add(range);
       }
       
       return out;
   }
    
    public static void main(String args[]) {
        AAGoogleMissingRange m = new AAGoogleMissingRange();
        int a1[] = { 1,3,5};
        int a2[] = {1};
        int a3[] = {5};
        int a4[] = {1,2,3,4,5};
        int a5[] = {1,3};
        int a6[] = {1,2,3};
        
        m.printRange(m.missingRange(5, a1));
        m.printRange(m.missingRange(5, a2));
        m.printRange(m.missingRange(5, a3));
        m.printRange(m.missingRange(5, a4));
        m.printRange(m.missingRange(5, a5));
        m.printRange(m.missingRange(5, a6));
        
        
    }

}
