/*
 * Given an array S of n integers, are there elements a, b, c in S such
 *  that a + b + c = 0? Find all unique triplets in the array which gives
 *   the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return out;
        Arrays.sort(num);
        int current = num[0];
        for (int i = 0; i < num.length-2;i++) {
            if (num[i] > 0) 
                break;
            int c1 = Integer.MIN_VALUE;
            int c2 = Integer.MIN_VALUE;
            if (i == 0 || num[i] != current) {
                int key = -num[i];
                int start = i+1;
                int end = num.length-1;
                while (start < end) {
                    int r = num[start] + num[end];
                    if (r == key && c1 != num[start] && c2 != num[end]) {
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        result.add(num[i]);
                        result.add(num[start]);
                        result.add(num[end]);
                        out.add(result);
                        c1 = num[start];
                        c2 = num[end];
                        start ++;
                        end --;
                    }  else {
                        if (r < key) {
                            start++;
                        } else {
                            end--;
                        }
                    }
                }
            }
            current = num[i];
        }
        return out;
    }
}
