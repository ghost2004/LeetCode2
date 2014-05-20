/*
 *  Sorting algorithms
 */
public class AlgorithmSorting {

    public static void insertSort(int data[]){
        int N = data.length;
        
        for (int i = 0 ; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j-1]) {
                    int tmp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = tmp;
                } else
                    break;
                
            }
        }
    }
    
    public static void selectSort(int data[]) {
        int N = data.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (data[j] < data[min])
                    min = j;
            }
            if (min != i ) {
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
    }
    
    public static void merge(int data[], int aux[], int lo,int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = data[i];
        
        int idx1 = lo;
        int idx2 = mid+1;
        
        for (int i = lo; i <= hi; i++) {
            if (idx1 > mid) 
                data[i] = aux[idx2++];
            else if (idx2 > hi)
                data[i] = aux[idx1++];
            else if (aux[idx1] < aux[idx2])
                data[i] = aux[idx1++];
            else
                data[i] = aux[idx2++];
        }
    }
    
    public static void mSort(int data[], int aux[],int lo, int hi ) {
        if (hi <= lo)
            return;
        int mid = (hi + lo)/2;
        
        mSort(data, aux, lo, mid);
        mSort(data, aux, mid+1, hi);
        merge(data, aux, lo, mid, hi);
        
    }
    
    public static void mergeSort(int data[]) {
        int aux[] = new int[data.length];
        mSort(data, aux, 0, data.length-1);
        
    }
    
    
    public static int partition(int data[], int lo, int hi) {
        
        int p1 = lo;
        int p2 = hi;
        
        int key = data[lo];
        
        while (p1 < p2) {

        }
        
        return p2;
        
    }
    
    public static void qSort(int data[], int lo, int hi) {
        if (hi <= lo )
            return;
        
        int idx = partition(data, lo, hi);
        qSort(data, lo, idx-1);
        qSort(data, idx+1, hi);
        
        
    }
    public static void quickSort(int data[]) {
        qSort(data, 0, data.length-1);
    }
    
    
    public static void prtArray(int data[]) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < data.length; i ++) {
            b.append(data[i]);
            b.append(" ");
        }
        System.out.println(b.toString());
            
    }
    
    public static void main(String args[]) {
        int a1[] = {1};
        int a2[] = {3,2,1};
        int a3[] = {1,1,1};
        
        insertSort(a1);
        prtArray(a1);
        insertSort(a2);
        prtArray(a2);
        insertSort(a3);
        prtArray(a3);
        
        int b1[][] = { {0,1,2,3,4,5,6,7,8,9},
                {9,8,7,6,5,4,3,2,1,0},
                {5,6,7,1,2,3,4,0,9,4},
                {7,5,6,3,2,8,0,9,4,1}};
        
        for (int i = 0; i < b1.length; i++) {
            mergeSort(b1[i]);
            prtArray(b1[i]);
        }

        
    }
}
