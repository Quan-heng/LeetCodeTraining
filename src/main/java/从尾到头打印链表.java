import java.util.*;

public class 从尾到头打印链表 {
    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[]{};
        }
        Stack<Integer> stack  = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for(int j=0;j<size;j++){
            result[j] = stack.pop();
        }
        return result;

    }
}
