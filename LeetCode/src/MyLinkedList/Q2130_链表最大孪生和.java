package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/28
 * @file Q2130_链表最大孪生和.java
 * <p>
 * 思路
 * 原地模拟
 * 快慢指针+反转列表
 * 参见Q876+Q206
 */
public class Q2130_链表最大孪生和 {
    public int pairSum(ListNode head) {
        ListNode head2 = reverseList(middleNode(head));
        int ans = 0;
        while (head2 != null) {
            ans = Math.max(ans, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }

        return ans;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}

