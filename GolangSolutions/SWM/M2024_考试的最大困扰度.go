/*
	@author Hyper
	@date 2024/09/02
	@file M2024_考试的最大困扰度.go
*/

package SWM

func maxConsecutiveAnswers(answerKey string, k int) int {
	var count func(string, int, byte) int
	count = func(s string, k int, target byte) (ans int) {
		for l, r, cnt := 0, 0, 0; r < len(s); r++ {
			if s[r] != target {
				cnt++
			}
			for cnt > k {
				if s[l] != target {
					cnt--
				}
				l++
			}
			ans = max(ans, r-l+1)
		}

		return
	}

	return max(count(answerKey, k, 'T'), count(answerKey, k, 'F'))
}
