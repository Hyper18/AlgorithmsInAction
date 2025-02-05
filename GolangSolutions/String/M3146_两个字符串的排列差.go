/*
	@author Hyper
	@date 2024/08/24
	@file M3146_两个字符串的排列差.go
*/

package String

func findPermutationDifference(s string, t string) (ans int) {
	pos := make([]int, 26)
	for i, v := range s {
		pos[v-'a'] = i
	}
	for i, v := range t {
		j := pos[v-'a']
		if i > j {
			ans += i - j
		} else {
			ans += j - i
		}
	}

	return
}

func findPermutationDifference2(s string, t string) (ans int) {
	pos := make([]int, 26)
	for i, v := range s {
		pos[v-'a'] = i
	}
	for i, v := range t {
		ans += abs(i - pos[v-'a'])
	}

	return
}
