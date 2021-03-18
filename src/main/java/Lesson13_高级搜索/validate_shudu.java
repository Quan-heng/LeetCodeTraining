package Lesson13_高级搜索;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class validate_shudu {
    /**
     * 一次迭代
     * @param board
     * @return
     */
    public static boolean isValidSudoku1(char[][] board) {
        Map<Character, Integer>[] row = new HashMap[9];
        Map<Character, Integer>[] col = new HashMap[9];
        Map<Character, Integer>[] block = new HashMap[9];
        for(int i=0;i<9;i++){
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            block[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp == '.') {
                    continue;
                }
                row[i].put(temp, row[i].getOrDefault(temp, 0) + 1);//row
                col[j].put(temp, col[j].getOrDefault(temp, 0) + 1);//col
                int blockIndex = i / 3 * 3 + j / 3;//block
                block[blockIndex].put(temp, block[blockIndex].getOrDefault(temp, 0) + 1);
                if (row[i].get(temp) > 1 || col[j].get(temp) > 1 || block[blockIndex].get(temp) > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**三次迭代
     * 解题思路：
     * 1.每一行是否有重复元素
     * 2.每一列是否有重复元素
     * 3.第一个空格是否有重复元素
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {//检查每一行
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else {
                    return false;
                }
            }
            set.clear();
        }

        for (int i = 0; i < 9; i++) {//检查每一行
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else if (!set.contains(board[j][i])) {
                    set.add(board[j][i]);
                } else {
                    return false;
                }
            }
            set.clear();
        }

        for (int i = 0; i < 3; i++) {//每一个3*3的空格
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i * 3 + k][j * 3 + l] == '.') {
                            continue;
                        } else if (!set.contains(board[i * 3 + k][j * 3 + l])) {
                            set.add(board[i * 3 + k][j * 3 + l]);
                        } else {
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
