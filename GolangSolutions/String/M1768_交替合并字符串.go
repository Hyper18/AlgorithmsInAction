package String

func mergeAlternately(word1 string, word2 string) string {
	n1, n2 := len(word1), len(word2)
	res := make([]byte, 0, n1+n2)
	for i := 0; i < n1 || i < n2; i++ {
		if i < n1 {
			res = append(res, word1[i])
		}
		if i < n2 {
			res = append(res, word2[i])
		}
	}

	return string(res)
}
