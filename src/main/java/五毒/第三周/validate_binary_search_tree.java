package 五毒.第三周;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：利二叉搜索树的中序遍历是升序的特性
 */
public class validate_binary_search_tree {
    /**
     * 法1：BFS
     * 时间复杂度：o(n)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        long cur = Long.MIN_VALUE;
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.add(root);
                root = root.left;
            }
            TreeNode temp = queue.removeLast();

            if (temp.val > cur) {
                cur = temp.val;
            } else {
                return false;
            }
            root = temp.right;
        }
        return true;

    }

    /**
     * 法2：递归
     * 时间复杂度：o(n)
     * @param root
     * @return
     */
    public long pre = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if(root.val>pre){
            pre = root.val;
        }else{
            return false;
        }
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}
