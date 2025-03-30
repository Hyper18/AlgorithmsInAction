package MyLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/08/12，2025/03/30
 * @file M23_合并K个升序链表.java
 * <p>
 * 思路
 * 1. 迭代
 * 2. 递归
 * 3. 模拟，小根堆
 */
public class M23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode l : lists) {
            res = mergeTwoLists(res, l);
        }

        return res;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        int mid = j - i;
        if (mid == 0) {
            return null;
        }
        if (mid == 1) {
            return lists[i];
        }

        return mergeTwoLists(mergeKLists(lists, i, i + mid / 2), mergeKLists(lists, i + mid / 2, j));
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);

        return list2;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
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
