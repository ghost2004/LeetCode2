/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
 * number of rows like this: (you may want to display this pattern in a
 *  fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

P  I    N
A LS  I G
YA H R 
P  I
And then read line by line: "PAHNAPLSIIGYIR"
                             
Write the code that will take a string and make this conversion given 
a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigzagCon {
    public String convert(String s, int nRows) {
        if (s == null || s.length() < 2 || nRows == 1)
            return s;
        String out = new String();
        
        for (int i = 0; i < nRows; i++) {
            int idx = i;

            while (idx < s.length()) {
                out+=(s.charAt(idx));
                if (i == 0 || i == nRows -1 ){
                    idx += 2*(nRows -1);
                } else {
                    idx += 2*(nRows -1) - i*2;
                    if (idx >= s.length())
                        break;
                    out+=(s.charAt(idx));
                    idx += 2*i;
                    
                }
                
            }

            
        }
        
        return out;
    }
    
    public static void main(String args[]) {
        ZigzagCon z = new ZigzagCon();
        String s= "PALPAYISHIRING";
        System.out.println(z.convert(s, 1));
        //System.out.println(z.convert(s, 4));
    }

}
