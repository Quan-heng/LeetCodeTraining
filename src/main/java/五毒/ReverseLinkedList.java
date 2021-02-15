package 五毒;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next  =node4;
        reverseList(node1);

    }
    public static  ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        /*Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(stack.pop());
        ListNode temp = res;
        while(!stack.isEmpty()){
            res.next = new ListNode(stack.pop());
            res = res.next;
        }
        return temp;*/
        ListNode pre = null;
        while (head!=null){
            ListNode nextTemp = head.next;
            head.next= pre;
            pre = head;
            head = nextTemp;
        }
        return pre;
    }
}
