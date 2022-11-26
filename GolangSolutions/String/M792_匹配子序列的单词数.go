/*
	@author Hyperspace
	@date 2022/11/17
	@file M792_匹配子序列的单词数.go
*/

package String

import "sort"

func numMatchingSubseq(s string, words []string) (ans int) {
	pos := [26][]int{}
	for i, c := range s {
		pos[c-'a'] = append(pos[c-'a'], i)
	}

	check := func(s string) bool {
		idx := -1
		for _, c := range s {
			li := pos[c-'a']
			r := sort.SearchInts(li, idx+1)
			if r == len(li) {
				return false
			}
			idx = li[r]
		}

		return true
	}

	for _, word := range words {
		if check(word) {
			ans++
		}
	}

	return
}
