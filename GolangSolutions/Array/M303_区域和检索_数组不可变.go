/*
	@author Hyperspace
	@date 2024/03/18
	@file M303_区域和检索_数组不可变.go
*/

package Array

type NumArray struct {
	pre []int
}

func Constructor(nums []int) NumArray {
	pre := make([]int, len(nums)+1)
	for i, v := range nums {
		pre[i+1] = pre[i] + v
	}

	return NumArray{pre}
}

func (na *NumArray) SumRange(left int, right int) int {
	return na.pre[right+1] - na.pre[left]
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */
