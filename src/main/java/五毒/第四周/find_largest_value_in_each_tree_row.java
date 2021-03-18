package 五毒.第四周;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

public class find_largest_value_in_each_tree_row {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(largestValues(root));
    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = queue.removeFirst();
                max= Math.max(max,cur.val);
                if(cur.left!=null){
                    queue.addLast(cur.left);
                }
                if(cur.right!=null){
                    queue.addLast(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
