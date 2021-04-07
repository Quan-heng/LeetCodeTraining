package 五毒.第三周.第一遍;

/**
 * 思路：递归
 */
public class minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right);
        }
        if(root.right==null){
            return minDepth(root.left);
        }
       return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
