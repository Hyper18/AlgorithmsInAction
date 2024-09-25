/*
	@author Hyperspace
	@date 2024/09/25
	@file M2306_公司命名.go
*/

package String

func distinctNames(ideas []string) (ans int64) {
	st := [26]map[string]bool{}
	for i := range st {
		st[i] = map[string]bool{}
	}
	for _, s := range ideas {
		st[s[0]-'a'][s[1:]] = true
	}
	for i, a := range st {
		for _, b := range st[:i] {
			cnt := 0
			for s := range a {
				if b[s] {
					cnt++
				}
			}
			ans += int64(len(a)-cnt) * int64(len(b)-cnt)
		}
	}
	ans <<= 1

	return
}
