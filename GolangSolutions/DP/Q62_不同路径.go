/*
	@author Hyperspace
	@date 2024/09/23
	@file Q62_不同路径.go
*/

package DP

func uniquePaths(m int, n int) int {
	f := make([][]int, m)
	for i := range f {
		f[i] = make([]int, n)
		f[i][0] = 1
	}
	for j := 0; j < n; j++ {
		f[0][j] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			f[i][j] = f[i-1][j] + f[i][j-1]
		}
	}

	return f[m-1][n-1]
}

func uniquePaths2(m int, n int) int {
	f := make([]int, n)
	for i := range f {
		f[i] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			f[j] += f[j-1]
		}
	}

	return f[n-1]
}
