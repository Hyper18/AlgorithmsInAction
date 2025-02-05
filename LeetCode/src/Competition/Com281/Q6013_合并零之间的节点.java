package Competition.Com281;

/**
 * @author Hyper
 * @date 2022/02/20
 */
public class Q6013_合并零之间的节点 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (head.next != null) {
            head = head.next;
            sum += head.val;
            if (head.val == 0 && sum != 0) {
                cur.next = new ListNode(sum);
                sum = 0;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
