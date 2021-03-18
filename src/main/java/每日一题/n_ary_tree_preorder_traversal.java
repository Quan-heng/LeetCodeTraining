package 每日一题;

import java.util.*;

public class n_ary_tree_preorder_traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int j = node.children.size() - 1; j >= 0; j--) {
                stack.push(node.children.get(j));
            }
        }
        return result;
    }
}
