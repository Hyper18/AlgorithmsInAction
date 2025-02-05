/*
	@author Hyper
	@date 2023/07/08
	@file M2679_矩阵中的和.go
*/

package Array

import (
	"math"
	"sort"
)

func matrixSum(nums [][]int) (ans int) {
	for _, a := range nums {
		sort.Ints(a)
	}
	for j := range nums[0] {
		t := math.MinInt
		for i := range nums {
			if nums[i][j] > t {
				t = nums[i][j]
			}
		}
		ans += t
	}

	return
}
