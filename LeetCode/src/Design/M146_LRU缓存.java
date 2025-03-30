package Design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/09/24，2025/03/30
 * @file M146_LRU缓存.java
 * <p>
 * 思路
 * 1. 直接继承 逃课写法
 * 2. 双端队列+哈希表
 */
public class M146_LRU缓存 {
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, DEFAULT_LOAD_FACTOR, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    class LRUCache2 {
        private final int capacity;
        private final Map<Integer, Integer> mp;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            mp = new LinkedHashMap<>();
        }

        public int get(int key) {
            Integer val = mp.remove(key);
            if (val != null) {
                mp.put(key, val);
                return val;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (mp.remove(key) != null) {
                mp.put(key, value);
                return;
            }
            if (mp.size() == capacity) {
                Integer eldestKey = mp.keySet().iterator().next();
                mp.remove(eldestKey);
            }
            mp.put(key, value);
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
