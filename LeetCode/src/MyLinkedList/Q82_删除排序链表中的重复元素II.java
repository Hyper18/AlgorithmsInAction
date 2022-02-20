package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2022/02/20
 * <p>
 * 1. 迭代 双指针
 * 2. 递归
 */
public class Q82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (pre.next.val != cur.next.val) {
                pre = pre.next;
            } else {
                while (cur.next != null && pre.next.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates2(head.next);
        } else {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            return deleteDuplicates2(head.next);
        }

        return head;
    }
}
