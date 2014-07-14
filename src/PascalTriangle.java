/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.*;

public class PascalTriangle {
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        ArrayList<ArrayList<Integer>> out = new  ArrayList<ArrayList<Integer>>();
        
        if (numRows == 0)
            return out;
        ArrayList<Integer> f = new ArrayList<Integer>();
        f.add(1);
        out.add(f);
        
        for (int i = 1; i < numRows; i++) {
            f = out.get(out.size()-1);
            ArrayList<Integer>  tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
               tmp.add(f.get(j-1)+f.get(j)); 
            }
            tmp.add(1);
            out.add(tmp);
        }
        
        return out;
    }
    
    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(3).toString());
        System.out.println(p.generate(4).toString());
    }

}
