package 五毒.第四周.第二遍;

import java.util.*;

public class minimum_genetic_mutation {
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        if (!wordSet.contains(end)) {
            return -1;
        }
        Set<String> left = new HashSet<>();
        Set<String> right = new HashSet<>();
        Set<String> visited = new HashSet<>();
        wordSet.remove(start);
        left.add(start);
        right.add(end);
        int result = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.size() > right.size()) {
                Set<String> temp = left;
                left = right;
                right = temp;
            }
            Set<String> newSet = new HashSet<>();
            for (String a : left) {
                visited.add(a);
                List<String> list = diffList(a, wordSet, visited);
                for (String b : list) {
                    if (right.contains(b)) {
                        return result + 1;
                    }
                    newSet.add(b);
                }
            }
            left = newSet;
            result++;
        }
        return -1;
    }

    public static List<String> diffList(String a, Set<String> wordSet, Set<String> visited) {
        List<String> list = new ArrayList<>();
        char[] chars = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            char old = a.charAt(i);
            for (char c = 'A'; c <= 'Z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newString = String.valueOf(chars);
                if (wordSet.contains(newString) && !visited.contains(newString)) {
                    list.add(newString);
                }
            }
            chars[i] = old;
        }
        return list;
    }

    public static void main(String[] args) {
        String start = "AAAACCCC";
        String end= "CCCCCCCC";
        String[] bank = new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(start,end,bank));
    }
}
