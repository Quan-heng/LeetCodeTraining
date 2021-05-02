package 五毒.第七周.第一遍;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> left = new HashSet<>();
        left.add(beginWord);
        Set<String> right = new HashSet<>();
        right.add(endWord);
        Set<String> visited = new HashSet<>();
        int length = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.size() > right.size()) {
                Set<String> temp = left ;
                left = right;
                right = temp;
            }
            Set<String> newSet = new HashSet<>();
            for (String s : left) {
                visited.add(s);
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String newStr = String.valueOf(chars);
                        if (wordSet.contains(newStr) && !visited.contains(newStr)) {
                            if (right.contains(newStr)) {
                                return length + 1;
                            }
                            newSet.add(newStr);
                        }
                    }
                    chars[i] = old;
                }
            }
            left = newSet;
            length++;
        }
        return 0;
    }
}
