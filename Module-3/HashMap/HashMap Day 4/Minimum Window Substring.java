import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        int dmct = t.length(); 
        int mct = 0; 

        int inc = -1; 
        int exc = -1; 

        HashMap<Character, Integer> fmap1 = new HashMap<>(); 

        String ans = "";

        while (true) {
            boolean inInc = false; 
            if (inc + 1 < s.length() && mct != dmct) {
                inc++;

                char ch = s.charAt(inc);
                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);
                if (fmap2.containsKey(ch) && fmap1.get(ch) <= fmap2.get(ch)) {
                    mct++;
                }

                inInc = true;
            }

            boolean inExc = false; 
            if (exc < inc && mct == dmct && (inc - exc + 1) >= t.length()) {
                String substr = s.substring(exc + 1, inc + 1);
                if (ans.equals("") || substr.length() < ans.length()) {
                    ans = substr;
                }

                exc++;
                char ch = s.charAt(exc);
                fmap1.put(ch, fmap1.get(ch) - 1);
                if (fmap2.containsKey(ch) && fmap1.get(ch) < fmap2.get(ch)) {
                    mct--;
                }
                if (fmap1.get(ch) == 0) {
                    fmap1.remove(ch);
                }

                inExc = true;
            }
            if (!inInc && !inExc) {
                break;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s, t));
    }
}
