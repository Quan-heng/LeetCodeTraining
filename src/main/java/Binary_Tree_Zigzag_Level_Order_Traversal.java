import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean left = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode curNode =  queue.removeFirst();
               list.add(curNode.val);
               if(curNode.left!=null){
                   queue.addLast(curNode.left);
               }
               if(curNode.right!=null){
                   queue.addLast(curNode.right);
               }
            }
            if(!left){
                Collections.reverse(list);
            }
            left=!left;
            result.add(list);
        }
        return result;
    }
}
