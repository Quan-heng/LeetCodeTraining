package 五毒.第二周;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Valid_anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("124", "1234"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            int count = map.get(tChar) - 1;
            if(count<0){
                return false;
            }
        }
        return true;
    }
}
