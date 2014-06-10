/*
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        
        int len1 = num1.length();
        int len2 = num2.length();
    
        int num[] = new int[len1+len2];
        int i,j;
        
        for (i = 0; i < len1; i++) {
            int carry = 0;
            int n1 = num1.charAt(len1 - 1 - i) - '0';
            for (j = 0; j < len2; j++) {
                int n2 = num2.charAt(len2-1-j)-'0';
                int m = n1*n2+carry;
                num[i+j] += m;
                carry = num[i+j] / 10;
                num[i+j] %= 10;
                
            }
            num[i+len2] += carry;
            
        }
        
        i = num.length-1;
        while (i > 0 && num[i] == 0)
            i--;
        StringBuilder tmp  = new StringBuilder();
        while (i >= 0)
            tmp.append(num[i--]);
        
        return tmp.toString();
        
    }
    
    public static void main(String args[]) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("0", "0"));
    }
}
