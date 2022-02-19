package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2022/02/15
 * <p>
 * 思路
 * 1. 计算链表长度，二次遍历 -- O(L)，L为链表表长
 * 重点在于处理链表长度与n恰好相等的情况
 * 也就是说此时s.next.next为空指针
 * 解决：预处理链表长度，引入一个前序结点进行操作
 * 2. 快慢指针
 * fast比slow快n步，若n次后为末尾后一个结点，则需删除首结点
 * 否则开始同步遍历直到到达表尾
 * fast先遍历一次，使得最后得到的slow是需要删除结点的前一结点
 */
public class Q19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode s = head;
        int cnt = 0;
        while (s instanceof ListNode) {
            s = s.next;
            cnt++;
        }

        s = pre;
        while (cnt - n > 0) {
            cnt--;
            s = s.next;
        }
        s.next = s.next.next;

        return pre.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }

        fast = fast.next;
        while (fast instanceof ListNode) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }


}
