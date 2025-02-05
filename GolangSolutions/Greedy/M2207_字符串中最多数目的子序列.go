/*
	@author Hyper
	@date 2024/09/24
	@file M2207_字符串中最多数目的子序列.go
*/

package Greedy

func maximumSubsequenceCount(text string, pattern string) (ans int64) {
	cnt1, cnt2 := 0, 0
	for _, c := range text {
		if uint8(c) == pattern[1] {
			ans += int64(cnt1)
			cnt2++
		}
		if uint8(c) == pattern[0] {
			cnt1++
		}
	}
	ans += int64(max(cnt1, cnt2))

	return
}

func maximumSubsequenceCount2(text string, pattern string) (ans int64) {
	cnt1, cnt2 := 0, 0
	for i := range text {
		c := text[i]
		if c == pattern[1] {
			ans += int64(cnt1)
			cnt2++
		}
		if c == pattern[0] {
			cnt1++
		}
	}
	ans += int64(max(cnt1, cnt2))

	return
}
