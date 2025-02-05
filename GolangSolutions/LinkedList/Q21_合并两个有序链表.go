/*
	@author Hyper
	@date 2023/08/05
	@file Q21_合并两个有序链表.go
*/

package LinkedList

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	l := &ListNode{}
	cur := l
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			cur.Next = list1
			list1 = list1.Next
		} else {
			cur.Next = list2
			list2 = list2.Next
		}
		cur = cur.Next
	}
	if list1 != nil {
		cur.Next = list1
	}
	if list2 != nil {
		cur.Next = list2
	}

	return l.Next
}
