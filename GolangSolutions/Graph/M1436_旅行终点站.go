/*
	@author Hyperspace
	@date 2024/10/08
	@file M1436_旅行终点站.go
*/

package Graph

func destCity(paths [][]string) string {
	st1, st2 := make(map[string]struct{}, len(paths)), make(map[string]struct{}, len(paths))
	for _, p := range paths {
		delete(st2, p[0])
		if _, ok := st1[p[1]]; !ok {
			st2[p[1]] = struct{}{}
		}
		st1[p[0]] = struct{}{}
	}
	for s := range st2 {
		return s
	}

	return ""
}
