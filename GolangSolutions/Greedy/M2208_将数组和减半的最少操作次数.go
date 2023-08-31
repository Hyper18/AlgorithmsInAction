/*
	@author Hyperspace
	@date 2023/07/25
	@file M2208_将数组和减半的最少操作次数.go
	参照官解，手写下优先队列
*/

package Greedy

import "container/heap"

func halveArray(nums []int) (ans int) {
	q := &PriorityQueue{}
	sum := 0.0
	for _, x := range nums {
		heap.Push(q, float64(x))
		sum += float64(x)
	}
	cur := sum
	for cur > sum/2 {
		num := heap.Pop(q).(float64) / 2
		heap.Push(q, num)
		cur -= num
		ans++
	}

	return
}

type PriorityQueue []float64

func (q PriorityQueue) Len() int           { return len(q) }
func (q PriorityQueue) Less(i, j int) bool { return q[i] > q[j] }
func (q PriorityQueue) Swap(i, j int)      { q[i], q[j] = q[j], q[i] }
func (q *PriorityQueue) Push(x any)        { *q = append(*q, x.(float64)) }
func (q *PriorityQueue) Pop() any {
	old, n := *q, len(*q)
	x := old[n-1]
	*q = old[0 : n-1]
	return x
}
