/*
	@author Hyperspace
	@date 2024/09/19
	@file M2414_最长的字母序连续子字符串的长度.go
*/

package DP

func longestContinuousSubstring(s string) int {
	ans, cnt := 1, 1
	for i := 1; i < len(s); i++ {
		if s[i]-s[i-1] == 1 {
			cnt++
		} else {
			ans = max(ans, cnt)
			cnt = 1
		}
	}

	return max(ans, cnt)
}

func longestContinuousSubstring2(s string) (ans int) {
	f := make([]int, len(s))
	f[0] = 1
	for i := 1; i < len(s); i++ {
		if s[i]-s[i-1] == 1 {
			f[i] = f[i-1] + 1
		} else {
			f[i] = 1
		}

	}
	for _, v := range f {
		if v > ans {
			ans = v
		}
	}

	return
}
