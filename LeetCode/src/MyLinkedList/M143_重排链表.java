package MyLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/07/31
 * @file M143_重排链表.java
 * <p>
 * 思路
 * 模拟
 */
public class M143_重排链表 {
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
}
