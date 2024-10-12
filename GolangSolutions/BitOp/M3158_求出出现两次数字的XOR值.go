/*
	@author Hyperspace
	@date 2024/10/12
	@file M3158_求出出现两次数字的XOR值.go
*/

package BitOp

func duplicateNumbersXOR(nums []int) (ans int) {
	vis := 0
	for _, num := range nums {
		if vis>>num&1 > 0 {
			ans ^= num
		} else {
			vis |= 1 << num
		}
	}

	return
}
