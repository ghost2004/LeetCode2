/*
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


 */
import java.util.*;
public class Permutations {
    // Insert solution
    public ArrayList<ArrayList<Integer>> perm(int[] num, int start) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();;
        if (start >= num.length-1) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            item.add(num[start]);
            out.add(item);
            return out;
        }
        ArrayList<ArrayList<Integer>> b = perm(num, start+1);
        int size = b.size();
        int len = b.get(0).size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> t = b.get(i);
            for(int j = 0; j <= len;j++) {
                ArrayList<Integer> o = new ArrayList<Integer>(t);
                if (j == len)
                    o.add(num[start]);
                else
                    o.add(j, num[start]);
                out.add(o);
            }
        }
        return out;
    }
    
    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        ArrayList<ArrayList<Integer>> out ;
        Arrays.sort(num);
        
        out = perm(num, 0);
        
        return out;
    }
    
    // DFS solution
    public void permImp(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, boolean[] used, int[] num) {
        if (tmp.size() == num.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int end = tmp.size();
                tmp.add(num[i]);
                permImp(result, tmp, used, num);
                used[i]  = false;
                tmp.remove(end);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean used[] = new boolean [num.length];
        Arrays.sort(num);
        permImp(out, tmp, used, num);
        return out;
    }
}
