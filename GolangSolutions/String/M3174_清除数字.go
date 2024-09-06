/*
	@author Hyperspace
	@date 2024/09/05
	@file M3174_清除数字.go
*/

package String

import "unicode"

func clearDigits(s string) string {
	ans := []rune{}
	for _, c := range s {
		if len(ans) > 0 && unicode.IsDigit(c) {
			ans = ans[:len(ans)-1]
			continue
		}
		ans = append(ans, c)
	}

	return string(ans)
}
