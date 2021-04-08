package 五毒.第三周.第二;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letter_combinations_of_a_phone_number {
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();

        dfs(result, digits, "", map,0);
        return result;
    }

    private static void dfs(List<String> result, String digits, String s, Map<Character, String> map,int depth) {
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }
        String word = map.get(digits.charAt(depth));
        for(int i=0;i<word.length();i++){
            dfs(result,digits,s+word.charAt(i),map,depth+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
