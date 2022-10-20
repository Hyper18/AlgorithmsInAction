package GolangSolutions

import "math/bits"

func kthGrammar(n int, k int) int {
	if n == 1 {
		return 0
	}
	e := 1 << (n - 2)
	if k-1 < e {
		return kthGrammar(n-1, k)
	}

	return 1 ^ kthGrammar(n-1, k-e)
}

func kthGrammar2(n int, k int) int {
	return bits.OnesCount(uint(k-1)) & 1
}
