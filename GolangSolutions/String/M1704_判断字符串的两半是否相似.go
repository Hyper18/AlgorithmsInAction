/*
   @author Hyper
   @date 2022/11/11
   @file M1704_判断字符串的两半是否相似.go
*/

package String

import "strings"

func halvesAreAlike(s string) bool {
	words, cnt := "aeiouAEIOU", 0
	for _, c := range s[:len(s)/2] {
		if strings.ContainsRune(words, c) {
			cnt++
		}
	}
	for _, c := range s[len(s)/2:] {
		if strings.ContainsRune(words, c) {
			cnt--
		}
	}

	return cnt == 0
}
