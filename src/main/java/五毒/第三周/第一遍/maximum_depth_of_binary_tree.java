package 五毒.第三周.第一遍;

/**
 * 思路：递归
 * 时间复杂度: o(n),n为所有元素的数量
 * 空间复杂度: o(height),height为树的高度
 */

public class maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }
}
