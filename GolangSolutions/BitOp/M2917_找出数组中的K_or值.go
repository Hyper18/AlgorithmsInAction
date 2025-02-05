/*
	@author Hyper
	@date 2024/03/06
	@file M2917_找出数组中的K_or值.go
*/

package BitOp

func findKOr(nums []int, k int) (ans int) {
	for i := 0; i < 31; i++ {
		cnt := 0
		for _, x := range nums {
			cnt += x >> i & 1
		}
		if cnt >= k {
			ans |= 1 << i
		}
	}

	return
}
