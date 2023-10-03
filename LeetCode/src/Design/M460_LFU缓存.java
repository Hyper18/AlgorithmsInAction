package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/09/25
 * @file M460_LFU缓存.java
 * <p>
 * 思路 @Sweetiee
 * 双向链表
 * LRU每次移除被访问量最少的元素
 * <p>
 * 待回看
 */
public class M460_LFU缓存 {
    class LFUCache {
        Map<Integer, Node> cache;
        Map<Integer, DoublyLinkedList> freqMap;
        int size;
        int capacity;
        int min;

        public LFUCache(int capacity) {
            cache = new HashMap<>();
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);

            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                freqInc(node);
            } else {
                if (size == capacity) {
                    DoublyLinkedList minFreqLinkedList = freqMap.get(min);
                    cache.remove(minFreqLinkedList.tail.pre.key);
                    minFreqLinkedList.removeNode(minFreqLinkedList.tail.pre);
                    size--;
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                DoublyLinkedList li = freqMap.get(1);
                if (li == null) {
                    li = new DoublyLinkedList();
                    freqMap.put(1, li);
                }
                li.addNode(newNode);
                size++;
                min = 1;
            }
        }

        void freqInc(Node node) {
            int freq = node.freq;
            DoublyLinkedList linkedList = freqMap.get(freq);
            linkedList.removeNode(node);
            if (freq == min && linkedList.head.post == linkedList.tail) {
                min = freq + 1;
            }
            node.freq++;
            linkedList = freqMap.get(freq + 1);
            if (linkedList == null) {
                linkedList = new DoublyLinkedList();
                freqMap.put(freq + 1, linkedList);
            }
            linkedList.addNode(node);
        }
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        Node pre;
        Node post;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.post = tail;
            tail.pre = head;
        }

        void removeNode(Node node) {
            node.pre.post = node.post;
            node.post.pre = node.pre;
        }

        void addNode(Node node) {
            node.post = head.post;
            head.post.pre = node;
            head.post = node;
            node.pre = head;
        }
    }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
