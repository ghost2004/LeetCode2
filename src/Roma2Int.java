/*
 * Given a roman numeral, convert it to an integer.

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
public class Roma2Int {

    public int charToInt(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
        }
    }
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int idx = 0;
        int out = 0;
        while (idx < s.length()) {
            int p = charToInt(s.charAt(idx));
            int p2 =  0;
            if (idx < s.length()-1)
                p2 =  charToInt(s.charAt(idx+1));
            if (p2 > p) {
                out += p2 - p;
                idx += 2;
            } else {
                out += p;
                idx += 1;
            }
        }
        
        return out;
    }
}
