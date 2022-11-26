/*
	@author Hyperspace
	@date 2022/11/19
	@file M1732_找到最高海拔.go
*/

package Array

func largestAltitude(gain []int) (ans int) {
	h := 0
	for _, v := range gain {
		h += v
		if h > ans {
			ans = h
		}
	}

	return
}
