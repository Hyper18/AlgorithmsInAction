/*
	@author Hyperspace
	@date 2024/08/21
	@file M3007_价值和小于等于K的最大数字.go
*/

package DigitDP

import (
	"math/bits"
	"sort"
)

func findMaximumNumber(k int64, x int) int64 {
	ans := sort.Search(int(k+1)<<x, func(num int) bool {
		num++
		n := bits.Len(uint(num))
		memo := make([][]int, n)
		for i := range memo {
			memo[i] = make([]int, n)
			for j := range memo[i] {
				memo[i][j] = -1
			}
		}
		var f func(int, int, bool) int
		f = func(i, cnt int, isLimit bool) (ans int) {
			if i < 0 {
				return cnt
			}
			if !isLimit {
				p := &memo[i][cnt]
				if *p != -1 {
					return *p
				}
				defer func() { *p = ans }()
			}
			up := 1
			if isLimit {
				up = num >> i & 1
			}
			for d := 0; d <= up; d++ {
				c := cnt
				if d == 1 && (i+1)%x == 0 {
					c++
				}
				ans += f(i-1, c, isLimit && d == up)
			}

			return
		}

		return f(n-1, 0, true) > int(k)
	})

	return int64(ans)
}
