package 五毒.第一周.第二遍;

import java.util.*;

public class valid_parentness {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()||stack.pop()!=map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

