/*
 * Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 *   which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongSubStrWOR {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] map = new int[256];
        for (int i = 0; i < 256;i++) {
            map[i] = -1;
        }
        int length = 0;
        int maxLen = 0;
        int lastIdx = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char key = s.charAt(idx);
            if (map[key] == -1 || map[key] < lastIdx) {
                length++;
                
            } else {
                maxLen = Math.max(length, maxLen);
                int j = map[key] + 1;

                length = idx - j + 1;
                lastIdx = j;
            }
            map[key] = idx;
        }

        return Math.max(length, maxLen);
    }
    
    public static void main(String[] args) {
        LongSubStrWOR c = new LongSubStrWOR();
        String[] t1 = {"", "abcabcbb", "bbbb", "dada"};
        String[] t = {"wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"};
        String[] t3 = {"hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"};
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]+" length:" + c.lengthOfLongestSubstring(t[i]));
        }
        
    }
}
