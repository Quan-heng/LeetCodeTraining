import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：广度优先
 */
public class Test102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = stack.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = stack.pop();
                list.add(temp.val);
                if(temp.left!=null){
                    stack.add(temp.left);
                }
                if(temp.right!=null){
                    stack.add(temp.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
