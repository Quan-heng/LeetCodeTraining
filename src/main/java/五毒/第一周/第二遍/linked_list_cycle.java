package 五毒.第一周.第二遍;

public class linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
