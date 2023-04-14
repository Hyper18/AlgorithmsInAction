/*
	@author Hyperspace
	@date 2023/03/02
	@file Q76_最小覆盖子串.go
*/

package SWM

func minWindow(s string, t string) string {
	n1, n2 := len(s), len(t)
	cnt1, cnt2 := [58]int{}, [58]int{}
	for _, c := range t {
		cnt2[c-'A']++
	}
	minL, minR, cnt, l, r := 0, n1, 0, 0, 0
	for r < n1 {
		cr := s[r]
		cnt1[cr-'A']++
		if cnt1[cr-'A'] <= cnt2[cr-'A'] {
			cnt++
		}
		for cnt == n2 {
			if minR-minL > r-l {
				minL = l
				minR = r
			}
			cl := s[l]
			if cnt1[cl-'A'] <= cnt2[cl-'A'] {
				cnt--
			}
			cnt1[cl-'A']--
			l++
		}
		r++
	}

	if minR == n1 {
		return ""
	}
	return s[minL : minR+1]
}
