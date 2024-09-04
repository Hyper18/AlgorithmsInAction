/*
	@author Hyperspace
	@date 2024/09/04
	@file M2860_让所有学生保持开心的分组方法数.go
*/

package Array

import "sort"

func countWays(nums []int) (ans int) {
	sort.Ints(nums)
	if nums[0] > 0 {
		ans = 2
	} else {
		ans = 1
	}
	for i := len(nums) - 1; i > 0; i-- {
		if nums[i] > i && nums[i-1] < i {
			ans++
		}
	}

	return
}
