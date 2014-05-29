/*
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */
import java.util.*;
public class PermutationsII {
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
                while (i+1 < num.length && num[i] == num[i+1])
                    i++;
            }
        }
    }    
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean used[] = new boolean [num.length];
        Arrays.sort(num);
        permImp(out, tmp, used, num);
        return out;
    }
}
