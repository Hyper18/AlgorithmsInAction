/*
	@author Hyperspace
	@date 2023/08/16
	@file M2682_找出转圈游戏输家.go
*/

package Array

func circularGameLosers(n int, k int) (ans []int) {
	f := make([]bool, n)
	for i, step := 0, k; !f[i]; step += k {
		f[i] = true
		i = (i + step) % n
	}
	for i, visited := range f {
		if !visited {
			ans = append(ans, i+1)
		}
	}

	return
}
