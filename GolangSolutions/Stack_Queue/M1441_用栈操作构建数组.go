package Stack_Queue

func buildArray(target []int, n int) (ans []string) {
	pre := 0
	for _, num := range target {
		for i := 0; i < num-pre-1; i++ {
			ans = append(ans, "Push", "Pop")
		}
		ans = append(ans, "Push")
		pre = num
	}

	return
}
