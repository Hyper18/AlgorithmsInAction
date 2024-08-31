/*
	@author Hyperspace
	@date 2024/08/28
	@file M3144_分割字符频率相等的最少子字符串.go
*/

package DP

func minimumSubstringsInPartition(s string) int {
	f, freq := make([]int, len(s)), make([]int, 26)
	for i := range f {
		f[i] = i + 1
	}
	var check func(int, int) bool
	check = func(len, size int) bool {
		if len%size != 0 {
			return false
		}
		cnt := len / size
		for _, v := range freq {
			if v > 0 && v != cnt {
				return false
			}
		}

		return true
	}
	for i := range f {
		size := 0
		for j := i; j >= 0; j-- {
			freq[s[j]-'a']++
			if freq[s[j]-'a'] == 1 {
				size++
			}
			if check(i-j+1, size) {
				if j == 0 {
					f[i] = 1
				} else {
					f[i] = min(f[i], f[j-1]+1)
				}
			}
		}
		freq = make([]int, 26)
	}

	return f[len(s)-1]
}
