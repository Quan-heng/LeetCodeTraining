import java.util.*;

//有效的括号
public class Test20 {
    public static void main(String[] args) {
      String s = "(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Map<Character, Character> dic = new HashMap<>();
        dic.put('(', ')');
        dic.put('{', '}');
        dic.put('[', ']');
        Stack<Character> stack = new Stack();
        if(dic.containsValue(s.charAt(0))){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (dic.containsKey(temp)) {
                stack.push(temp);
                continue;
            }
            if (!stack.empty() &&
                    //dic.containsValue(s.charAt(temp)) &&
                    dic.get(stack.peek()).equals(temp)) {
                  stack.pop();
                  continue;
            }else{
                return false;
            }

        }
        return stack.empty();

    }
}
