package Math;

/**
 * @author Hyperspace
 * @date 2023/09/08
 * @file M2651_计算列车到站时间.java
 */
public class M2651_计算列车到站时间 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
