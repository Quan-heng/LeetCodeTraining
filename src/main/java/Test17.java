import java.util.*;

/**
 * 电话号码的字母组合
 * 解题思路：回溯，用HashMap保存电话号码与字母的对应关系，分层递归，代码写法与排列相似
 */
public class Test17 {
    public static void main(String[] args) {
        generateMap();
        System.out.println(letterCombinations("234"));
    }
    public static Map<Integer, String> phoneMap = new HashMap<>();
    private static void generateMap() {
        /*char begin = 'a';
        int end;
        for (int i = 2; i <= 9; i++) {
            if (i == 7||i==9) {
                end = 4;
            } else {
                end = 3;
            }
            char[] chars = new char[end];
            for (int j = 0; j < end; j++) {
                chars[j] = begin++;
            }
            phoneMap.put(i, chars);
        }*/
        phoneMap.put(2,"abc");
        phoneMap.put(3,"def");
        phoneMap.put(4,"ghi");
        phoneMap.put(5,"jkl");
        phoneMap.put(6,"mno");
        phoneMap.put(7,"pqrs");
        phoneMap.put(8,"tuv");
        phoneMap.put(9,"wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        generateMap();
        StringBuilder combineStr = new StringBuilder();
        int depth = 0;
        int[] numberList = new int[digits.length()];
        for(int i=0;i<digits.length();i++){
            numberList[i]=digits.charAt(i)-'0';
        }
        dfs(numberList,combineStr,result,depth,digits.length());
        return result;
    }

    private static void dfs(int[] numberList, StringBuilder combineStr, List<String> result, int depth,int max) {
        if(max==depth){
            result.add(combineStr.toString());
            return;
        }
        String value= phoneMap.get(numberList[depth]);
        for (int i = 0; i < value.length(); i++) {
            combineStr.append(value.charAt(i));
            dfs(numberList,combineStr,result,depth+1,max);
            //reverse
            combineStr.deleteCharAt(combineStr.length()-1);
        }
    }
}
