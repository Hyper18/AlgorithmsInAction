package MyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/10/12
 * <p>
 * 思路
 * hash
 * 一开始做错了，以为head保证自增有序
 * 实际题目不保证head中的元素按照升序或降序排列
 * 因此不能直接对nums排序后遍历一次解决
 * <p>
 * 引入set存储，找每次"组件"开始的位置，依次计数
 */
public class M817_链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode node = head;
        int ans = 0;
        boolean flag = false;
        while (node != null) {
            if (set.contains(node.val)) {
                if (!flag) {
                    flag = true;
                    ans++;
                }
            } else {
                flag = false;
            }
            node = node.next;
        }

        return ans;
    }
}
