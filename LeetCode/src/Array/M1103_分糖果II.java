package Array;

/**
 * @author Hyper
 * @date 2024/06/03
 * @file M1103_分糖果II.java
 * <p>
 * 思路
 * 模拟
 */
public class M1103_分糖果II {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int t = 1, i = 0;
        while (candies > 0) {
            if (candies - t < 0) {
                res[i] += candies;
                break;
            }
            res[i] += t;
            i = (i + 1) % num_people;
            candies -= t++;
        }

        return res;
    }
}
