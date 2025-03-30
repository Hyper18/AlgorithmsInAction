package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q148_排序链表.java
 * <p>
 * 思路
 * 合并两个有序列表+快慢指针
 * 参见Q21+Q876
 * <p>
 * 注意需要断开 slow 的前一个节点和 slow 的连接
 */
public class Q148_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = middleNode(head);
        head = sortList(head);
        head2 = sortList(head2);

        return mergeTwoLists(head, head2);
    }

    private ListNode middleNode(ListNode head) {
        ListNode pre = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        return slow;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);

        return list2;
    }
}
