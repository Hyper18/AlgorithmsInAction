package Stack_Queue

func sumSubarrayMins(arr []int) (ans int) {
	const MOD int = 1e9 + 7
	n := len(arr)
	l, r := make([]int, n), make([]int, n)
	q := []int{}
	for i := range l {
		l[i] = -1
		r[i] = n
	}

	for i, x := range arr {
		for len(q) > 0 && arr[q[len(q)-1]] >= x {
			r[q[len(q)-1]] = i
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}

	q = []int{}
	for i := n - 1; i >= 0; i-- {
		for len(q) > 0 && arr[q[len(q)-1]] > arr[i] {
			l[q[len(q)-1]] = i
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}

	for i, x := range arr {
		a, b := i-l[i], r[i]-i
		ans = (ans + a*b*x) % MOD
	}

	return
}
