/*
	@author Hyper
	@date 2024/09/13
	@file M2398_预算内的最多机器人数目.go
*/

package TwoPointer

func maximumRobots(chargeTimes, runningCosts []int, budget int64) (ans int) {
	q := []int{}
	sum := int64(0)
	l := 0
	for r, t := range chargeTimes {
		for len(q) > 0 && t >= chargeTimes[q[len(q)-1]] {
			q = q[:len(q)-1]
		}
		q = append(q, r)
		sum += int64(runningCosts[r])
		for len(q) > 0 && int64(chargeTimes[q[0]])+int64(r-l+1)*sum > budget {
			if q[0] == l {
				q = q[1:]
			}
			sum -= int64(runningCosts[l])
			l++
		}
		ans = max(ans, r-l+1)
	}

	return
}
