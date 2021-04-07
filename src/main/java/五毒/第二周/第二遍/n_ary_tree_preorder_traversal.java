package 五毒.第二周.第二遍;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class n_ary_tree_preorder_traversal {
    /**
     * bfs
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Node> queue = new LinkedList<>();
        queue.push(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pop();
                result.add(node.val);
                for (int j = node.children.size() - 1; j >= 0; j--) {
                    queue.push(node.children.get(j));
                }
            }
        }
        return result;
    }
    /*dfs
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            result.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                result.addAll(preorder(root.children.get(i)));
            }
        }
        return result;
    }*/
}
