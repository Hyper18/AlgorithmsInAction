/*
	@author Hyperspace
	@date 2024/08/23
	@file Q233_数字1的个数.go
*/

package DigitDP

import "strconv"

func countDigitOne(n int) int {
	s := strconv.Itoa(n)
	m := len(s)
	memo := make([][]int, m)
	for i := range memo {
		memo[i] = make([]int, m)
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}
	var f func(int, int, bool) int
	f = func(i, cnt int, isLimit bool) (ans int) {
		if i == m {
			return cnt
		}
		if !isLimit {
			p := &memo[i][cnt]
			if *p >= 0 {
				return *p
			}
			defer func() { *p = ans }()
		}
		d := 0
		up := 9
		if isLimit {
			up = int(s[i] - '0')
		}
		for ; d <= up; d++ {
			c := cnt
			if d == 1 {
				c++
			}
			ans += f(i+1, c, isLimit && d == up)
		}
		return
	}

	return f(0, 0, true)
}
