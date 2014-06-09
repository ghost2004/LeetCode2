/*
 * Implement next permutation, which rearranges numbers 
 * into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as 
the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and 
its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;
        int cur = num.length - 1;
        while (cur > 0 && num[cur] <= num[cur-1])
            cur--;
        if (cur > 0) {
            cur--;
            int idx = num.length - 1;
            while (idx > cur && num[idx] <= num[cur])
                idx--;
            if (idx !=  cur) {
                int tmp = num[cur];
                num[cur] = num[idx];
                num[idx] = tmp;
            }
            cur++;
        }
        
        int right = num.length - 1;
        
        while (cur < right) {
            int tmp = num[cur];
            num[cur] = num[right];
            num[right] = tmp;
            right--;
            cur++;
        }
    }
    
    public static void prtArray(int num[]) {
        for (int i = 0; i < num.length;i++) 
            System.out.print(num[i]+" ");
        System.out.println();
    }
    
    public static void main(String args[]) {
        NextPermutation n = new NextPermutation();
        int t1[] = {1, 2};
        n.nextPermutation(t1);
        prtArray(t1);
        
    }

}
