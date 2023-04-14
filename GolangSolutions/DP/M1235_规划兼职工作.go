package DP

import (
	"sort"
)

const N int = 50010

func jobScheduling(startTime []int, endTime []int, profit []int) int {
	n := len(startTime)
	jobs := make([][3]int, n)
	for i := range startTime {
		jobs[i] = [3]int{startTime[i], endTime[i], profit[i]}
	}
	sort.Slice(jobs, func(i, j int) bool { return jobs[i][1] < jobs[j][1] })

	f := make([]int, N)
	for i := 1; i <= n; i++ {
		last := sort.Search(i, func(j int) bool { return jobs[j][1] > jobs[i-1][0] })
		f[i] = max(f[i-1], f[last]+jobs[i-1][2])
	}

	return f[n]
}
