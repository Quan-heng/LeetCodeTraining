package 五毒.第二周;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.Stack;

public class n_ary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = stack.size();
            for(int i=0;i<size;i++){
                Node node = stack.pop();
                list.add(node.val);
                for (int j = node.children.size() - 1; j >= 0; j--) {
                    stack.push(node.children.get(j));
                }
            }
            result.add(new ArrayList<>(list));
=======
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class n_ary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size=stack.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = stack.removeLast();
                list.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    stack.push(node.children.get(j));
                }
            }
            result.add(list);
>>>>>>> origin/master
        }
        return result;
    }
}
