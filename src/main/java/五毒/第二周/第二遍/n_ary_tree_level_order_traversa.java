package 五毒.第二周.第二遍;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class n_ary_tree_level_order_traversa {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = queue.removeFirst();
                subList.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.offerLast(node.children.get(j));
                }
            }
            result.add(subList);
        }
        return result;
    }
}
