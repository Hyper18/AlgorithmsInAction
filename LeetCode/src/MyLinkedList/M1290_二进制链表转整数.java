package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/07/14
 * @file M1290_二进制链表转整数.java
 * <p>
 * 思路
 * 位运算
 */
public class M1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }

        return ans;
    }
}
