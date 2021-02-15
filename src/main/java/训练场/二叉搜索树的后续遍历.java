package 训练场;

import java.util.Arrays;

public class 二叉搜索树的后续遍历 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,6,5};
        System.out.println(verifyPostorder(nums));
    }
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder==null){
            return false;
        }
        int[] inOrder = postorder.clone();
        Arrays.sort(inOrder);
        int root = postorder[postorder.length-1];
        int rootIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i]==root){
                rootIndex = i;
            }
        }

        int leftBegin = 0;
        int leftEnd = rootIndex;
        int rightBegin = rootIndex+1;
        int rightEnd = postorder.length;
        int[] inLeft;
        int[] inRight;
        int[] postLeft;
        int[] postRight;
        if(leftEnd>=leftBegin&&rightEnd>rightBegin){
            inLeft = Arrays.copyOfRange(inOrder,leftBegin,leftEnd);
            inRight = Arrays.copyOfRange(inOrder,rightBegin,inOrder.length);
            postLeft = Arrays.copyOfRange(postorder,0,leftEnd-leftBegin);
            Arrays.sort(postLeft);
            postRight = Arrays.copyOfRange(postorder,leftEnd-leftBegin,postorder.length-1);
            Arrays.sort(postRight);
            if(Arrays.toString(inLeft).equals(Arrays.toString(postLeft))&&Arrays.toString(inRight).equals(Arrays.toString(postRight))){
                return true;
            }
        }
        return false;
    }
}
