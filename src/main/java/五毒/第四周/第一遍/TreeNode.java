package 五毒.第四周.第一遍;

public class TreeNode {
    int val;
    TreeNode() {}
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
