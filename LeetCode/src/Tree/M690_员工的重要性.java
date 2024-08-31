package Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/08/26
 * @file M690_员工的重要性.java
 * <p>
 * 思路
 * 朴素dfs
 */
public class M690_员工的重要性 {
    Map<Integer, Employee> mp = new HashMap<>();
    int ans;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            mp.put(e.id, e);
        }
        dfs(mp.get(id));
        return ans;
    }

    private void dfs(Employee e) {
        if (e.subordinates == null) {
            return;
        }
        ans += e.importance;
        for (int i : e.subordinates) {
            dfs(mp.get(i));
        }
    }
}
