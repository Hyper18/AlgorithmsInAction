/*
	@author Hyperspace
	@date 2024/09/22
	@file M997_找到小镇的法官.go
*/

package Graph

func findJudge(n int, trust [][]int) int {
	in, out := make([]int, n+1), make([]int, n+1)
	for _, e := range trust {
		in[e[1]]++
		out[e[0]]++
	}
	for i := 1; i <= n; i++ {
		if in[i] == n-1 && out[i] == 0 {
			return i
		}
	}

	return -1
}
