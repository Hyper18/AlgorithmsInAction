package MyLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2023/08/12
 * @file M23_合并K个升序链表.java
 * <p>
 * 思路
 * 一开始抖机灵，废物利用两链合并过了，乐
 * 模拟，小根堆
 */
public class M23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode l : lists) {
            res = mergeTwoLists(res, l);
        }

        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l = new ListNode(), cur = l;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return l.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode l : lists) {
            if (l != null) {
                q.offer(l);
            }
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        while (!q.isEmpty()) {
            ListNode p = q.poll();
            if (p.next != null) {
                q.offer(p.next);
            }
            cur.next = p;
            cur = cur.next;
        }

        return dummy.next;
    }
}
