package MyLinkedList;

/**
 * @author Hyper
 * @date 2022/02/15，2025/03/29
 * <p>
 * 思路
 * 1. 计算链表长度，二次遍历 -- O(l)，l为链表长度
 * 重点在于处理链表长度与n恰好相等的情况
 * 也就是说此时s.next.next为空指针
 * 解决：预处理链表长度，引入一个前序结点进行操作
 * 2. 左右指针
 * r 比 l 快 n 步，若 n 次后为末尾后一个结点，则需删除首结点
 * 否则开始同步遍历直到到达表尾
 * r 先遍历一次，使得最后得到的 l 是需要删除结点的前一结点
 */
public class Q19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head), cur = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        cur = pre;
        while (cnt - n > 0) {
            cnt--;
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return pre.next;
    }

    public ListNode removeNthFromEnd2_0(ListNode head, int n) {
        ListNode l = head, r = head;
        while (n > 0) {
            r = r.next;
            n--;
        }
        if (r == null) {
            return head.next;
        }
        r = r.next;
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), l = dummy, r = dummy;
        while (n-- > 0) {
            r = r.next;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;

        return dummy.next;
    }
}
