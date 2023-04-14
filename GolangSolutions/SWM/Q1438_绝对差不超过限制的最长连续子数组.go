/*
	@author Hyperspace
	@date 2023/03/04
	@file Q1438_绝对差不超过限制的最长连续子数组.go
*/

package SWM

func longestSubarray(nums []int, limit int) (ans int) {
	var qMin, qMax []int
	l := 0
	for r, num := range nums {
		for len(qMin) > 0 && qMin[len(qMin)-1] > num {
			qMin = qMin[:len(qMin)-1]
		}
		qMin = append(qMin, num)
		for len(qMax) > 0 && qMax[len(qMax)-1] < num {
			qMax = qMax[:len(qMax)-1]
		}
		qMax = append(qMax, num)
		for len(qMin) > 0 && len(qMax) > 0 && qMax[0]-qMin[0] > limit {
			if nums[l] == qMin[0] {
				qMin = qMin[1:]
			}
			if nums[l] == qMax[0] {
				qMax = qMax[1:]
			}
			l++
		}
		if r-l+1 > ans {
			ans = r - l + 1
		}
	}

	return
}
