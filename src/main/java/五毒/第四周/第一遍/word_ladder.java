package 五毒.第四周.第一遍;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_ladder {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> left = new HashSet<>();
        Set<String> right = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if(!wordSet.contains(endWord)){
            return 0;
        }
        left.add(beginWord);
        right.add(endWord);
        wordSet.remove(beginWord);
        int len = 1;
        while(!left.isEmpty()&&!right.isEmpty()){
            if(left.size()>right.size()){
                Set<String> temp = left;
                left = right;
                right = temp;
            }
            Set<String> newSet = new HashSet<>();
            for (String s : left) {
                visited.add(s);
                char[] chars = s.toCharArray();
                for(int i=0;i<s.length();i++){
                    char old = chars[i];
                    for(char c = 'a';c<='z';c++){
                        if(c==old){
                            continue;
                        }
                        chars[i] = c;
                        String str = String.valueOf(chars);
                        if(wordSet.contains(str)&&!visited.contains(str)){
                            if(right.contains(str)){
                                return len+1;
                            }
                            newSet.add(str);
                        }
                    }
                    chars[i] = old;

                }
            }
            left = newSet;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hot";
        String end = "dog";
        String[] arr = new String[]{"hot","dog"};
        System.out.println(ladderLength(begin,end, Arrays.asList(arr)));
    }
}
