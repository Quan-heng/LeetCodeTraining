package 每日一题;

import java.util.*;

/**
 * 思路：BFS
 * visited,wordset,queue,depth
 */
public class word_ladder {
    public static void main(String[] args) {
        String begin = "hot";
        String end = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        System.out.println(ladderLength(begin, end, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] charArray = curWord.toCharArray();
                for (int j = 0; j < curWord.length(); j++) {
                    char temp = charArray[j];
                    for (int k = 'a'; k <= 'z'; k++) {
                        if ((char)k == curWord.charAt(j)) {
                            continue;
                        }
                        charArray[j] = (char) k;
                        String newString = String.valueOf(charArray);
                        if (wordSet.contains(newString) && !visited.contains(newString)) {
                            if (newString.equals(endWord)) {
                                return depth + 1;
                            } else {
                                visited.add(newString);
                                queue.add(newString);
                            }
                        }
                    }
                    charArray[j]=temp;
                }
            }
            depth++;
        }
        return 0;
    }
}
