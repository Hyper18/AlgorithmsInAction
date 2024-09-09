/*
	@author Hyperspace
	@date 2024/09/09
	@file M2181_合并零之间的节点.go
*/

package LinkedList

func mergeNodes(head *ListNode) *ListNode {
	dummy := &ListNode{}
	cur, sum := dummy, 0
	for head.Next != nil {
		sum += head.Val
		head = head.Next
		if head.Val == 0 && sum != 0 {
			cur.Next = &ListNode{Val: sum}
			sum = 0
			cur = cur.Next
		}
	}

	return dummy.Next
}
