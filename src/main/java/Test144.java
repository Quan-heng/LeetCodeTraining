import java.util.ArrayList;
import java.util.List;

//二叉树的前序遍历
//递归
public class Test144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        /*if(root.right==null&&root.left==null){ 中序遍历加上效率100%，前后遍历去100%
            result.add(root.val);
            return result;
        }*/
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
