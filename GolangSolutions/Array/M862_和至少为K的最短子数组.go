package Array

import "math"

func shortestSubarray(nums []int, k int) int {
	n := len(nums)
	// 好处在于不用考虑数据范围的问题
	preSum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		preSum[i] = preSum[i-1] + nums[i-1]
	}

	q := []int{}
	ans := math.MaxInt
	for i, cur := range preSum {
		for len(q) > 0 && cur-preSum[q[0]] >= k {
			ans = min(ans, i-q[0])
			// 队首出栈
			q = q[1:]
		}
		for len(q) > 0 && preSum[q[len(q)-1]] >= cur {
			// 队尾出栈
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}

	if ans == math.MaxInt {
		return -1
	}
	return ans
}
