/*
	@author Hyper
	@date 2024/08/30
	@file M3153_所有数对中数位不同之和.go
*/

package Math

func sumDigitDifferences(nums []int) (ans int64) {
	for nums[0] > 0 {
		mp := make([]int, 10)
		for i := range nums {
			mp[nums[i]%10]++
			nums[i] /= 10
		}
		for _, c := range mp {
			if c != 0 {
				ans += int64(c * (len(nums) - c))
			}
		}
	}
	ans >>= 1

	return
}
