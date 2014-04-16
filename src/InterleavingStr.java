/*
 * Given s1, s2, s3, find whether s3 is formed by 
 * the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class InterleavingStr {
    
    String in1;
    String in2;
    String out;
    
    public boolean checkInterLeave(int idx1, int idx2, int idx_out){
        if (idx1 == -1 && idx2 == -1 && idx_out == -1)
            return true;
        
        if (idx1 >=0 && out.charAt(idx_out) == in1.charAt(idx1) &&
                checkInterLeave(idx1-1, idx2, idx_out-1) )
            return true;
        
        if (idx2 >= 0 && out.charAt(idx_out) == in2.charAt(idx2) &&
                checkInterLeave(idx1, idx2-1, idx_out-1))
            return true;
        return false;
    }
    
    public boolean isInterleaveV1(String s1, String s2, String s3) {
        int length1 = (s1==null)?0:s1.length();
        int length2 = (s2==null)?0:s2.length();
        int length3 = (s3==null)?0:s3.length();
        
        if (length3 != length2 + length1)
            return false;
        
        out = s3;
        in1 = s1;
        in2 = s2;
        
        return checkInterLeave(length1-1, length2-1, length3-1);
        
        
    }
    public boolean isInterleave(String s1, String s2, String s3) {

        int length1 = (s1==null)?0:s1.length();
        int length2 = (s2==null)?0:s2.length();
        int length3 = (s3==null)?0:s3.length();
        
        if (length3 != length2 + length1)
            return false;
        
        boolean flags[][] = new boolean[length1+1][length2+1];
        
        flags[0][0]= true;
        
        for (int i = 1; i <= length1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                flags[i][0]= true;
            } else
                break;
        }
        
        for (int i = 1; i <= length2; i++) {
            if (s3.charAt(i-1) == s2.charAt(i-1)) {
                flags[0][i]= true;
            } else
                break;
        }
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (flags[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
                    flags[i][j] = true;
                if (flags[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1))
                    flags[i][j] = true;
            }
        }
        
        return flags[length1][length2];
        
    }
    public static void main(String[] args)
    {
        InterleavingStr t = new InterleavingStr();
        
        //System.out.println(t.isInterleave("", "b", "b"));
        System.out.println(t.isInterleave("a", "b", "ab"));
    }
}
