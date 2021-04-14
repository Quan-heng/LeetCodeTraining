package 五毒.第四周.第一遍;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class minimum_genetic_mutation {
    public static void main(String[] args) {
       String start =  "AAAACCCC";
       String end= "CCCCCCCC";
       String[] bank = new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(start,end,bank));
    }
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        wordSet.remove(start);
        if (!wordSet.contains(end)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Deque<String> queue = new LinkedList<>();
        queue.push(start);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.pop();
                List<String> diffList = oneDiff(curWord, wordSet, visited);
                for (String s : diffList) {
                    if(s.equals(end)){
                        return result+1;
                    }
                    visited.add(s);
                    queue.push(s);
                }
            }
            result++;

        }
        return -1;
    }

    private static List<String> oneDiff(String curWord, Set<String> wordSet, Set<String> visitedSet) {
        List<String> diffList = new ArrayList<>();
        char[] charArray = curWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char oldChar = charArray[i];
            for (int j = 'A'; j <= 'Z'; j++) {
                if (j == oldChar) continue;
                charArray[i] = (char) j;
                String s = String.valueOf(charArray);
                if (wordSet.contains(s) && !visitedSet.contains(s)) {
                    diffList.add(s);
                    visitedSet.add(s);
                }
            }
            charArray[i] = oldChar;
        }
        return diffList;
    }


}
