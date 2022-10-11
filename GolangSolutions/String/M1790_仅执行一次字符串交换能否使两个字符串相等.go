package String

func areAlmostEqual(s1 string, s2 string) bool {
	if s1 == s2 {
		return true
	}
	n := len(s1)
	t1, t2 := uint8(' '), uint8(' ')
	flag := false
	for i := 0; i < n; i++ {
		if s1[i] != s2[i] {
			if t1 == ' ' {
				t1 = s1[i]
				t2 = s2[i]
			} else if !flag && t1 == s2[i] && t2 == s1[i] {
				flag = true
			} else {
				return false
			}
		}
	}

	return flag
}

func areAlmostEqual2(s1 string, s2 string) bool {
	i, j := -1, -1
	for idx := range s1 {
		if s1[idx] != s2[idx] {
			if i < 0 {
				i = idx
			} else if j < 0 {
				j = idx
			} else {
				return false
			}
		}
	}

	return i < 0 || j >= 0 && s1[i] == s2[j] && s1[j] == s2[i]
}
