/*
	@author Hyperspace
	@date 2023/04/15
	@file M1042_不邻接植花.go
*/

package main

func gardenNoAdj(n int, paths [][]int) []int {
	N := int(1e4 + 5)
	M := N * 3
	e, ne, h, ans, idx := make([]int, M), make([]int, M), make([]int, N), make([]int, N), 0

	addEdge := func(a, b int) {
		e[idx] = b
		ne[idx] = h[a]
		h[a] = idx
		idx++
	}

	for i := 0; i < N; i++ {
		h[i] = -1
	}

	for _, p := range paths {
		a, b := p[0], p[1]
		addEdge(a, b)
		addEdge(b, a)
	}

	var dfs func(u, c int) bool
	dfs = func(u, c int) bool {
		ans[u] = c
		for i := h[u]; i != -1; i = ne[i] {
			j := e[i]
			if ans[j] == c {
				return false
			}
			if ans[j] == 0 && !dfs(j, ((c+1-1)%4)+1) && !dfs(j, ((c+2-1)%4)+1) && !dfs(j, ((c+3-1)%4)+1) {
				return false
			}
		}

		return true
	}

	for i := 1; i <= n; i++ {
		if ans[i] == 0 {
			dfs(i, 1)
		}
	}

	return ans[1 : n+1]
}
