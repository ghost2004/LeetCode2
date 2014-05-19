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
            selectSort(b1[i]);
            prtArray(b1[i]);
        }

        
    }
}
