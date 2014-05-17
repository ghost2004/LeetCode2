/*
 * Given a digit string, return all possible letter combinations 
 * that the number could represent.
 * 
 * Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer
 could be in any order you want.
 */

import java.util.ArrayList;
public class LetterCombination {
    public static final String trans[] = {"", " ", "abc", "def", "ghi", "jkl",  
            "mno", "pqrs", "tuv", "wxyz"};
    public void addLetter(String prefix, String d, ArrayList<String> container){
        int idx = d.charAt(0) - '0';
        for (int i = 0; i < trans[idx].length(); i++) {
            String np = prefix+trans[idx].charAt(i);
            if (d.length() == 1) {
                container.add(np);
            } else {
                addLetter(np,d.substring(1),container);
            }
        }
        
        
    }
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> out = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            out.add("");
            return out;
        }
        addLetter("", digits,out);
        return out;
    }
                               
}
