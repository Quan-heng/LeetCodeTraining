package 五毒.第二周.第一遍;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            root = temp.right;
        }
        return result;
    }
}
