package 五毒.第三周.第二遍;

import java.util.Arrays;

public class construct_binary_tree_from_preorder_and_inorder_traversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int leftLength = 0;
        int rightLength = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                leftLength = i;
                break;
            }
        }
        rightLength = inorder.length - leftLength - 1;
        if (leftLength > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + leftLength),
                    Arrays.copyOfRange(inorder, 0, leftLength));
        }
        if (rightLength > 0) {
            root.right = buildTree(Arrays.copyOfRange(preorder, preorder.length - rightLength, preorder.length),
                    Arrays.copyOfRange(inorder, inorder.length - rightLength, inorder.length));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        buildTree(preorder,inorder);
    }
}
