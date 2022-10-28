package BinarySearch

func findMin(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	for l < r {
		m := l + (r-l)>>1
		if nums[m] >= nums[r] {
			l = m + 1
		} else {
			r = m
		}
	}

	return nums[l]
}
