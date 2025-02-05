/*
	@author Hyper
	@date 2023/08/06
	@file M24_两两交换链表中的节点.go
*/

package LinkedList

func swapPairs(head *ListNode) (dummy *ListNode) {
	if head == nil || head.Next == nil {
		return head
	}
	dummy = head.Next
	head.Next = swapPairs(dummy.Next)
	dummy.Next = head

	return
}

func swapPairs2(head *ListNode) *ListNode {
	dummy := &ListNode{0, head}
	cur := dummy
	for head != nil && head.Next != nil {
		cur.Next = head.Next
		head.Next = head.Next.Next
		cur = cur.Next
		cur.Next = head
		head = head.Next
		cur = cur.Next
	}

	return dummy.Next
}
