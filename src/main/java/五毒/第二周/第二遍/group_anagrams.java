package 五毒.第二周.第二遍;

import java.util.*;

public class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            List<String> list = map.getOrDefault(sortedStr,new ArrayList<>());
            list.add(strs[i]);
            map.put(sortedStr,list);
        };
        return new ArrayList<>(map.values());
    }
}
