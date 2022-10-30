package BackTracking

import "unicode"

func letterCasePermutation(s string) (res []string) {
	n := len(s)
	var backtrack func([]byte, int)
	backtrack = func(s []byte, idx int) {
		for idx < n && unicode.IsDigit(rune(s[idx])) {
			idx++
		}
		if idx == n {
			res = append(res, string(s))
			return
		}
		s[idx] ^= 32
		backtrack(s, idx+1)
		s[idx] ^= 32
		backtrack(s, idx+1)
	}
	backtrack([]byte(s), 0)

	return
}
