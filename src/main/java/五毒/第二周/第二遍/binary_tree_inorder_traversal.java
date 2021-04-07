package 五毒.第二周.第二遍;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_inorder_traversal {
    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            TreeNode temp = queue.pop();
            result.add(temp.val);
            root = temp.right;
        }
        return result;
    }


    /**
     * DFS
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalD(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversalD(root.left));
            result.add(root.val);
            result.addAll(inorderTraversalD(root.right));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        inorderTraversal(node1);
    }
}
