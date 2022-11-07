package String

func ambiguousCoordinates(s string) (res []string) {
	s = s[1 : len(s)-1]
	n := len(s)

	for i := 1; i < n; i++ {
		sx, sy := split(s[:i]), split(s[i:])
		for _, x := range sx {
			for _, y := range sy {
				res = append(res, "("+x+", "+y+")")
			}
		}
	}

	return
}

func split(s string) (res []string) {
	n := len(s)
	if n == 1 {
		res = append(res, s)
		return
	}

	if s[0] == '0' && s[n-1] == '0' {
		return
	}
	if s[0] == '0' {
		res = append(res, "0."+s[1:])
		return
	}
	if s[n-1] == '0' {
		res = append(res, s)
		return
	}

	res = append(res, s)
	for i := 1; i < n; i++ {
		res = append(res, s[:i]+"."+s[i:])
	}

	return
}
