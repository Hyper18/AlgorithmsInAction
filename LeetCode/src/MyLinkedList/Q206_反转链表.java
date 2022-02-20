package MyLinkedList;

import java.util.Stack;

/**
 * @author Hyperspace
 * @date 2022/02/20
 * <p>
 * 1. stack
 * 2. two-pointer
 */
public class Q206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stk = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            stk.push(new ListNode(cur.val));
        }

        ListNode newHead = cur;
        ListNode newCur = newHead;
        while (!stk.isEmpty()) {
            newCur.next = stk.pop();
            newCur = newCur.next;
        }

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return head;
    }
}
