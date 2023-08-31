/*
	@author Hyperspace
	@date 2023/08/08
	@file M1749_任意子数组和的绝对值的最大值.go
*/

package Array

func maxAbsoluteSum(nums []int) int {
	preSum, maxSum, minSum := 0, 0, 0
	for _, n := range nums {
		preSum += n
		if preSum > maxSum {
			maxSum = preSum
		}
		if preSum < minSum {
			minSum = preSum
		}
	}

	return maxSum - minSum
}
