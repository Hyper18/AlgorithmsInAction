/*
	@author Hyper
	@date 2023/07/01
	@file M1_两数之和.go
*/

package Array

func twoSum1(nums []int, target int) (res []int) {
	mp := map[int]int{}
	for i, num := range nums {
		if j, ok := mp[target-num]; ok {
			res = []int{j, i}
			break
		}
		mp[num] = i
	}

	return
}
