package Competition.Com442;

/**
 * @author Hyperspace
 * @date 2025/03/23
 * @file Q3492_船上可以装载的最大集装箱数量.java
 * <p>
 * 思路
 * 数学
 */
public class Q3492_船上可以装载的最大集装箱数量 {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight / w, n * n);
    }
}
