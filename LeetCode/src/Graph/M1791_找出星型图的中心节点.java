package Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/18
 * <p>
 * 舒爽的打卡~
 * 一开始用的哈希表，数组其实更快，因为指定了 n 个编号是从 1 到 n 的节点组成
 */
public class M1791_找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.size() - map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public int findCenter2(int[][] edges) {
        int[] degrees = new int[(edges.length + 1) + 1];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }

    public int findCenter3(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
