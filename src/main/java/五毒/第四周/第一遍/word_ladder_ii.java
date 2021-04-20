package 五毒.第四周.第一遍;

import java.util.*;
import java.util.stream.Collectors;

public class word_ladder_ii {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        if(!wordSet.contains(endWord)){
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        wordSet.remove(beginWord);
        Deque<Deque<String>> queue = new LinkedList<>();
        Deque<String> subList = new LinkedList<>();
        subList.add(beginWord);
        queue.add(subList);
        Set<String> visited = new HashSet<>();
        boolean ended = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Deque<String> curQueue = queue.removeFirst();
                String lastWord= curQueue.getLast();
                visited.add(lastWord);
                char[] chars = lastWord.toCharArray();
                for(int j =0;j<lastWord.length();j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[j] = c;
                        String newStr = String.valueOf(chars);
                        if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                            Deque<String> tempQueue= new LinkedList<>(curQueue);
                            tempQueue.add(newStr);
                            if (endWord.equals(newStr)) {
                                result.add(new ArrayList<>(tempQueue));
                                ended = true;
                            } else {
                                queue.add(tempQueue);
                            }
                        }
                    }
                    chars[j] = old;
                }
            }
            if(ended){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";

        String[] arr = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(arr.clone());
        System.out.println(findLadders(begin,end,list));
    }
}
