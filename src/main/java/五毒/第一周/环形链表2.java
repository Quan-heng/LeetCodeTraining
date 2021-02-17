package 五毒.第一周;

import java.util.HashSet;
import java.util.Set;

public class 环形链表2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        node2.next = node;
        System.out.println(detectCycle(node));
    }
    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
