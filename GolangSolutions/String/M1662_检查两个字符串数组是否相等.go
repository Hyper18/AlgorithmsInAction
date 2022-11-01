package String

import "strings"

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	return strings.EqualFold(strings.Join(word1, ""), strings.Join(word2, ""))
}

func arrayStringsAreEqual2(word1 []string, word2 []string) bool {
	n1, n2 := len(word1), len(word2)
	var p1, p2, i, j int
	for p1 < n1 && p2 < n2 {
		if word1[p1][i] != word2[p2][j] {
			return false
		}
		i++
		j++
		if i == len(word1[p1]) {
			p1++
			i = 0
		}
		if j == len(word2[p2]) {
			p2++
			j = 0
		}
	}

	return p1 == n1 && p2 == n2
}
