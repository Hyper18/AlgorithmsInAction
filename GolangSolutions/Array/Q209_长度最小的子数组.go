package Array

import "math"

func minSubArrayLen(target int, nums []int) int {
	n := len(nums)
	ans := math.MaxInt
	for i := range nums {
		sum := 0
		for j := i; j < n; j++ {
			sum += nums[j]
			if sum >= target {
				if j-i+1 < ans {
					ans = j - i + 1
				}
				break
			}
		}
	}

	if ans == math.MaxInt {
		return 0
	} else {
		return ans
	}
}

func minSubArrayLen2(target int, nums []int) int {
	n := len(nums)
	ans := math.MaxInt
	sum := 0

	start, end := 0, 0
	for end < n {
		sum += nums[end]
		for sum >= target {
			if end-start+1 < ans {
				ans = end - start + 1
			}
			sum -= nums[start]
			start++
		}
		end++
	}

	if ans == math.MaxInt {
		return 0
	} else {
		return ans
	}
}
