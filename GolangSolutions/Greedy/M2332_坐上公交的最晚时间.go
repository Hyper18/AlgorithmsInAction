/*
	@author Hyperspace
	@date 2024/09/18
	@file M2332_坐上公交的最晚时间.go
*/

package Greedy

import "sort"

func latestTimeCatchTheBus(buses []int, passengers []int, capacity int) (ans int) {
	sort.Ints(buses)
	sort.Ints(passengers)
	j := 0
	for _, lastBus := range buses {
		cnt := 0
		for j < len(passengers) && cnt < capacity && passengers[j] <= lastBus {
			if j == 0 || passengers[j-1] != passengers[j]-1 {
				ans = max(ans, passengers[j]-1)
			}
			j++
			cnt++
		}
		if cnt < capacity && (j == 0 || passengers[j-1] != lastBus) {
			ans = max(ans, lastBus)
		}
	}

	return
}
