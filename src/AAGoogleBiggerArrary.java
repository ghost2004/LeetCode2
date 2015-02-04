/*
 * Given an array of integer, print out the number of elements in right sub-array that bigger than this one
 * 
 * For example input is [4, 1, 0, 2], output should be [0, 1, 1, 0]
 */
public class AAGoogleBiggerArrary {
    
    /*
     * Binary search tree solution
     * Scan the array from right to left, build a binary search tree
     * Two additional counters in each node
     * bigger_cnt stands for the numbers of elements in array bigger or equals than current value
     * duplicate_cnt stands for the numbers of duplicated current value in this array
     */
    private class BTNode {
        public int val;
        public int bigger_cnt;
        public int duplicate_cnt;
        public BTNode left;
        public BTNode right;
        public BTNode (int v) {
            this.val = v;
            this.left = null;
            this.right = null;
            this.bigger_cnt = 1;
            this.duplicate_cnt = 0;
        }
        
    }
    
    private int insertBTree(BTNode root, int ele) {
        BTNode cur = root;
        int cnt = 0;    // counter for all the element bigger than this value

        while (cur != null) {
            if (ele > cur.val) {
                // greater than current node, 
                // increase bigger counter and go to right sub-tree
                cur.bigger_cnt++;
                if (cur.right == null) {
                    cur.right = new BTNode(ele);
                    break;
                } else {
                    cur = cur.right;
                }                    
            } else if (ele < cur.val) {
                // less than current node
                // add total counter for this element and go to left sub-tree
                cnt += cur.bigger_cnt;
                if (cur.left == null) {
                    cur.left = new BTNode(ele);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                // duplicate value
                // Step 1, increase duplicate counter
                // Step 2, add total counter (bigger minus duplicate)
                // Step 3, increase bigger counter
                cur.duplicate_cnt++;
                cnt += cur.bigger_cnt-cur.duplicate_cnt;
                cur.bigger_cnt++;
                break;
            }
        }
        
        return cnt;
        
    }
    
    public int[] getBiggerArray2(int array[]) {
        int length = array.length;
        int i;
        int out[] = new int[length];
        out[length-1] = 0;
        BTNode root = new BTNode(array[length-1]);
        
        for (i = length-2; i >= 0; i--) {
            out[i] = insertBTree(root, array[i]);
        }
        
        return out;
        
    }
    
    public void printArray(int array[]) {
        for (int i = 0; i < array.length; i ++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    
    /** dummy solution, scan from right to left **/
    
    public int[] getBiggerArray(int array[]) {
        int out[] = new int[array.length];
        int rightMax[] = new int[array.length];
        
        int i;
        
        out[array.length-1] = 0;
        rightMax[array.length-1] = array[array.length-1];
        
        for (i = array.length-2; i >= 0; i--) {
            if (array[i] >= rightMax[i+1]) {
                out[i] = 0;
                rightMax[i] = array[i];
            } else {
                int idx = i+1;
                int cnt = 0;
                while (idx < array.length && rightMax[idx] > array[i]) {
                    if (array[idx] > array[i]) {
                        cnt ++;
                    } else if (array[idx] == array[i]) {
                        cnt += out[idx];
                        break;
                    }
                    idx++;
                }
                out[i] = cnt;
                rightMax[i] = rightMax[i+1];
            }
        }
        
        return out;
    }
    
    public static void main(String args[]) {
        AAGoogleBiggerArrary b = new AAGoogleBiggerArrary();
        int a1[] = { 1,3,5};
        int a2[] = { 5,3,1};
        int a3[] = {4, 1, 0, 2};
        int a4[] = {0};
        int a5[] = {1,2};
        int a6[] = {1, 32,4,1,6,45,3,7,32,8,10,9};
        int a7[] = {1, 32, 32,32};
        System.out.println("Phase 1 test: dummy solution");
        b.printArray(b.getBiggerArray(a1));
        b.printArray(b.getBiggerArray(a2));
        b.printArray(b.getBiggerArray(a3));
        b.printArray(b.getBiggerArray(a4));
        b.printArray(b.getBiggerArray(a5));
        b.printArray(b.getBiggerArray(a6));
        b.printArray(b.getBiggerArray(a7));
        System.out.println("Phase 2 test: BST solution");
        b.printArray(b.getBiggerArray2(a1));
        b.printArray(b.getBiggerArray2(a2));
        b.printArray(b.getBiggerArray2(a3));
        b.printArray(b.getBiggerArray2(a4));
        b.printArray(b.getBiggerArray2(a5));
        b.printArray(b.getBiggerArray2(a6));
        b.printArray(b.getBiggerArray2(a7));
    }

}
