/*
	@author Hyperspace
	@date 2023/03/05
	@file Q1658_将x减到0的最小操作数.go
*/

package Array

import "math"

func minOperations(nums []int, x int) int {
	n := len(nums)
	if nums[0] > x && nums[n-1] > x {
		return -1
	}
	pre := [100010]int{}
	for i := 1; i <= n; i++ {
		pre[i] = pre[i-1] + nums[i-1]
	}
	ans := math.MaxInt
	for i := n - 1; i >= 0 && x >= 0; i-- {
		l, r, low, high := -1, n-1-i, 0, i+1
		for low <= high {
			mid := low + ((high - low) >> 1)
			if pre[mid] == x {
				l = mid
				break
			} else if pre[mid] > x {
				high = mid - 1
			} else {
				low = mid + 1
			}
		}
		if l >= 0 && l+r < ans {
			ans = l + r
		}
		x -= nums[i]
	}

	if ans == math.MaxInt {
		return -1
	}
	return ans
}
