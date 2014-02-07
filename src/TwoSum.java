import java.util.Arrays;

/*
 * Given an array of integers, find two numbers such that they add up 
 * to a specific target number.

The function twoSum should return indices of the two numbers such that
 they add up to the target, where index1 must be less than index2. 
 Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
    private class ArrayNode implements Comparable<ArrayNode>{
        public int idx;
        public int val;
        
        public ArrayNode(int i, int v) {
            this.idx = i;
            this.val = v;
        }
        public int compareTo(ArrayNode n) {
            return this.val - n.val;
        }
    }
    public int[] twoSum(int[] numbers, int target) {

        ArrayNode[] map = new ArrayNode[numbers.length];
        int idx = 0;
        for (int i = 0; i < numbers.length; i++) {
            map[i] = new ArrayNode(i+1, numbers[i]);
        }
        Arrays.sort(map);
        
        int[] out = new int[2];
 
        
        while (idx < numbers.length && map[idx].val <= target) {
            int key = target - map[idx].val;
            int i = -1;
            int lo = idx + 1;
            int hi = numbers.length - 1;
            while (lo <= hi) {
                int t = (lo + hi) / 2;
                if (map[t].val == key) {
                    i = t;
                    break;
                } else if (map[t].val < key) {
                    lo = t + 1;
                } else {
                    hi = t - 1;
                }
            }
            
            if (i != -1) {
                out[0] = Math.min(map[idx].idx, map[i].idx);
                out[1] = Math.max(map[idx].idx, map[i].idx);
            }

            idx++;
        }
        
        return out;
        
    }
    public static void printArray(int[] a) {
        System.out.println(a[0]+" "+a[1]);
    }
    
    
    public  static void main(String[] args) {
        TwoSum c = new TwoSum();
        int[] t3 = {0,4,3,0};
        printArray(c.twoSum(t3, 0));
        
        int[] t2 = {5,75,25};
        printArray(c.twoSum(t2, 100));
        
        int[] t1 = {3, 2, 4};
        printArray(c.twoSum(t1, 6));

    }
}
