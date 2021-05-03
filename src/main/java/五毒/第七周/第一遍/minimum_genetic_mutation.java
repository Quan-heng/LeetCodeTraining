package 五毒.第七周.第一遍;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class minimum_genetic_mutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        wordSet.remove(start);
        if(!wordSet.contains(end)) return -1;
        Set<String> left = new HashSet<>();
        Set<String> right = new HashSet<>();
        Set<String> visited = new HashSet<>();
        left.add(start);
        right.add(end);
        int length = 0;
        while(!left.isEmpty()&&!right.isEmpty()){
            if(left.size()>right.size()){
                Set<String> temp = left;
                left = right;
                right = temp;
            }
            Set<String> newSet =new HashSet<>();
            for (String s : left) {
                visited.add(s);
                char[] chars = s.toCharArray();
                for(int i = 0;i<chars.length;i++){
                    char old = chars[i];
                    for(char c = 'A';c<='Z';c++){
                        if(c==old){
                            continue;
                        }
                        chars[i] = c;
                        String newStr = String.valueOf(chars);
                        if(!visited.contains(newStr)&&wordSet.contains(newStr)) {
                            if(right.contains(newStr)){
                                return length+1;
                            }
                            newSet.add(newStr);
                        }
                    }
                    chars[i] = old;
                }
            }
            length++;
            left = newSet;
        }
        return -1;
     }
}
