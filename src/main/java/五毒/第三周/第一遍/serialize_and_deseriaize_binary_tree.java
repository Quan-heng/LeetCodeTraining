package 五毒.第三周.第一遍;

import java.util.*;

public class serialize_and_deseriaize_binary_tree {
    // Encodes a tree to a single string.
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(serialize(deserialize(serialize(node1))));

    }


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null){
            return "X";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] arr = data.split(",");
        Deque<String> list = new LinkedList<> (Arrays.asList(arr));
        return deserializeHelper(list);
    }

    public static TreeNode deserializeHelper(Deque<String> list){
        TreeNode root;
        if(list.getFirst().equals("X")){
            return null;
        }else{
            root = new TreeNode(Integer.valueOf(list.getFirst()));
        }
        if(list.size()>1){
            list.removeFirst();
            root.left = deserializeHelper(list);
        }
        if(list.size()>2){
            list.removeFirst();
            root.right = deserializeHelper(list);
        }
        return root;
    }
    /*public static String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            list.toString();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEnd;
        while (!queue.isEmpty()) {
            isEnd = true;
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    subList.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                    isEnd = false;
                } else {
                    subList.add(null);
                }
            }
            if (!isEnd) {
                list.addAll(subList);
            }
        }
        return list.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String str = data.substring(1, data.length() - 1).replace(" ", "");
        if (str.isEmpty()) {
            return null;
        }
        String[] array = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        TreeNode result = root;
        int count = 1;
        int index = 1;
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty() && count < array.length) {
            int size = queue.size();
            int curCount = (int) Math.pow(2, index);
            int temp = 0;
            for (int i = 0; i < size; i++) {
                root = queue.removeFirst();
                TreeNode left;
                TreeNode right;
                if (array[count].equals("null")) {
                    left = null;
                } else {
                    left = new TreeNode(Integer.valueOf(array[count]));
                }
                count++;

                if (array[count].equals("null")) {
                    right = null;
                } else {

                root.left = left;
                root.right = right;
                queue.add(left);
                queue.add(right);
                temp += 2;
                if (temp == curCount) {
                    break;
                }
            }
            index++;
        }
        return result;
    }*/
}
