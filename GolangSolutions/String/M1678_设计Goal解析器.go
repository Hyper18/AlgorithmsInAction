package String

import "strings"

func interpret(cmd string) string {
	res := &strings.Builder{}
	for i, c := range cmd {
		if c == 'G' {
			res.WriteByte('G')
		} else if c == '(' {
			if cmd[i+1] == 'a' {
				res.WriteString("al")
			} else {
				res.WriteByte('o')
			}
		}
	}

	return res.String()
}
