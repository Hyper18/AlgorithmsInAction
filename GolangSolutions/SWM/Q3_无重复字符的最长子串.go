/*
	@author Hyper
	@date 2023/02/28
	@file Q3_无重复字符的最长子串.go
*/

package SWM

func lengthOfLongestSubstring(s string) (ans int) {
	n := len(s)
	mp := map[uint8]int{}
	for l, r := 0, 0; r < n; r++ {
		c := s[r]
		_, ok := mp[c]
		if ok {
			l = max(l, mp[c]+1)
		}
		mp[c] = r
		ans = max(ans, r-l+1)
	}

	return
}
