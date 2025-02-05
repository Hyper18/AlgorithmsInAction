package Design;

import java.util.*;

/**
 * @author Hyper
 * @date 2024/04/07
 * @file M1600_王位继承顺序.java
 * <p>
 * 思路
 * 根据题意应为多叉树
 * 对其做前序遍历
 * 主要需考虑多叉树怎么存
 */
public class M1600_王位继承顺序 {
    class ThroneInheritance {
        private String kingName;
        private Set<String> isDead;
        private Map<String, List<String>> mp;
        private List<String> res;

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            isDead = new HashSet<>();
            mp = new HashMap<>();
        }

        public void birth(String parentName, String childName) {
            List<String> children = mp.getOrDefault(parentName, new LinkedList<>());
            children.add(childName);
            mp.put(parentName, children);
        }

        public void death(String name) {
            isDead.add(name);
        }

        public List<String> getInheritanceOrder() {
            res = new LinkedList<>();
            dfs(kingName);
            return res;
        }

        private void dfs(String e) {
            if (!isDead.contains(e)) {
                res.add(e);
            }
            for (String ne : mp.getOrDefault(e, new LinkedList<>())) {
                dfs(ne);
            }
        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
}
