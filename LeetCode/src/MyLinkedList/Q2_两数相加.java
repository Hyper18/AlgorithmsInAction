package MyLinkedList;

/**
 * @author Hyper
 * @date 2022/02/20，2023/07/02，2025/03/28
 * <p>
 * 思路
 * 1. 模拟
 * 同位数字直接相加
 * 重点在于解决两数相加的进位溢出问题
 * 如果同一位上产生进位，则依次判断是否为最高位
 * 是最高位，则使用新结点表示
 * 不是最高位，直接在后一结点（更高位）+1，同时更改本位结果
 * <p>
 * 2. 模拟优化
 * 不改变原链表
 * 在结果链表新增结点时，通过设置进位处理
 */
public class Q2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), dummy1 = new ListNode(0, l1), dummy2 = new ListNode(0, l2);
        ListNode cur = dummyHead;
        while (dummy1.next != null && dummy2.next != null) {
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
            int sum = dummy1.val + dummy2.val;
            if (sum >= 10) {
                ListNode last = new ListNode(1);
                if (dummy1.next == null && dummy2.next == null) {
                    dummy1.next = last;
                } else if (dummy1.next == null) {
                    dummy1.next = last;
                } else if (dummy2.next == null) {
                    dummy2.next = last;
                } else {
                    dummy1.next.val++;
                }
                sum %= 10;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        cur.next = dummy1.next == null ? dummy2.next : dummy1.next;

        return dummyHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val, y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum >= 10 ? 1 : 0;
            sum %= 10;
            cur = cur.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
