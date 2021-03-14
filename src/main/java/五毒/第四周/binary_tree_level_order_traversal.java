package 五毒.第四周;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_level_order_traversal {
    /**
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if(node.left!=null)  queue.push(node.left);
                if(node.right!=null)  queue.push(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
