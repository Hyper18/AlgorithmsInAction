/*
	@author Hyper
	@date 2024/08/21
	@file Q2376_统计特殊整数.go
*/

package DigitDP

import "strconv"

func countSpecialNumbers(n int) int {
	s := strconv.Itoa(n)
	m := len(s)
	memo := make([][1 << 10]int, m)
	for i := range memo {
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}
	var f func(int, int, bool, bool) int
	f = func(i, mask int, isLimit, isNum bool) (ans int) {
		if i == m {
			if isNum {
				return 1
			}
			return
		}
		if !isLimit && isNum {
			p := &memo[i][mask]
			if *p != -1 {
				return *p
			}
			defer func() { *p = ans }()
		}
		if !isNum {
			ans += f(i+1, mask, false, false)
		}
		d := 0
		if !isNum {
			d = 1
		}
		up := 9
		if isLimit {
			up = int(s[i] - '0')
		}
		for ; d <= up; d++ {
			if mask>>d&1 == 0 {
				ans += f(i+1, mask|1<<d, isLimit && d == up, true)
			}
		}

		return
	}

	return f(0, 0, true, false)
}

//// test case example
//func main() {
//	print(countSpecialNumbers(20))
//}
