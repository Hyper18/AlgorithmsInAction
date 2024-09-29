/*
	@author Hyperspace
	@date 2024/09/29
	@file M2073_买票需要的时间.go
*/

package Array

func timeRequiredToBuy(tickets []int, k int) (ans int) {
	s := tickets[k]
	for i, t := range tickets {
		if i > k {
			ans += min(t, s-1)
		} else {
			ans += min(t, s)
		}
	}

	return
}
