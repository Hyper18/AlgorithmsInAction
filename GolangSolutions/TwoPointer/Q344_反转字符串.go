/*
	@author Hyper
	@date 2023/08/07
	@file Q344_反转字符串.go
*/

package TwoPointer

func reverseString(s []byte) {
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}
