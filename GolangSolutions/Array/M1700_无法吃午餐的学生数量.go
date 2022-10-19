package Array

func countStudents(students []int, sandwiches []int) int {
	cnt := make([]int, 2)
	for _, stu := range students {
		cnt[stu]++
	}
	for i, s := range sandwiches {
		cnt[s]--
		if cnt[s] < 0 {
			return len(sandwiches) - i
		}
	}

	return 0
}
