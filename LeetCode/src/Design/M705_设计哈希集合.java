package Design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/04/14
 * @file M705_设计哈希集合.java
 * <p>
 * 思路
 * 1. 开数组
 * 2. 图一乐
 */
public class M705_设计哈希集合 {
    class MyHashSet {
        final int N = 1_000_000_9;
        boolean[] f = new boolean[N];

        public void add(int key) {
            f[key] = true;
        }

        public void remove(int key) {
            f[key] = false;
        }

        public boolean contains(int key) {
            return f[key];
        }
    }

    class MyHashSet2 {
        private List<Integer> li;

        public MyHashSet2() {
            li = new ArrayList<>();
        }

        public void add(int key) {
            li.add(key);
        }

        public void remove(int key) {
            li.removeAll(Collections.singleton(key));
        }

        public boolean contains(int key) {
            return li.contains(key);
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
