package MyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q3217_从链表中移除在数组中存在的节点.java
 * <p>
 * 思路
 * 模拟
 */
public class Q3217_从链表中移除在数组中存在的节点 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null) {
            if (st.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
