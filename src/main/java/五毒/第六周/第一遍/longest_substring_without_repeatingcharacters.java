package 五毒.第六周.第一遍;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class longest_substring_without_repeatingcharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int[] dp = new int[s.length()];
        Deque<Character> queue = new LinkedList<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(queue.contains(s.charAt(i))){
                while(queue.peek()!=s.charAt(i)){
                    queue.removeFirst();
                }
                queue.removeFirst();
            }
            queue.addLast(s.charAt(i));
            max = Math.max(queue.size(),max);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
