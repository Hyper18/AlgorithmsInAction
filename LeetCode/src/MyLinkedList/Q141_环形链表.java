package MyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/02/19，2023/07/29，2025/03/13
 * <p>
 * 1. set验重 -- 时间 O(n)，空间 O(n)
 * 2. 快慢指针 -- 时间 O(n)，空间 O(1)
 */
public class Q141_环形链表 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
