/*
	@author Hyperspace
	@date 2023/05/01
	@file M1376_通知所有员工所需的时间.go
*/

package Tree

func numOfMinutes(n int, headID int, manager []int, informTime []int) (ans int) {
	g := make([][]int, n)

	for i, m := range manager {
		if manager[i] > -1 {
			g[m] = append(g[m], i)
		}
	}

	var dfs func(int, int)
	dfs = func(cur, sum int) {
		sum += informTime[cur]
		ans = max(ans, sum)
		for _, e := range g[cur] {
			dfs(e, sum)
		}
	}

	dfs(headID, 0)

	return
}

func max(a, b int) int {
	if b > a {
		return b
	}
	return a
}
