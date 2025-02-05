/*
	@author Hyper
	@date 2023/03/16
	@file M2488_统计中位数为K的子数组.go
*/

package Array

const N int = 1e5 + 10

func countSubarrays(nums []int, k int) (ans int) {
	n := len(nums)
	pre := [N]int{}
	mp := map[int]int{}
	ans, last := 0, 0
	for i := 1; i <= n; i++ {
		t := nums[i-1]
		if t > k {
			pre[i] = pre[i-1] + 1
		} else if t < k {
			pre[i] = pre[i-1] - 1
		} else {
			pre[i] = pre[i-1]
		}
		if t == k {
			for j := last; j < i; j++ {
				mp[pre[j]] += 1
			}
			last = i
		}
		ans += mp[pre[i]-1] + mp[pre[i]]
	}

	return
}
