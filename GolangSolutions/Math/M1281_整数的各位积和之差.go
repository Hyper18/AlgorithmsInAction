/*
	@author Hyper
	@date 2023/08/09
	@file M1281_整数的各位积和之差.go
*/

package Math

func subtractProductAndSum(n int) int {
	product, sum := 1, 0
	for n > 0 {
		product *= n % 10
		sum += n % 10
		n /= 10
	}

	return product - sum
}
