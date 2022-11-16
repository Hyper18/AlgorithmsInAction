/*
   @author Hyperspace
   @date 2022/11/13
   @file M791_自定义字符串排序.go
*/

package String

import "sort"

func customSortString(order string, s string) (res string) {
	cnt := make([]int, 26)
	for _, c := range s {
		cnt[c-'a']++
	}
	for _, c := range order {
		for cnt[c-'a'] > 0 {
			res += string(c)
			cnt[c-'a']--
		}
	}
	for i := range cnt {
		for cnt[i] > 0 {
			res += string(i + 'a')
			cnt[i]--
		}
	}

	return
}

func customSortString2(order string, s string) string {
	cnt := make([]int, 26)
	for _, c := range s {
		cnt[c-'a']++
	}
	var res []rune
	for _, c := range order {
		for cnt[c-'a'] > 0 {
			res = append(res, c)
			cnt[c-'a']--
		}
	}
	for i := range cnt {
		for cnt[i] > 0 {
			res = append(res, rune(i+'a'))
			cnt[i]--
		}
	}

	return string(res)
}

func customSortString3(order string, s string) string {
	weight := map[rune]int{}
	for i, c := range order {
		weight[c] = i + 1
	}
	t := []rune(s)
	sort.Slice(t, func(i, j int) bool {
		return weight[t[i]] < weight[t[j]]
	})

	return string(t)
}

func customSortString4(order string, s string) string {
	weight := make([]int, 26)
	for i, c := range order {
		weight[c-'a'] = i + 1
	}
	t := []rune(s)
	sort.Slice(t, func(i, j int) bool {
		return weight[t[i]-'a'] < weight[t[j]-'a']
	})

	return string(t)
}
