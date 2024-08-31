/*
	@author Hyperspace
	@date 2024/08/26
	@file M690_员工的重要性.go
*/

package Tree

func getImportance(employees []*Employee, id int) (ans int) {
	mp := map[int]*Employee{}
	for _, e := range employees {
		mp[e.Id] = e
	}

	var dfs func(int)
	dfs = func(id int) {
		e := mp[id]
		ans += e.Importance
		for _, i := range e.Subordinates {
			dfs(i)
		}
	}
	dfs(id)

	return
}
