package MyLinkedList;

/**
 * @author Hyper
 * @date 2025/02/21，2025/03/28
 * @file Q234_回文链表.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 原地模拟
 * 快慢指针+反转列表
 * 参见Q876+Q206
 */
public class Q234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.substring(0, sb.length() / 2).equals(sb.reverse().substring(0, sb.length() / 2));
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode mid = middleNode(head), head2 = reverseList(mid);
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
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
