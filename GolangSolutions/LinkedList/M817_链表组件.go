package LinkedList

type ListNode struct {
	Val  int
	Next *ListNode
}

// 可以直接在(ans int)声明返回值，返回时直接写return，ans其作用域依然是函数本身
func numComponents(head *ListNode, nums []int) (ans int) {
	set := make(map[int]struct{}, len(nums))
	for _, v := range nums { // range返回的是[index, value], _为忽略前一个返回值
		set[v] = struct{}{}
	}

	node := head
	for flag := false; node != nil; node = node.Next {
		if _, ok := set[node.Val]; !ok {
			flag = false
		} else if !flag {
			flag = true
			ans++
		}
	}

	return
}
