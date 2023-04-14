/*
	@author Hyperspace
	@date 2023/03/04
	@file Q567_字符串的排列.go
*/

package SWM

func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	n1, n2 := len(s1), len(s2)
	cnt1, cnt2 := [26]int{}, [26]int{}
	for _, c := range s1 {
		cnt1[c-'a']++
	}
	cnt, l, r := 0, 0, 0
	for r < n2 {
		if cnt1[s2[r]-'a'] != 0 {
			cnt2[s2[r]-'a']++
			if cnt2[s2[r]-'a'] == cnt1[s2[r]-'a'] {
				cnt++
			}
		}
		if r-l+1 == n1 {
			size := 0
			for _, c := range cnt1 {
				if c != 0 {
					size++
				}
			}
			if cnt == size {
				return true
			}
			if cnt1[s2[l]-'a'] != 0 {
				if cnt2[s2[l]-'a'] == cnt1[s2[l]-'a'] {
					cnt--
				}
				cnt2[s2[l]-'a']--
			}
			l++
		}
		r++
	}

	return false
}
