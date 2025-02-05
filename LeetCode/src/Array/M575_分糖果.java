package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2024/06/02
 * @file M575_分糖果.java
 * <p>
 * 思路
 * 模拟
 */
public class M575_分糖果 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> cnts = new HashSet<>();
        for (int c : candyType) {
            cnts.add(c);
        }

        return Math.min(cnts.size(), candyType.length / 2);
    }
}
