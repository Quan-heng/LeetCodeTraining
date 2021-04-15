package 五毒.第四周.第一遍;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class find_largest_value_tree_row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.removeFirst();
                max = Math.max(max, curNode.val);
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}

