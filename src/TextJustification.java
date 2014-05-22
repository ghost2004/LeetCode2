/*
 * Given an array of words and a length L, format the text such that 
 * each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is,
 pack as many words as you can in each line. Pad extra 
 spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words, 
 the empty slots on the left will be assigned more spaces than the slots 
 on the right.

For the last line of text, it should be left justified and no extra space 
is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should
 you do in this case?
In this case, that line should be left-justified.
 */

import java.util.ArrayList;

public class TextJustification {
    
    public String getSpace(int n) {
        String s = "";
        for (int i = 0;i < n;i++)
            s+=" ";
        return s;
    }
    public ArrayList<String> fullJustify(String[] words, int L) {
        
        ArrayList<String> out = new ArrayList<String>();
        
        if (words == null || words.length == 0)
            return out;
        
        int accLength = 0;
        int idx = 0;
        int cnt = 0;
        
        while (idx < words.length) {
            accLength = words[idx].length();
            cnt = 1;
            idx++;
            while (accLength < L && idx < words.length) {
                if (accLength + words[idx].length() + 1 > L)
                    break;
                accLength += words[idx].length()+1;
                idx++;
                cnt++;
            }
            
           
            String line = new String();
            
            if (idx >= words.length) {
                // last line
                for (int i = cnt; i > 1;i--) 
                    line+=words[idx-i]+" ";
                line += words[idx-1];
                line += getSpace(L - line.length());
                
            } else {
                // non-last line
                if (cnt == 1) {
                    line += words[idx-1]+getSpace(L-words[idx-1].length());

                } else {
                    int avg = (L-accLength+cnt-1)/(cnt-1);
                    int extra = (L-accLength+cnt-1)%(cnt-1);
                    
                    for (int i = cnt; i > 1;i--) {
                        int sp=0;
                        if (i > cnt - extra)
                            sp = avg+1;
                        else
                            sp = avg;
                        line+=words[idx-i]+getSpace(sp);             
                    }
                    line += getSpace(L - line.length()-words[idx-1].length());
                    line += words[idx-1];
                }
            }
            
            
            
            out.add(line);
            cnt = 0;
            accLength = 0;
            
            
        }
        
        return out;
    }
    
    public void printOut(String[] words, int L) {
        ArrayList<String> str = this.fullJustify(words, L);
        for (String l:str) {
            System.out.println(l);
        }
        
    }
    
    public static void main(String args[]) {
        TextJustification text = new TextJustification();
        String t1[]={"This", "is", "an", "example", "of", "text", "justification."};
        String t2[]={"What","must","be","shall","be."};
        String t3[]={"a","b","c","d","e"};
        
        text.printOut(t1, 16);
        text.printOut(t2, 12);
        text.printOut(t3, 3);
        
    }

}
