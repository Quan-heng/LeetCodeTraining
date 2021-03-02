package 五毒.第一周.第一遍;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {

    }
    public static boolean isValid(String s) {
       if(s.isEmpty()){
           return false;
       }
       Map<Character,Character> map= new HashMap<>();
       map.put(')','(');
       map.put('}','{');
       map.put(']','[');
       Deque<Character> stack = new LinkedList<>();
       for(int i=0;i<s.length();i++){
           char temp  = s.charAt(i);
           if(!map.containsKey(temp)){
               stack.push(temp);
           }else{
               if(!stack.isEmpty()&&stack.peek()==map.get(temp)){
                   stack.pop();
               }else{
                   stack.push(temp);
               }

           }
       }
       return stack.isEmpty()?true:false;
    }
}
