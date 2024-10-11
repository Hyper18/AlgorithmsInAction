/*
	@author Hyperspace
	@date 2024/10/11
	@file M3164_优质数对的总数II.go
*/

package Array

func numberOfPairs(nums1 []int, nums2 []int, k int) (ans int64) {
	mp := map[int]int{}
	for _, v := range nums1 {
		if v%k != 0 {
			continue
		}
		v /= k
		for d := 1; d*d <= v; d++ {
			if v%d > 0 {
				continue
			}
			mp[d]++
			if d*d < v {
				mp[v/d]++
			}
		}
	}

	for _, v := range nums2 {
		ans += int64(mp[v])
	}

	return
}
