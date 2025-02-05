package Greedy;

/**
 * @author Hyper
 * @date 2023/07/05
 * @file M2600_K件物品的最大和.java
 * <p>
 * 思路
 * 贪心
 */
public class M2600_K件物品的最大和 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k - numOnes <= numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
