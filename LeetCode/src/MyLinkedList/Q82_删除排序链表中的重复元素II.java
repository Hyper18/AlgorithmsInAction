package MyLinkedList;

/**
 * @author Hyper
 * @date 2022/02/20，2025/03/29
 * <p>
 * 1. 迭代
 * 2. 递归
 */
public class Q82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int v = cur.next.val;
            if (v == cur.next.next.val) {
                while (cur.next != null && v == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
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
