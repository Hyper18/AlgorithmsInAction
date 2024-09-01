/*
	@author Hyperspace
	@date 2024/09/01
	@file Q600_不含连续1的非负整数.go
*/

package DigitDP

import "math/bits"

func findIntegers(n int) int {
	m := bits.Len(uint(n))
	memo := make([][2]int, m)
	for i := range memo {
		memo[i] = [2]int{-1, -1}
	}
	var f func(int, int, bool) int
	f = func(i, pre int, isLimit bool) (ans int) {
		if i == m {
			return 1
		}
		if !isLimit {
			p := &memo[i][pre]
			if *p != -1 {
				return *p
			}
			defer func() { *p = ans }()
		}
		up := 1
		if isLimit {
			up = n >> (m - 1 - i) & 1
		}
		ans = f(i+1, 0, isLimit && up == 0)
		if up == 1 && up != pre {
			ans += f(i+1, 1, isLimit)
		}

		return
	}

	return f(0, 0, true)
}
