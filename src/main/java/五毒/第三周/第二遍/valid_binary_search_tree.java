package 五毒.第三周.第二遍;

public class valid_binary_search_tree {
    public long lastValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }

        Boolean left = isValidBST(root.left);
        if (root.val > lastValue) {
            lastValue = root.val;
        }else{
            return false;
        }
        Boolean right = isValidBST(root.right);
        return left&&right;

    }
}
