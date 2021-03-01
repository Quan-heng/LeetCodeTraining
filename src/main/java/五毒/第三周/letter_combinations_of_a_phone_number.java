package 五毒.第三周;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letter_combinations_of_a_phone_number {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
    public static  List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        Map<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        String content="";
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            stringList.add(phoneMap.get(digits.charAt(i)));
        }
        dfs(phoneMap,result,content,0,digits);
        return result;
    }

    private static void dfs(Map<Character, String> phoneMap, List<String> result, String content, int depth,String digits) {
        if(content.length()==digits.length()){
            result.add(content);
            return;
        }
        String cur = phoneMap.get(digits.charAt(depth));
        for(int i=0;i<cur.length();i++){
            dfs(phoneMap,result,content+cur.charAt(i),depth+1,digits);
        }
    }
}
