package 五毒.第二周.第二遍;

import java.util.*;

public class n_ary_tree_postorder_traversal {
    /**
     * BFS
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node node = queue.pop();
                result.add(node.val);
                for (int j = 0; j<node.children.size(); j++) {
                    queue.push(node.children.get(j));
                }
            }
        }
        Collections.reverse(result);
        return result;
    }


    /*
    DFS
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            for (Node child : root.children) {
                result.addAll(postorder(child));
            }
            result.add(root.val);
        }
        return result;
    }*/
}

