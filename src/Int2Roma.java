/*
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Symbol  Value
I   1
V   5
X   10
L   50
C   100
D   500
M   1000
 */
public class Int2Roma {

    public final char symbol[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    
    public String intToRoman(int num) {
        String output = "";
        int n = num;
        int scale = 1000;
        int idx = 6;
        while (n > 0) {
            int digital = n / scale;
            if (digital != 0 ) {
                if (digital <= 3) {
                    for (int i = 0 ; i < digital; i++)
                        output += symbol[idx];
                } else if (digital == 4) {
                    output += symbol[idx];
                    output += symbol[idx+1];
                } else if (digital < 9) {
                    output += symbol[idx+1];
                    for (int i = digital; i > 5;i--) 
                        output += symbol[idx];
                } else if (digital == 9) {
                    output += symbol[idx];
                    output += symbol[idx+2];
                }
            }
            
            idx -= 2;
            n = n%scale;
            scale /= 10;
        }
        
        
        return output;
    }
}
