/*
	@author Hyper
	@date 2024/09/03
	@file M2708_一个小组的最大实力值.go

	Golang在23年8月的1.21.0版本后，内置了max、min和clear函数：
	func max[T cmp.Ordered](x T, y ...T) T
	func min[T cmp.Ordered](x T, y ...T) T
	func clear[T ~[]Type | ~map[Type]Type1](t T)
*/

package Greedy

func maxStrength(nums []int) int64 {
	mn, mx := nums[0], nums[0]
	for _, v := range nums[1:] {
		mn, mx = min(mn, v, mn*v, mx*v), max(mx, v, mn*v, mx*v)
	}

	return int64(mx)
}
