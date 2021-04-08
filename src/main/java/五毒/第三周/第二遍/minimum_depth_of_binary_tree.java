package 五毒.第三周.第二遍;

public class minimum_depth_of_binary_tree {
    public int minDepth(invert_binary_tree.TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
