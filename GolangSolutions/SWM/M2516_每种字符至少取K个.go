/*
	@author Hyperspace
	@date 2024/09/27
	@file M2516_每种字符至少取K个.go
*/

package SWM

func takeCharacters(s string, k int) (ans int) {
	n := len(s)
	cnt := make([]int, 3)
	for _, c := range s {
		cnt[c-'a']++
	}
	if cnt[0] < k || cnt[1] < k || cnt[2] < k {
		return -1
	}
	l, r := 0, 0
	for r < n {
		cnt[s[r]-'a']--
		r++
		if cnt[0] < k || cnt[1] < k || cnt[2] < k {
			cnt[s[l]-'a']++
			l++
		} else {
			ans = max(ans, r-l)
		}
	}
	ans = n - ans

	return
}
