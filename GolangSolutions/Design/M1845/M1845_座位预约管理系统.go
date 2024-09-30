/*
	@author Hyperspace
	@date 2024/09/30
	@file M1845_座位预约管理系统.go
	学习写法@灵茶山艾府
	直接给定struct内sort使其继承Len, Less, Swap
*/

package M1845

import (
	"container/heap"
	"sort"
)

type SeatManager struct {
	sort.IntSlice
}

func Constructor(n int) SeatManager {
	m := SeatManager{make([]int, n)}
	for i := range m.IntSlice {
		m.IntSlice[i] = i + 1
	}

	return m
}

func (m *SeatManager) Reserve() int {
	return heap.Pop(m).(int)
}

func (m *SeatManager) Unreserve(seatNumber int) {
	heap.Push(m, seatNumber)
}

func (m *SeatManager) Push(v any) {
	m.IntSlice = append(m.IntSlice, v.(int))
}

func (m *SeatManager) Pop() any {
	a := m.IntSlice
	v := a[len(a)-1]
	m.IntSlice = a[:len(a)-1]
	return v
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Reserve();
 * obj.Unreserve(seatNumber);
 */
