/*
	@author Hyper
	@date 2023/07/23
	@file M42_接雨水.go
*/

package Array

func trap(height []int) (ans int) {
	n := len(height)
	hl, hr, l, r := 0, 0, 1, n-2
	for i := 1; i < n-1; i++ {
		if height[l-1] < height[r+1] {
			hl = max(hl, height[l-1])
			if hl > height[l] {
				ans += hl - height[l]
			}
			l++
		} else {
			hr = max(hr, height[r+1])
			if hr > height[r] {
				ans += hr - height[r]
			}
			r--
		}
	}

	return
}
