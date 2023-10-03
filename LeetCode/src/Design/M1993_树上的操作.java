package Design;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2023/09/23
 * @file M1993_树上的操作.java
 * <p>
 * 思路
 * 模拟
 * 主要考虑如何初始化与升级
 * upgrade()需要向上遍历祖先结点并向下遍历寻找上锁的子节点
 * 分别以邻接表构造正向g1和反向g2两张有向图
 * 1. LockingTree()：通过第i个结点及其父结点关系构造
 * 2. lock()：当前num处于未上锁状态时，由user上锁
 * 3. unlock()应同时满足：当前结点已上锁；当前结点由user上锁
 * 4. upgrade()应同时满足：当前num处于未上锁状态；其祖先结点均为未上锁状态；包含至少一个由user上锁的子结点
 */
public class M1993_树上的操作 {
    class LockingTree {
        final int N = 2000;
        List<Integer>[] g1 = new ArrayList[N], g2 = new ArrayList[N];
        Map<Integer, Integer> mp = new HashMap<>();

        public LockingTree(int[] parent) {
            int n = parent.length;
            Arrays.setAll(g1, e -> new ArrayList<>());
            Arrays.setAll(g2, e -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int v = parent[i];
                if (v == -1) {
                    continue;
                }
                g1[v].add(i);
                g2[i].add(v);
            }
        }

        public boolean lock(int num, int user) {
            if (mp.containsKey(num)) {
                return false;
            }
            mp.put(num, user);

            return true;
        }

        public boolean unlock(int num, int user) {
            if (mp.containsKey(num) && mp.get(num) == user) {
                mp.remove(num);
                return true;
            }

            return false;
        }

        public boolean upgrade(int num, int user) {
            if (mp.containsKey(num)) {
                return false;
            }
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(num);
            while (!q.isEmpty()) {
                List<Integer> parent = g2[q.poll()];
                for (int p : parent) {
                    if (mp.containsKey(p)) {
                        return false;
                    }
                    q.offer(p);
                }
            }
            q.offer(num);
            boolean f = false;
            while (!q.isEmpty()) {
                List<Integer> children = g1[q.poll()];
                for (int c : children) {
                    if (mp.containsKey(c)) {
                        f = true;
                        mp.remove(c);
                    }
                    q.offer(c);
                }
            }
            if (f) {
                mp.put(num, user);
            }

            return f;
        }
    }

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
}
