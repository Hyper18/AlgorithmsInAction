/*
	@author Hyperspace
	@date 2024/03/14
	@file M2789_合并后数组中的最大元素.go
	golang可以直接在原数组上操作
	适用此操作的还有Py3/JS这样自动推断类型的语言
*/

package Greedy

func maxArrayValue(nums []int) int64 {
	n := len(nums)
	for i := n - 1; i > 0; i-- {
		if nums[i] >= nums[i-1] {
			nums[i-1] += nums[i]
		}
	}

	return int64(nums[0])
}
