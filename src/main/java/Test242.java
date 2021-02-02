import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Test242 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> map = new Hashtable<>();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                map.put(arr2[i], map.get(arr2[i]) - 1);
            } else {
                map.put(arr2[i], 1);
            }
        }

        for (Integer value : map.values()) {

            if (value != 0) {
                return false;
            }

        }
        return true;
    }
}
