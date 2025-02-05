/*
	@author Hyper
	@date 2022/11/18
	@file M891_子序列宽度之和.go
*/

package Array

import "sort"

func sumSubseqWidths(nums []int) (ans int) {
	const mod int = 1e9 + 7
	n := len(nums)
	sort.Ints(nums)
	f := make([]int, n)
	f[0] = 1
	for i := 1; i < n; i++ {
		f[i] = (f[i-1] << 1) % mod
	}
	for i, num := range nums {
		ans += (f[i] - f[n-1-i]) * num
	}

	// 处理可能的负数情况
	return (ans%mod + mod) % mod
}
