package Array;

import java.util.*;

/**
 * @author Hyper
 * @date 2023/02/28
 * @file M2363_合并相似的物品.java
 * <p>
 * 思路
 * 模拟
 * 1. 双指针，分开形式：比较好想好写
 * 2. 双指针，合并形式：注意处理越界问题
 * 3. hash
 * 时间复杂度为(n1+n2)*log(n1+n2)
 */
public class M2363_合并相似的物品 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int n1 = items1.length, n2 = items2.length;
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int v1 = items1[i][0], v2 = items2[j][0];
            int w1 = items1[i][1], w2 = items2[j][1];
            if (v1 == v2) {
                res.add(new ArrayList<>(Arrays.asList(v1, w1 + w2)));
                i++;
                j++;
            } else if (v1 < v2) {
                res.add(new ArrayList<>(Arrays.asList(v1, w1)));
                i++;
            } else {
                res.add(new ArrayList<>(Arrays.asList(v2, w2)));
                j++;
            }
        }
        while (i < n1) {
            res.add(new ArrayList<>(Arrays.asList(items1[i][0], items1[i][1])));
            i++;
        }
        while (j < n2) {
            res.add(new ArrayList<>(Arrays.asList(items2[j][0], items2[j][1])));
            j++;
        }

        return res;
    }

    public List<List<Integer>> mergeSimilarItems2(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int n1 = items1.length, n2 = items2.length;
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            if (j == n2 || (i < n1 && items1[i][0] < items2[j][0])) {
                res.add(new ArrayList<>(Arrays.asList(items1[i][0], items1[i][1])));
                i++;
            } else if (i == n1 || (j < n2 && items1[i][0] > items2[j][0])) {
                res.add(new ArrayList<>(Arrays.asList(items2[j][0], items2[j][1])));
                j++;
            } else if (items1[i][0] == items2[j][0]) {
                res.add(new ArrayList<>(Arrays.asList(items1[i][0], items1[i][1] + items2[j][1])));
                i++;
                j++;
            }
        }

        return res;
    }

    public List<List<Integer>> mergeSimilarItems3(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res.add(new ArrayList<>(Arrays.asList(e.getKey(), e.getValue())));
        }
        res.sort(Comparator.comparingInt(a -> a.get(0)));

        return res;
    }
}
