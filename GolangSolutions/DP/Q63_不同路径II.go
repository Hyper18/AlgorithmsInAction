/*
	@author Hyperspace
	@date 2024/09/23
	@file Q63_不同路径II.go
*/

package DP

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	f := make([][]int, m)
	for i := range f {
		f[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				f[i][j] = 0
			} else if i == 0 && j == 0 {
				f[i][j] = 1
			} else if i == 0 {
				f[i][j] = f[0][j-1]
			} else if j == 0 {
				f[i][j] = f[i-1][0]
			} else {
				f[i][j] = f[i-1][j] + f[i][j-1]
			}
		}
	}

	return f[m-1][n-1]
}

func uniquePathsWithObstacles2(obstacleGrid [][]int) int {
	n := len(obstacleGrid[0])
	f := make([]int, n)
	if obstacleGrid[0][0] == 0 {
		f[0] = 1
	}
	for _, obs := range obstacleGrid {
		for j := 0; j < n; j++ {
			if obs[j] == 1 {
				f[j] = 0
			} else if j-1 >= 0 && obs[j-1] == 0 {
				f[j] += f[j-1]
			}
		}
	}

	return f[n-1]
}
