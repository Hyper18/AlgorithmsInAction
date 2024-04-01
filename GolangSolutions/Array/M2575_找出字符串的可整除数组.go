/*
	@author Hyperspace
	@date 2024/03/07
	@file M2575_找出字符串的可整除数组.go
*/

package Array

func divisibilityArray(word string, m int) (res []int) {
	num := 0
	for _, w := range word {
		num = (num*10 + int(w-'0')) % m
		if num == 0 {
			res = append(res, 1)
		} else {
			res = append(res, 0)
		}
	}

	return
}
