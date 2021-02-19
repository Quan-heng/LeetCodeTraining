package BFS;

import java.util.*;

/**
 * 单词接龙：
 * 思路：BFS
 */
public class Test127 {
    public static void main(String[] args) {
        String begin = "a";
        String end = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        System.out.println(ladderLength(begin, end, wordList));
    }

    /**
     * 优化版：_bc,从'a'-'z'去填充_，看填充后的字符是否在没有访问的单词集体中
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        wordSet.remove(beginWord);
        Deque<String> queue = new LinkedList<>();
        int res = 0;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curWord= queue.poll();//用26个字符去土替换没每一位
                for(int j=0;j<curWord.length();j++){
                    String temp = curWord;
                    for(int k = 'a';k<='z';k++){

                    }

                }

            }

        }
    }

    /**
     * 自己思考版，对于长度比较大的字符，判断不同的字母的数量，时间复杂度太大
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        int result = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            result++;
            Stack<String> newStack = new Stack<>();
            for (int i = 0; i < size; i++) {
                String cur = stack.pop();
                if (cur.equals(endWord)) {
                    return result;
                }
                List<String> list = new ArrayList<>();
                for (int j = 0; j < wordList.size(); j++) {
                    String w = wordList.get(j);
                    int diff = 0;
                    for (int k = 0; k < w.length(); k++) {
                        if (cur.charAt(k) != w.charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 1) {
                        list.add(w);
                        newStack.add(w);
                    }
                }
                if (list.size() > 0) {
                    wordList.removeAll(list);
                }
            }
            stack = newStack;
        }
        return 0;
    }
}
