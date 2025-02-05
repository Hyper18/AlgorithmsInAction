/*
	@author Hyper
	@date 2022/11/27
	@file M1752_检查数组是否经排序和轮转得到.go
*/

package Array

func check(nums []int) bool {
	n, l := len(nums), 0
	for i := 1; i < n; i++ {
		if nums[i-1] > nums[i] {
			l = i
			break
		}
	}
	if l == 0 {
		return true
	}
	for i := l + 1; i < n; i++ {
		if nums[i-1] > nums[i] {
			return false
		}
	}

	return nums[0] >= nums[n-1]
}
