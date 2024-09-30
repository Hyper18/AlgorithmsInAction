/*
	@author Hyperspace
	@date 2023/11/28
	@file M1670_设计前中后队列.go
*/

package M1670

import "container/list"

type FrontMiddleBackQueue struct {
	front *list.List
	back  *list.List
}

func Constructor() FrontMiddleBackQueue {
	return FrontMiddleBackQueue{
		front: list.New(),
		back:  list.New(),
	}
}

func (q *FrontMiddleBackQueue) adjust() {
	if q.front.Len() > q.back.Len() {
		q.back.PushFront(q.front.Remove(q.front.Back()))
	} else if q.front.Len()+1 < q.back.Len() {
		q.front.PushBack(q.back.Remove(q.back.Front()))
	}
}

func (q *FrontMiddleBackQueue) PushFront(val int) {
	q.front.PushFront(val)
	q.adjust()
}

func (q *FrontMiddleBackQueue) PushMiddle(val int) {
	if q.front.Len() < q.back.Len() {
		q.front.PushBack(val)
	} else {
		q.back.PushFront(val)
	}
}

func (q *FrontMiddleBackQueue) PushBack(val int) {
	q.back.PushBack(val)
	q.adjust()
}

func (q *FrontMiddleBackQueue) PopFront() (val int) {
	if q.back.Len() == 0 {
		return -1
	}
	if q.front.Len() > 0 {
		val = q.front.Remove(q.front.Front()).(int)
	} else {
		val = q.back.Remove(q.back.Front()).(int)
	}
	q.adjust()

	return
}

func (q *FrontMiddleBackQueue) PopMiddle() int {
	if q.back.Len() == 0 {
		return -1
	}
	if q.front.Len() == q.back.Len() {
		return q.front.Remove(q.front.Back()).(int)
	}

	return q.back.Remove(q.back.Front()).(int)
}

func (q *FrontMiddleBackQueue) PopBack() int {
	if q.back.Len() == 0 {
		return -1
	}
	val := q.back.Remove(q.back.Back()).(int)
	q.adjust()

	return val
}
