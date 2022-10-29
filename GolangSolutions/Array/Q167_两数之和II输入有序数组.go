package Array

func twoSum(numbers []int, target int) []int {
	n := len(numbers)
	for i := range numbers {
		l, r := i+1, n-1
		for l <= r {
			m := l + (r-l)/2
			curTarget := target - numbers[i]
			if numbers[m] == curTarget {
				return []int{i + 1, m + 1}
			} else if numbers[m] > curTarget {
				r = m - 1
			} else {
				l = m + 1
			}
		}
	}

	return []int{-1, -1}
}
