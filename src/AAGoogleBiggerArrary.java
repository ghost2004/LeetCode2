/*
 * Given an array of integer, print out the number of elements in right sub-array that bigger than this one
 * 
 * For example input is [4, 1, 0, 2], output should be [0, 1, 1, 0]
 */
public class AAGoogleBiggerArrary {
    
    public void printArray(int array[]) {
        for (int i = 0; i < array.length; i ++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    
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

        b.printArray(b.getBiggerArray(a1));
        b.printArray(b.getBiggerArray(a2));
        b.printArray(b.getBiggerArray(a3));
        b.printArray(b.getBiggerArray(a4));
        b.printArray(b.getBiggerArray(a5));
        b.printArray(b.getBiggerArray(a6));
    }

}
