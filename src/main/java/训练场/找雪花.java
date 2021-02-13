package 训练场;

import java.util.*;

/**
 *解题思路：用HashMap记录所有顺时针和逆时针的维合
 */
public class 找雪花 {
    public static void main(String[] args) {
        int[][] snows = new int[2][6];
        int[] snow1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] snow2 = new int[]{4, 3, 2, 1, 6, 5};
        snows[0] = snow1;
        snows[1] = snow2;
        System.out.println(findSameSnow(snows));
    }

    public static String findSameSnow(int[][] snows) {
        Set<String> map = new HashSet<>();
        if (snows == null) {
            return "No";
        }
        for (int i = 0; i < snows.length; i++) {
            int j = 0;
            while (j < 6) {//顺时针
                int[] temp = new int[6];
                for (int k = 0; k < snows[i].length; k++) {
                    temp[k] = snows[i][(k + j) % 6];
                }
                String value = Arrays.toString(temp);
                if(map.contains(value)){
                    return "Yes";
                }else{
                    map.add(value);
                }
                j++;
            }

            int[] reverse  = new int[6];
            for (int k = snows[i].length - 1; k >= 0; k--) {
                reverse[5-k] = snows[i][k];
            }
            j=0;
            while (j < 6) {//顺时针
                int[] temp = new int[6];
                for (int k = 0; k < reverse.length; k++) {
                    temp[k] = reverse[(k + j) % 6];
                }
                String value = Arrays.toString(temp);
                if(map.contains(value)){
                    return "Yes";
                }else{
                    map.add(value);
                }
                j++;
            }
        }
        return "No";
    }
}
