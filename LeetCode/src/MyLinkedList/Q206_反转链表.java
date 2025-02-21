package MyLinkedList;

import java.util.Stack;

/**
 * @author Hyper
 * @date 2022/02/20，2025/02/21
 * <p>
 * 1. stack
 * 2. 原地反转
 * 这种做法属于本题想考察的内容
 * 3. 递归
 * 4. 直接反转值@触不可及
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
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList4(ListNode head) {
        ListNode newHead = null;
        for (ListNode n = head; n != null; n = n.next) {
            newHead = new ListNode(n.val, newHead);
        }

        return newHead;
    }
}
