package 五毒.第四周.第二遍;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode curNode = queue.removeFirst();
                subList.add(curNode.val);
                if(curNode.left!=null){
                    queue.offerLast(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offerLast(curNode.right);
                }
            }
            result.add(new ArrayList<>(subList));
        }
        return result;
    }
}
