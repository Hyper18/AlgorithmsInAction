package Array

func partitionDisjoint(nums []int) int {
	n := len(nums)
	f := make([]int, n+10)
	f[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		f[i] = min(f[i+1], nums[i])
	}
	m := 0
	for i := range nums {
		m = max(m, nums[i])
		if m <= f[i+1] {
			return i + 1
		}
	}

	return n
}

func partitionDisjoint2(nums []int) int {
	m, left, idx := 0, nums[0], 0
	for i := range nums {
		m = max(m, nums[i])
		if left > nums[i] {
			left = m
			idx = i
		}
	}

	return idx + 1
}

func min(a, b int) int {
	if b < a {
		return b
	}
	return a
}

func max(a, b int) int {
	if b > a {
		return b
	}
	return a
}
