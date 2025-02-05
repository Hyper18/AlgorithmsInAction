/*
	@author Hyper
	@date 2023/07/02
	@file Q2_两数相加.go
*/

package LinkedList

func addTwoNumbers(l1 *ListNode, l2 *ListNode) (h *ListNode) {
	cur, c := h, 0
	for l1 != nil || l2 != nil {
		v1, v2 := 0, 0
		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}
		if h == nil {
			h = &ListNode{Val: (v1 + v2 + c) % 10}
			c = (v1 + v2 + c) / 10
			cur = h
		} else {
			cur.Next = &ListNode{Val: (v1 + v2 + c) % 10}
			c = (v1 + v2 + c) / 10
			cur = cur.Next
		}
	}
	if c > 0 {
		cur.Next = &ListNode{Val: c}
	}

	return
}

func addTwoNumbers2(l1 *ListNode, l2 *ListNode) *ListNode {
	h := ListNode{}
	cur, c := &h, 0
	for l1 != nil || l2 != nil {
		v1, v2 := 0, 0
		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}
		sum := v1 + v2 + c
		cur.Next = &ListNode{Val: sum % 10}
		c = sum / 10
		cur = cur.Next
	}
	if c > 0 {
		cur.Next = &ListNode{Val: c}
	}

	return h.Next
}
