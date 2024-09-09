package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2024/09/09
 * @file M2181_合并零之间的节点.java
 * <p>
 * 思路
 * 模拟，依次收集非零元素之和
 */
public class M2181_合并零之间的节点 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (head.next != null) {
            sum += head.val;
            head = head.next;
            if (head.val == 0 && sum != 0) {
                cur.next = new ListNode(sum);
                sum = 0;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
