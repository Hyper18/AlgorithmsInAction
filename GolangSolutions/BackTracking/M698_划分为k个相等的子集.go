package BackTracking

import "sort"

/*
@author Hyperspace
@date 2024/08/25
@file M698_划分为k个相等的子集.go
*/
func canPartitionKSubsets(nums []int, k int) bool {
	sum := 0
	for _, v := range nums {
		sum += v
	}
	if sum%k != 0 {
		return false
	}
	target := sum / k
	pos := make([]int, k)
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})

	return backtrack(pos, nums, k, 0, target)
}

func backtrack(pos, nums []int, k, i, target int) bool {
	if i == len(nums) {
		return true
	}
	for idx := range pos {
		if pos[idx]+nums[i] > target || (idx > 0 && pos[idx] == pos[idx-1]) {
			continue
		}
		pos[idx] += nums[i]
		if backtrack(pos, nums, k, i+1, target) {
			return true
		}
		pos[idx] -= nums[i]
	}

	return false
}
