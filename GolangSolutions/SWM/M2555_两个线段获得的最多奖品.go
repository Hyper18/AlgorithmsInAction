/*
	@author Hyperspace
	@date 2024/09/11
	@file M2555_两个线段获得的最多奖品.go
*/

package SWM

func maximizeWin(prizePositions []int, k int) (ans int) {
	n := len(prizePositions)
	pre := make([]int, n+1)
	for l, r := 0, 0; r < n; r++ {
		for prizePositions[r]-prizePositions[l] > k {
			l++
		}
		ans = max(ans, pre[l]+r-l+1)
		pre[r+1] = max(pre[r], r-l+1)
	}

	return
}
