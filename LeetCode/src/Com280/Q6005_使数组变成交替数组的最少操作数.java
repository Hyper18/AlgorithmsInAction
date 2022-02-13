package Com280;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/13
 * 周赛时没完全pass，主要难点在于处理nums[i - 1] != nums[i]条件
 * <p>
 * 思路
 * 哈希表，分别为奇偶序列中出现频率最高、次高的元素计数
 */
public class Q6005_使数组变成交替数组的最少操作数 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79, 24}));
    }

    public static int minimumOperations(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        Map<Integer, Integer> mapOdd = new HashMap<>();
        Map<Integer, Integer> mapEven = new HashMap<>();
        for (int i = 0; i < len; i += 2) {
            mapOdd.put(nums[i], mapOdd.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < len; i += 2) {
            mapEven.put(nums[i], mapEven.getOrDefault(nums[i], 0) + 1);
        }

        int countOdd1st = 0;
        int countOdd2rd = 0;
        int max1 = 0;
        for (Map.Entry<Integer, Integer> entry : mapOdd.entrySet()) {
            if (entry.getValue() > countOdd1st) {
                max1 = entry.getKey();
                countOdd2rd = countOdd1st;
                countOdd1st = entry.getValue();
            } else if (entry.getValue() > countOdd2rd) {
                countOdd2rd = entry.getValue();
            }
        }

        int countEven1st = 0;
        int countEven2rd = 0;
        int max2 = 0;
        for (Map.Entry<Integer, Integer> entry : mapEven.entrySet()) {
            if (entry.getValue() > countEven1st) {
                max2 = entry.getKey();
                countEven2rd = countEven1st;
                countEven1st = entry.getValue();
            } else if (entry.getValue() > countOdd2rd) {
                countEven2rd = entry.getValue();
            }
        }

        return max1 == max2 ? len - Math.max(countOdd1st + countEven2rd, countOdd2rd + countEven1st) : len - countOdd1st - countEven1st;
    }
}
