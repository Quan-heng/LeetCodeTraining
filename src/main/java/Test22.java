import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 括号生成
 */
public class Test22 {
    public static void main(String[] args) {
        //System.out.println(generateParenthesis(3));
        //generator( int left, int right, int n, string s);
      System.out.println(generateParenthesis(3));
    }

    /**
     * 解法1：递归判断左右括号数量是否超过最大值。
     * @param left
     * @param right
     * @param n
     * @param s
     * @param result
     */
    public static void generator(int left, int right, int n, String s, List<String> result) {
        //terminator
        if (left == n && right == n) {
            result.add(s);
        }
        //process
        if (left < n) {
            generator(left + 1, right, n, s + "(", result);
        }
        if (left>right) {
            generator(left, right + 1, n, s + ")",result);
        }
        //drill down
        //reverse
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generator(0,0,3,"",result);
        return result;
    }

    /**
     * 解法2：将'()'从前到后插入到上一级结果中。
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
        } else {
            List<String> last = generateParenthesis1(n - 1);
            //List<String> newResult = new ArrayList<>();
            for (int i = 0; i < last.size(); i++) {
                String str = last.get(i);
                List<Character> list1 = convertStringToCharList(str);
                List<Character> list2 = convertStringToCharList(str);
                for (int j = 0; j < list1.size() + 1; j++) {
                    list2.add(j, '(');
                    list2.add(j + 1, ')');
                    String string = list2.stream().map(String::valueOf).collect(Collectors.joining());
                    result.add(string);
                    list2 = convertStringToCharList(str);
                    ;
                }
            }
        }

        return new ArrayList(new HashSet(result));
    }

    public List<Character> convertStringToCharList(String str) {

        // Create an empty List of character
        List<Character> chars = new ArrayList<>();

        // For each character in the String
        // add it to the List
        for (char ch : str.toCharArray()) {

            chars.add(ch);
        }

        // return the List
        return chars;
    }
}
