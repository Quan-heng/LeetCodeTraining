package 五毒.第三周;

import java.util.Arrays;

public class build_tree_from_preorder {
    public static void main(String[] args) {
        buildTree(new int[]{1,2},new int[]{2,1});
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftLength  = index;
        int rightLength = inorder.length-leftLength-1;

        int[] inLeft = new int[leftLength];
        int[] inRight = new int[rightLength];
        int[] preLeft = new int[leftLength];
        int[] preRight= new int[rightLength];
        System.arraycopy(inorder,0,inLeft,0,leftLength);
        System.arraycopy(inorder,index+1,inRight,0,rightLength);
        System.arraycopy(preorder,1,preLeft,0,leftLength);
        System.arraycopy(preorder,1+leftLength,preRight,0,rightLength);

        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        return root;

    }
}
