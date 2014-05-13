import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such 
 * that the sum is closest to a given number, target. Return the 
 * sum of the three integers. You may assume that each input would 
 * have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length == 0)
            return Integer.MAX_VALUE;
        
        if (num.length == 1) 
            return num[0];
        else if (num.length == 2) 
            return num[1]+num[2];
        
        int min = Integer.MAX_VALUE;
        int out = 0;
        Arrays.sort(num);
        
        for (int i = 0; i < num.length-2; i++) {
            int start = i+1;
            int end = num.length - 1;
            while (start < end) {
                int key = num[i] + num[start] + num[end];
                if (Math.abs(key-target) < min) {
                    out = key;
                    min = Math.abs(key-target);
                }
                    
                
                
                if (key > target) 
                    end--;
                else 
                    start++;
                
            }
        }
        
        return out;
        
    }
    
    public static void main(String args[]) {
        int t1[]= {0,2,1,-3};
        int t2[]={1,1,-1,-1,3};
        ThreeSumClosest s = new ThreeSumClosest();
        System.out.println(s.threeSumClosest(t1, 1));
        System.out.println(s.threeSumClosest(t2, -1));
    }
}
