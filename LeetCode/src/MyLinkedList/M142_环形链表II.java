package MyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2023/07/30
 * @file M142_环形链表II.java
 * <p>
 * 思路
 * 1. set验重
 * 2. 快慢指针
 * 前同Q141
 * 第一次相遇时，将快指针指向head，一同走至第二次相遇
 * 证：设head到环头距离为a，环长为b，fast走过的环圈数为n，第一次相遇时有：
 * dis(fast) = 2 * dis(slow) = dis(slow) + n * b
 * 得dis(fast) = 2nb， dis(slow) = nb
 * 此时需再走a步到达环头
 */
public class M142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return fast;
            }
        }
    }
}
