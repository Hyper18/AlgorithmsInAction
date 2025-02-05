package Tree;

import java.util.List;

/**
 * @author Hyper
 * @date 2024/08/26
 * @file M690_员工的重要性2.java
 * <p>
 * 思路
 * 朴素dfs
 */
public class M690_员工的重要性2 {
    final int N = 2010;
    Employee[] pos = new Employee[N];
    int ans;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            pos[e.id] = e;
        }
        dfs(pos[id]);
        return ans;
    }

    private void dfs(Employee e) {
        if (e.subordinates == null) {
            return;
        }
        ans += e.importance;
        for (int i : e.subordinates) {
            dfs(pos[i]);
        }
    }
}
