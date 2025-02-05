/*
	@author Hyper
	@date 2022/11/15
	@file M1710_卡车上的最大单元数.go
*/

package Greedy

import "sort"

func maximumUnits(boxTypes [][]int, truckSize int) (ans int) {
	// 按照units降序排列
	sort.Slice(boxTypes, func(i, j int) bool {
		return boxTypes[i][1] > boxTypes[j][1]
	})
	for _, box := range boxTypes {
		if truckSize-box[0] >= 0 {
			ans += box[0] * box[1]
		} else {
			ans += truckSize * box[1]
			break
		}
		truckSize -= box[0]
	}

	return
}
