package TwoPointer;

/**
 * @author Hyperspace
 * @date 2022/02/15
 * <p>
 * 思路
 * 1. 单指针法 -- O(N)
 * 2. 优化，快慢双指针 -- O(N)
 * 注意规避空指针
 */
public class Q876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        int cnt = 0;
        while (s instanceof ListNode) {
            s = s.next;
            cnt++;
        }
        cnt /= 2;
        while (cnt > 0) {
            head = head.next;
            cnt--;
        }
        return head;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
