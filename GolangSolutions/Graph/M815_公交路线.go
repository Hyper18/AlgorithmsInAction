/*
	@author Hyper
	@date 2024/09/17
	@file M815_公交路线.go
    若无公交车经过起点或终点，直接返回
*/

package Graph

import (
	"container/list"
)

func numBusesToDestination(routes [][]int, source int, target int) int {
	g := make(map[int][]int)
	for i := 0; i < len(routes); i++ {
		for _, j := range routes[i] {
			g[j] = append(g[j], i)
		}
	}
	d, q := make(map[int]int), list.New()
	d[source] = 0
	q.PushBack(source)
	for q.Len() > 0 {
		p := q.Remove(q.Front()).(int)
		cur := d[p]
		for _, i := range g[p] {
			for _, j := range routes[i] {
				if _, ok := d[j]; !ok {
					d[j] = cur + 1
					q.PushBack(j)
				}
			}
			routes[i] = nil
		}
	}

	if _, ok := d[target]; ok {
		return d[target]
	}
	return -1
}

func numBusesToDestination2(routes [][]int, source int, target int) int {
	g := make(map[int][]int)
	for i := 0; i < len(routes); i++ {
		for _, j := range routes[i] {
			g[j] = append(g[j], i)
		}
	}
	if g[source] == nil || g[target] == nil {
		if source != target {
			return -1
		}
		return 0
	}
	d, q := map[int]int{source: 0}, []int{source}
	for len(q) > 0 {
		p := q[0]
		q = q[1:]
		cur := d[p]
		for _, i := range g[p] {
			for _, j := range routes[i] {
				if _, ok := d[j]; !ok {
					d[j] = cur + 1
					q = append(q, j)
				}
			}
			routes[i] = nil
		}
	}

	if d, ok := d[target]; ok {
		return d
	}
	return -1
}
