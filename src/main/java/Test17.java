import java.util.*;

/**
 * 电话号码的字母组合
 * 解题思路：回溯，用HashMap保存电话号码与字母的对应关系，分层递归，代码写法与排列相似
 */
public class Test17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static Map<Character, String> phoneMap = new HashMap<>();
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
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
    }

    /**
     * 视频版,效率没有第一版高
     * @param digits
     * @return
     */
    /*public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        generateMap();
        dfs(digits,"",result,0);
        return result;
    }

    private static void dfs(String digits, String letters, List<String> result, int depth) {
        if(digits.length()==depth){
            result.add(letters);
            return;
        }
        String value= phoneMap.get(digits.charAt(depth));
        for (int i = 0; i < value.length(); i++) {
            dfs(digits,letters+value.charAt(i),result,depth+1);
        }
    }*/

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        generateMap();
        StringBuilder combineStr = new StringBuilder();
        int depth = 0;
        dfs(digits,combineStr,result,depth,digits.length());
        return result;
    }

    private static void dfs(String digits, StringBuilder combineStr, List<String> result, int depth,int max) {
        if(max==depth){
            result.add(combineStr.toString());
            return;
        }
        String value= phoneMap.get(digits.charAt(depth));
        for (int i = 0; i < value.length(); i++) {
            combineStr.append(value.charAt(i));
            dfs(digits,combineStr,result,depth+1,max);
            //reverse
            combineStr.deleteCharAt(combineStr.length()-1);
        }
    }

}
