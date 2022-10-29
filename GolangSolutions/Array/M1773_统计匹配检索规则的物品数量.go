package Array

var index = map[string]int{"type": 0, "color": 1, "name": 2}

func countMatches(items [][]string, ruleKey string, ruleValue string) (ans int) {
	idx := index[ruleKey]
	for _, item := range items {
		if ruleValue == item[idx] {
			ans++
		}
	}

	return
}
