/*
	@author Hyper
	@date 2024/08/27
	@file M3134_找出唯一性数组的中位数.go
*/

package SWM

func medianOfUniquenessArray(nums []int) int {
	n := len(nums)
	tot := (n*(n+1)/2 + 1) / 2
	var check func(mid int) bool
	check = func(mid int) bool {
		mp := make(map[int]int)
		cnt := 0
		for l, r := 0, 0; r < n; r++ {
			mp[nums[r]]++
			for len(mp) > mid {
				p := nums[l]
				l++
				mp[p]--
				if mp[p] == 0 {
					delete(mp, p)
				}
			}
			cnt += r - l + 1
			if cnt >= tot {
				return true
			}
		}

		return false
	}
	low, high := 0, n
	for low+1 < high {
		mid := low + ((high - low) >> 1)
		if check(mid) {
			high = mid
		} else {
			low = mid
		}
	}

	return high
}
