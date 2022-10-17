package SWM

func totalFruit(fruits []int) (ans int) {
	cnt := map[int]int{}
	l := 0
	for r, cr := range fruits {
		cnt[cr]++
		for len(cnt) > 2 {
			cl := fruits[l]
			cnt[cl]--
			if cnt[cl] == 0 {
				delete(cnt, cl)
			}
			l++
		}
		if ans < r-l+1 {
			ans = r - l + 1
		}
	}

	return
}
