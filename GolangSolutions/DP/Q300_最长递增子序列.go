package DP

func lengthOfLIS(nums []int) int {
	n, ans := len(nums), 0
	f := make([]int, n)
	for i := 0; i < n; i++ {
		f[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && f[j]+1 > f[i] {
				f[i] = f[j] + 1
			}
		}
		if f[i] > ans {
			ans = f[i]
		}
	}

	return ans
}

func lengthOfLIS2(nums []int) int {
	n, ans := len(nums), 0
	f := make([]int, n)
	for i := 0; i < n; i++ {
		low, high := 0, ans
		for low < high { // go没有while关键字
			mid := low + (high-low)/2
			if f[mid] < nums[i] {
				low = mid + 1
			} else {
				high = mid
			}
		}
		f[low] = nums[i]
		if ans == high {
			ans++
		}
	}

	return ans
}
