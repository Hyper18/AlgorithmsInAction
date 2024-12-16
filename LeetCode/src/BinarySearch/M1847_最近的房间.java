package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file M1847_最近的房间.java
 * <p>
 * 思路@ylb
 * 二分，模拟
 * 容易想到两种思路：
 * 1. 对rooms排序，先找符合的id，再判断是否满足最小面积的约束
 * 这种做法第一部分可以直接排序+二分，但第二部分比较麻烦
 * 主要需要处理以下两种情况：
 * 1) preferredj大于max(rooms[i][0])或小于min(rooms[i][0])
 * 可处理为rooms的左边界或右边界
 * Math.max(mn, Math.min(mx, rooms[i][0]))
 * 2) 查询的id在rooms里没有出现过
 * 考虑可以以id为mid，从diff = 0开始向两侧找，但单这个过程就至少是O(n)的
 * 对于本题的数据量，这样做是很慢的
 * 2. 对queries排序，先找到符合的面积，再找此时可行的最小id
 * 升序排列，每次移除小于查询面积的房间
 * 再在剩余的房间中二分找最近的id
 */
public class M1847_最近的房间 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length, k = queries.length;
        Arrays.sort(rooms, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[][] myQueries = new int[k][3];
        for (int i = 0; i < k; i++) {
            myQueries[i][0] = queries[i][0];
            myQueries[i][1] = queries[i][1];
            myQueries[i][2] = i;
        }
        Arrays.sort(myQueries, Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int[] room : rooms) {
            mp.merge(room[0], 1, Integer::sum);
        }
        int[] res = new int[k];
        Arrays.fill(res, -1);
        int i = 0;
        for (int[] q : myQueries) {
            int p = q[0], mn = q[1], j = q[2];
            while (i < n && rooms[i][1] < mn) {
                if (mp.merge(rooms[i][0], -1, Integer::sum) == 0) {
                    mp.remove(rooms[i][0]);
                }
                i++;
            }
            if (i == n) {
                break;
            }
            Integer l = mp.floorKey(p), r = mp.ceilingKey(p);
            if (r != null) {
                res[j] = r;
            }
            if (l != null && (res[j] == -1 || res[j] - p >= p - l)) {
                res[j] = l;
            }
        }

        return res;
    }
}
