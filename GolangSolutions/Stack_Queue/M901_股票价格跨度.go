package Stack_Queue

import "math"

type StockSpanner struct {
	stk [][2]int
	idx int
}

func Constructor() StockSpanner {
	return StockSpanner{[][2]int{{-1, math.MaxInt}}, -1}
}

func (this *StockSpanner) Next(price int) int {
	this.idx++
	for price >= this.stk[len(this.stk)-1][1] {
		this.stk = this.stk[:len(this.stk)-1] //slice
	}
	ans := this.idx - this.stk[len(this.stk)-1][0]
	this.stk = append(this.stk, [2]int{this.idx, price})

	return ans
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Next(price);
 */
