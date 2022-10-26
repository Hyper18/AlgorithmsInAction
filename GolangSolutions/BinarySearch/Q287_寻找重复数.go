package BinarySearch

func findDuplicate(nums []int) int {
	n, ans := len(nums), -1
	l, r := 1, n-1
	for l <= r {
		m := l + (r-l)/2

		cnt := 0
		for _, num := range nums {
			if num <= m {
				cnt++
			}
		}

		if cnt <= m {
			l = m + 1
		} else {
			r = m - 1
			ans = m
		}
	}

	return ans
}
