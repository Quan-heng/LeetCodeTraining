package 五毒.第一周.第二遍;


import 五毒.第三周.TreeNode;

public class reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
