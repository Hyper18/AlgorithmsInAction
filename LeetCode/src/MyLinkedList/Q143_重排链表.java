package MyLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/07/31，2025/03/28
 * @file Q143_重排链表.java
 * <p>
 * 思路
 * 1. List模拟 -- 时间 O(n)，空间 O(n)
 * 2. 原地模拟 -- 时间 O(n)，空间 O(1)
 * 参见Q206+Q876
 * <p>
 * 为什么是 head2.next != null 而非 head.next != null
 * 链表长度为偶数时，head2对应链表更短
 * <p>
 * 为什么是 head2.next != null 而非 head2 != null
 * 链表长度为偶数时，while head2
 * 会导致最后一轮循环中 中间的 ListNode 指向本身
 */
public class Q143_重排链表 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public void reorderList2(ListNode head) {
        ListNode head2 = reverseList(middleNode(head));
        while (head2.next != null) {
            ListNode nxt = head.next, nxt2 = head2.next;
            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = nxt2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
