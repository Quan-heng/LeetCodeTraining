package 贪心算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 林檬水找零
 * 解题思路：贪心算法，先减去面值大的，然后减去面值小的
 */
public class Test860 {
    public static void main(String[] args) {
        int[] bills = new int[]{5, 5,5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;

            } else {
                if (ten >= 1 && five >= 1) {//贪心算法，先减去10的，再减去5的
                    ten--;
                    five--;
                } else if (ten == 0 && five>= 3) {
                    five-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean lemonadeChange1(int[] bills) {
        if (bills == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.get(5) + 1);
            } else if (bills[i] == 10) {
                int temp = map.get(5);
                if (temp == 0) {
                    return false;
                }
                map.put(5, temp - 1);
                map.put(10, map.get(10) + 1);

            } else {
                int tenCount = map.get(10);
                int fiveCount = map.get(5);
                if (tenCount >= 1 && fiveCount >= 1) {
                    map.put(5, fiveCount - 1);
                    map.put(10, tenCount - 1);
                } else if (tenCount == 0 && fiveCount >= 3) {
                    map.put(5, fiveCount - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
