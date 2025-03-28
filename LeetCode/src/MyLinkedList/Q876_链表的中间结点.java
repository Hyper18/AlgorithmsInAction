package MyLinkedList;

/**
 * @author Hyper
 * @date 2022/02/15，2025/02/21，2025/03/28
 * <p>
 * 思路
 * 1. 模拟 -- O(n)
 * 2. 快慢指针 -- O(n)
 * <p>
 * 注意规避空指针
 */
public class Q876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        cnt >>= 1;
        while (cnt > 0) {
            head = head.next;
            cnt--;
        }

        return head;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
