import java.util.*;

public class Test242 {
    public static void main(String[] args) {
      String s1 = "aa";
      String s2="aa";
        System.out.println(isAnagram(s1,s2));
    }

    public static boolean isAnagram(String s,String t){
       char[] arr1 =  s.toCharArray();
       char[] arr2 = t.toCharArray();
       Arrays.sort(arr1);
       Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
       return Arrays.equals(arr1,arr2);

    }
    public static boolean isAnagram1(String s, String t) {
        /*if(s.isEmpty()&&t.isEmpty()){
            return true;
        }
        if(s.length()!=t.length()){
            return false;
        }*/
        Map<Character,Integer> map = new HashMap<>();
        char[] arr1 =  s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }else{
                map.put(arr1[i],1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i])){
                map.put(arr2[i],map.get(arr2[i]) - 1);
                if(map.get(arr2[i])==0){
                    map.remove(arr2[i]);
                }
            }else{
                map.put(arr2[i],1);
            }
        }
        if(map.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
