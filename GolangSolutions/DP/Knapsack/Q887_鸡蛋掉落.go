package Knapsack

func superEggDrop(k int, n int) (cnt int) {
	if n == 1 {
		return 1
	}
	f := make([]int, k+1)
	for f[k] < n {
		cnt++
		for i := k; i >= 1; i-- {
			f[i] = f[i] + f[i-1] + 1
		}
	}

	return
}
