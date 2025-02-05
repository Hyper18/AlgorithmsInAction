/*
	@author Hyper
	@date 2024/03/13
	@file M2864_最大二进制奇数.go
	Golang可以直接调用strings.Count()和strings.Repeat()完成
*/

package String

import "strings"

func maximumOddBinaryNumber(s string) string {
	n, cnt := len(s), strings.Count(s, "1")
	return strings.Repeat("1", cnt-1) + strings.Repeat("0", n-cnt) + "1"
}
