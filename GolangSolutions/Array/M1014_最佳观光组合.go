/*
	@author Hyperspace
	@date 2024/09/23
	@file M1014_最佳观光组合.go
*/

package Array

func maxScoreSightseeingPair(values []int) (ans int) {
	mx := values[0]
	for j := 1; j < len(values); j++ {
		ans = max(ans, mx+values[j]-j)
		mx = max(mx, values[j]+j)
	}

	return
}
