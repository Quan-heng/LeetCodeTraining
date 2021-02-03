import java.util.Stack;

public class Test1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        //方法1,用stack，效率低
        /*String result = "";
        if (S.isEmpty() || S.startsWith(")")) {
            return result;
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = S.toCharArray();
        int left = 0;
        int i = 0;
        stack.push(arr[i++]);
        while (i < S.length()) {
            if (arr[i] - ')' == 0) {
                stack.pop();
                if (stack.isEmpty()) {
                    if (i - 1 != left) {
                        result += S.substring(left + 1, i);
                    }
                    left = ++i;
                    if (left < S.length()) {
                        stack.push(S.charAt(left));
                    }
                }
                i++;
            } else {
                stack.push(arr[i++]);
            }
        }
        return result;*/
        //方法2，计数法，为0时截取字符串
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int left = 0;
        char[] arr = S.toCharArray();
        int i = 0;
        while(i<S.length()){
            if(arr[i] - '('==0){
                k++;
            }
            else if(arr[i]-')'==0){
                k--;
                if(k==0){
                    sb.append(S.substring(left+1,i));
                    left = ++i;
                    k++;
                }
            }
            i++;
        }
        return sb.toString();
    }
}
