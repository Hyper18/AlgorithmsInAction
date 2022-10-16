package Bipartite

const (
	M int = 10010 * 2
	N int = 2010
)

func possibleBipartition(n int, dislikes [][]int) bool {
	// 注意可见性
	var h, color [N]int
	var e, ne [M]int
	idx := 0
	for i := range h {
		h[i] = -1
	}

	var addEdge func(int, int)
	addEdge = func(a, b int) {
		e[idx] = b
		ne[idx] = h[a]
		h[a] = idx
		idx++
	}

	for _, d := range dislikes {
		a, b := d[0], d[1]
		addEdge(a, b)
		addEdge(b, a)
	}

	var dfs func(int, int) bool
	dfs = func(u, c int) bool {
		color[u] = c
		for i := h[u]; i != -1; i = ne[i] {
			j := e[i]
			if color[j] == c {
				return false
			}
			if color[j] == 0 && !dfs(j, 3-c) {
				return false
			}
		}

		return true
	}

	for i := 1; i <= n; i++ {
		if color[i] == 0 {
			if !dfs(i, 1) {
				return false
			}
		}
	}

	return true
}
