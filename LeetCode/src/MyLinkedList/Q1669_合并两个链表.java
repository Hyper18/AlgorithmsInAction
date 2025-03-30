package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q1669_合并两个链表.java
 * <p>
 * 思路
 * 左右指针
 */
public class Q1669_合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l = list1, r = list1;
        while (a-- > 1) {
            l = l.next;
        }
        while (b-- > 0) {
            r = r.next;
        }
        l.next = list2;
        ListNode cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = r.next;

        return list1;
    }
}
