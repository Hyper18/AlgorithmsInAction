/*
	@author Hyper
	@date 2024/10/09
	@file M3171_找到按位或最接近K的子数组.go
*/

package BitOp

import "math"

func minimumDifference(nums []int, k int) int {
	ans := math.MaxInt
	for i, t := range nums {
		ans = min(ans, abs(t-k))
		for j := i - 1; j >= 0 && (nums[j]|t) != nums[j]; j-- {
			nums[j] |= t
			ans = min(ans, abs(nums[j]-k))
		}
	}

	return ans
}
