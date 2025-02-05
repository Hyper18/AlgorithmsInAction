package MyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/02/20
 * <p>
 * 1. set去重
 * 2. 利用 已排序 特点
 */
public class Q83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (seen.add(cur.next.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }

        return head;
    }
}
