package BinarySearch

import "sort"

func searchRange(nums []int, target int) (res []int) {
	n := len(nums)
	l := sort.SearchInts(nums, target)
	r := sort.SearchInts(nums, target+1) - 1

	// 前一个条件应该先判断，为避免数组越界
	if l == n || nums[l] != target {
		res = []int{-1, -1}
	} else {
		res = []int{l, r}
	}

	return
}
