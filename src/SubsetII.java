/*
 * Given a collection of integers that might contain duplicates,
 *  S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
import java.util.*;
public class SubsetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>> ();
        out.add(new ArrayList<Integer>());
        Arrays.sort(S);
        int start = 0;
        for (int i = 0; i < S.length; i++) {
            int size = out.size();
           
            for (int j = start; j < size; j++) {
                ArrayList<Integer> n = new ArrayList<Integer>(out.get(j));
                n.add(S[i]);
                out.add(n);
            }
            
            if (i < S.length-1 && S[i] == S[i+1])
                start = size;
            else 
                start = 0;
        }
        
        return out;
    }
    public static void prtArrList(ArrayList<ArrayList<Integer>>  in) {
        for (int i = 0; i < in.size(); i++) {
            int s = in.get(i).size();
            for (int j = 0; j < s; j++)
                System.out.print(in.get(i).get(j)+ " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SubsetII s = new SubsetII();
        int[] t1 = {0};
        prtArrList(s.subsetsWithDup(t1));
    }

}
