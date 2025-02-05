/*
	@author Hyper
	@date 2024/09/01
	@file M面试题_17_06_2出现的次数.go
*/

package DigitDP

import "strconv"

func numberOf2sInRange(n int) int {
	s := strconv.Itoa(n)
	m := len(s)
	memo := make([][]int, m)
	for i := 0; i < m; i++ {
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
			if *p != -1 {
				return *p
			}
			defer func() {
				*p = ans
			}()
		}
		up := 9
		if isLimit {
			up = int(s[i] - '0')
		}
		for d := 0; d <= up; d++ {
			c := cnt
			if d == 2 {
				c++
			}
			ans += f(i+1, c, isLimit && d == up)
		}

		return
	}

	return f(0, 0, true)
}
