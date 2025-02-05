/*
	@author Hyper
	@date 2023/07/09
	@file M15_三数之和.go
*/

package Array

import "sort"

func threeSum(nums []int) (res [][]int) {
	n := len(nums)
	sort.Ints(nums)
	for i, x := range nums {
		if x > 0 {
			break
		}
		if i > 0 && x == nums[i-1] {
			continue
		}
		l, r := i+1, n-1
		for l < r {
			sum := x + nums[l] + nums[r]
			if sum == 0 {
				res = append(res, []int{x, nums[l], nums[r]})
				for l < r && nums[l] == nums[l+1] {
					l++
				}
				for l < r && nums[r] == nums[r-1] {
					r--
				}
				l++
				r--
			} else if sum < 0 {
				l++
			} else {
				r--
			}
		}
	}

	return
}
