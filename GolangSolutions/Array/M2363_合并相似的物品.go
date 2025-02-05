/*
	@author Hyper
	@date 2023/02/28
	@file M2363_合并相似的物品.go
*/

package Array

import "sort"

func mergeSimilarItems(items1 [][]int, items2 [][]int) (ans [][]int) {
	mp := map[int]int{}
	for _, w := range items1 {
		mp[w[0]] += w[1]
	}
	for _, w := range items2 {
		mp[w[0]] += w[1]
	}
	for k, v := range mp {
		ans = append(ans, []int{k, v})
	}
	sort.Slice(ans, func(i, j int) bool {
		return ans[i][0] < ans[j][0]
	})

	return
}
