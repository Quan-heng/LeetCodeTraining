package BFS;

import java.util.*;

public class Test126 {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(findLadders(begin,end,wordList));
    }
    public static int minLength = Integer.MAX_VALUE;
    private static void dfs(List<String> set, String curWord, String endWord, List<String> wordList,Map<Integer,List<List<String>>> result) {
        if(curWord.equals(endWord)){
            List<List<String>> temp =result.getOrDefault(set.size(),new ArrayList<>());
            temp.add(new ArrayList<>(set));
            result.put(set.size(),temp);
            minLength = Math.min(minLength,set.size());
            return;
        }
        for (String s : wordList) {
            if(!set.contains(s)){
                int diff=0;
                for(int i=0;i<s.length();i++){
                    if(curWord.charAt(i)!=s.charAt(i)){
                        diff++;
                        if(diff>1){
                            break;
                        }
                    }
                }
                if(diff==1){
                    set.add(s);
                    dfs(set,s,endWord,wordList,result);
                    set.remove(s);
                }
            }
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<Integer,List<List<String>>>  result = new HashMap<>();
        List<String> list = new ArrayList<>();
        wordList.remove(beginWord);
        list.add(beginWord);
        dfs(list,beginWord,endWord,wordList,result);
        if(minLength==Integer.MAX_VALUE){
            return new ArrayList<>();
        }else{
            return result.get(minLength);
        }
    }
}
