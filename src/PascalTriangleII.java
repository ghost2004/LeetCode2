/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.*;
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        
        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(1);
        // rowIndex 0
        if (rowIndex < 1)
            return out;
        // rowIndex 1
        out.add(1);
        if (rowIndex == 1)
            return out;
        
        ArrayList<Integer> last;
        for (int i = 1; i < rowIndex;i++) {
            last = out;
            out = new ArrayList<Integer>();
            out.add(1);
            for (int j = 1; j <= i; j++) {
                out.add(last.get(j-1)+last.get(j));
            }
            out.add(1);
        }
        
        return out;
        
    }
}
