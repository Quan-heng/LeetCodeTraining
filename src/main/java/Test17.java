import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class Test17 {
    public static void main(String[] args) {
        Map<Integer, char[]> phoneMap = new HashMap<>();
        char begin = 'a';
        for (int i = 2; i <= 9; i++) {
            if (i != 7) {
                char[] chars = new char[3];
                for (int j = 0; j < 3; j++) {
                    chars[j] =begin++;
                }
                phoneMap.put(i, chars);
            } else {
                phoneMap.put(i, new char[]{'p', 'q', 'r', 's'});
            }
        }
        System.out.println(phoneMap);
    }

    public List<String> letterCombinations(String digits) {
        return null;
    }
}
