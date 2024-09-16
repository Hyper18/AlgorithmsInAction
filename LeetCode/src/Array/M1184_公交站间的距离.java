package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/09/16
 * @file M1184_公交站间的距离.java
 */
public class M1184_公交站间的距离 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int ans = 0, sum = Arrays.stream(distance).sum();
        for (int i = start; i < destination; i++) {
            ans += distance[i];
        }

        return Math.min(sum - ans, ans);
    }
}
