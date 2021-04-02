package 五毒.第一周.第二遍;

import java.util.LinkedHashMap;

public class swap_nodes_by_pairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        } else {
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = swapPairs(newHead.next);
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = swapPairs(node1);
        System.out.println(head.next + "" + head.next.next);
    }
}
