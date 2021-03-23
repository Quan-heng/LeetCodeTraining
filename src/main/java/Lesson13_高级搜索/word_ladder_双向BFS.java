package Lesson13_高级搜索;

import java.util.*;

public class word_ladder_双向BFS {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(begin, end, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return -1;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int result = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> set = new HashSet<>();
            for (String s : beginSet) {
                char[] charArray = s.toCharArray();
                for (int j = 0; j < s.length(); j++) {
                    char old = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        charArray[j] = k;
                        String word = String.valueOf(charArray);
                        if (endSet.contains(word)) {
                            return result + 1;
                        }
                        if (wordSet.contains(word) && !visited.contains(word)) {
                            visited.add(word);
                            set.add(word);
                        }
                        charArray[j] = old;
                    }
                }
            }
            result++;
            beginSet = set;
        }
        return -1;
    }
}