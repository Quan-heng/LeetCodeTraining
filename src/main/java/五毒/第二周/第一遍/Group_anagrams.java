package 五毒.第二周.第一遍;

import java.util.*;

public class Group_anagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String temp = String.valueOf(array);
            List<String> list = map.getOrDefault(temp,new ArrayList<>());
            list.add(strs[i]);
            map.put(temp,list);
        }
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
