package Matrix

import "sort"

func searchMatrix(matrix [][]int, target int) (flag bool) {
	for _, row := range matrix {
		i := sort.SearchInts(row, target)
		if i < len(row) && row[i] == target {
			flag = true
			return
		}
	}

	return
}
