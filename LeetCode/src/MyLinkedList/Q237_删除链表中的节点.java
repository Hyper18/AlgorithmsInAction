package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q237_删除链表中的节点.java
 * <p>
 * 思路
 * 模拟
 * 由于给定了要删除的节点
 * 可以直接把下个节点copy过来
 * 并指向下个节点的下个节点
 */
public class Q237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
