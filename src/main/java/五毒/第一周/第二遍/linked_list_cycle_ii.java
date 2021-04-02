package 五毒.第一周.第二遍;

import java.util.HashSet;
import java.util.Set;

public class linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return null;
    }

}
