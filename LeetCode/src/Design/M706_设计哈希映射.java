package Design;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/04/15
 * @file M706_设计哈希映射.java
 * <p>
 * 思路
 * 开数组，模拟
 */
public class M706_设计哈希映射 {
    class MyHashMap {
        final int N = 1_000_000_7;
        private int[] mp = new int[N];

        public MyHashMap() {
            Arrays.fill(mp, -1);
        }

        public void put(int key, int value) {
            mp[key] = value;
        }

        public int get(int key) {
            return mp[key];
        }

        public void remove(int key) {
            mp[key] = -1;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
