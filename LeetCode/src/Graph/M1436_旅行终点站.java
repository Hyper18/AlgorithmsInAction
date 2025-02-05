package Graph;

import java.util.*;

/**
 * @author Hyper
 * @date 2024/10/08
 * @file M1436_旅行终点站.java
 * <p>
 * 思路
 * hash统计出度
 * 最终到达的节点出度为0
 */
public class M1436_旅行终点站 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> mp = new HashMap<>();
        for (List<String> path : paths) {
            mp.put(path.get(0), mp.getOrDefault(path.get(0), 0) + 1);
            mp.putIfAbsent(path.get(1), 0);
        }
        for (Map.Entry<String, Integer> e : mp.entrySet()) {
            if (e.getValue() == 0) {
                return e.getKey();
            }
        }

        return "";
    }

    public String destCity2(List<List<String>> paths) {
        Set<String> st = new HashSet<>(paths.size());
        for (List<String> p : paths) {
            st.add(p.get(0));
        }
        for (List<String> p : paths) {
            if (!st.contains(p.get(1))) {
                return p.get(1);
            }
        }

        return "";
    }

    public String destCity3(List<List<String>> paths) {
        Set<String> st1 = new HashSet<>(paths.size()), st2 = new HashSet<>(paths.size());
        for (List<String> p : paths) {
            st2.remove(p.get(0));
            if (!st1.contains(p.get(1))) {
                st2.add(p.get(1));
            }
            st1.add(p.get(0));
        }

        return st2.iterator().next();
    }
}
