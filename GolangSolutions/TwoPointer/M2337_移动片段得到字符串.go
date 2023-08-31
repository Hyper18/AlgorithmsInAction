/*
	@author Hyperspace
	@date 2023/08/21
	@file M2337_移动片段得到字符串.go
*/

package TwoPointer

func canChange(start string, target string) bool {
	n, i, j := len(start), 0, 0
	for i < n || j < n {
		for i < n && start[i] == '_' {
			i++
		}
		for j < n && target[j] == '_' {
			j++
		}
		if i < n && j < n {
			if start[i] != target[j] || (i < j && start[i] == 'L') || (i > j && target[j] == 'R') {
				return false
			}
			i++
			j++
		} else if i < n {
			for i < n {
				if start[i] != '_' {
					return false
				}
				i++
			}
		} else {
			for j < n {
				if target[j] != '_' {
					return false
				}
				j++
			}
		}
	}

	return true
}
