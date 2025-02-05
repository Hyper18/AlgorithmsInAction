/*
	@author Hyper
	@date 2024/09/01
	@file Q902_最大为N的数字组合.go
*/

package DigitDP

import (
	"strconv"
)

func atMostNGivenDigitSet(digits []string, n int) int {
	s := strconv.Itoa(n)
	m := len(s)
	memo := make([]int, m)
	for i := range memo {
		memo[i] = -1
	}
	var f func(int, bool, bool) int
	f = func(i int, isLimit, isNum bool) (ans int) {
		if i == m {
			if isNum {
				return 1
			}
			return
		}
		if !isLimit && isNum {
			p := &memo[i]
			if *p != -1 {
				return *p
			}
			defer func() { *p = ans }()
		}
		if !isNum {
			ans = f(i+1, false, false)
		}
		up := byte('9')
		if isLimit {
			up = s[i]
		}
		for _, d := range digits {
			if d[0] <= up {
				ans += f(i+1, isLimit && d[0] == up, true)
			}
		}

		return
	}

	return f(0, true, false)
}
