/*
	@author Hyper
	@date 2023/07/10
	@file M16_最接近的三数之和.go
*/

package TwoPointer

import (
	"math"
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	n := len(nums)
	sort.Ints(nums)
	ans, diff := 0, math.MaxInt
	for i := 0; i < n-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		minSum := nums[i] + nums[i+1] + nums[i+2]
		if minSum > target {
			if minSum-target < diff {
				ans = minSum
			}
			break
		}
		maxSum := nums[i] + nums[n-1] + nums[n-2]
		if maxSum < target {
			if target-maxSum < diff {
				diff = target - maxSum
				ans = maxSum
			}
			continue
		}
		low, high := i+1, n-1
		for low < high {
			s := nums[i] + nums[low] + nums[high]
			if s == target {
				return target
			}
			if s > target {
				if s-target < diff {
					diff = s - target
					ans = s
				}
				high--
			} else {
				if target-s < diff {
					diff = target - s
					ans = s
				}
				low++
			}
		}
	}

	return ans
}
