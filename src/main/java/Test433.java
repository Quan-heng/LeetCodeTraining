import java.util.*;

/**
 * 最小基因变化
 * 解题思路：回溯
 */
public class Test433 {
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

    public static int res = Integer.MAX_VALUE;

    public static int minMutation(String start, String end, String[] bank) {
        if (bank == null) {
            return -1;
        }

        dfs(new HashSet<>(), start, end, bank);
        if (res != Integer.MAX_VALUE) {
            return res;
        } else {
            return -1;
        }
    }

    private static void dfs(Set<String> set, String prev, String end, String[] bank) {
        if (prev.equals(end)) {
            res = Math.min(set.size(), res);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            String temp = bank[i];
            if (!set.contains(temp)) {
                int diff = 0;
                for (int j = 0; j < bank[i].length(); j++) {
                    if (temp.charAt(j) != prev.charAt(j)) {
                        diff++;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {//关键，与上一个基因必然相差一个不同元素
                    set.add(bank[i]);
                    dfs(set, bank[i], end, bank);
                    set.remove(bank[i]);
                }
            }
        }
    }
}
