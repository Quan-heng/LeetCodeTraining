package 五毒.第一周.第三遍;



public class reverse_linked_list {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      while(head!=null){
          ListNode temp = head.next;
          head.next = prev;
          prev = head;
          head = temp;
      }
      return prev;
    }
}
