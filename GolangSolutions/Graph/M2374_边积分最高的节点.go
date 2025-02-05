/*
	@author Hyper
	@date 2024/09/21
	@file M2374_边积分最高的节点.go
*/

package Graph

func edgeScore(edges []int) (ans int) {
	n := len(edges)
	in := make([]int64, n)
	for i, v := range edges {
		in[v] += int64(i)
	}
	mx := int64(0)
	for i, v := range in {
		if v > mx {
			mx = v
			ans = i
		}
	}

	return
}
