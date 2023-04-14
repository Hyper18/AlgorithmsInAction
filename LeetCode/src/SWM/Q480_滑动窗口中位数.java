package SWM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2023/03/06
 * @file Q480_滑动窗口中位数.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 双优先队列
 * 一个大根堆维护一半较小的元素值
 * 一个小根堆维护另一半寄较大的元素值
 * 注意
 * 1. 控制qMax小根堆维护较多一侧元素
 * 这样qMin有可能为空，因此添加删除均比较右侧
 * 2. 应先添加，后删除
 */
public class Q480_滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            int[] w = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(w);
            res[i] = k % 2 == 0 ? 0.5 * w[(k >> 1) - 1] + 0.5 * w[k >> 1] : w[k >> 1];
        }

        return res;
    }

    public double[] medianSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        double[] res = new double[len];
//        PriorityQueue<Integer> qMin = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> qMin = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> qMax = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < k; i++) {
            qMax.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            qMin.add(qMax.poll());
        }
        res[0] = getMid(qMin, qMax);
        for (int i = 0; i < n - k; i++) {
            int l = nums[i], r = nums[i + k];
            if (r >= qMax.peek()) {
                qMax.add(r);
            } else {
                qMin.add(r);
            }
            if (l >= qMax.peek()) {
                qMax.remove(l);
            } else {
                qMin.remove(l);
            }
            while (qMin.size() > qMax.size()) {
                qMax.add(qMin.poll());
            }
            while (qMin.size() < qMax.size() - 1) {
                qMin.add(qMax.poll());
            }
            res[i + 1] = getMid(qMin, qMax);
        }

        return res;
    }

    private double getMid(PriorityQueue<Integer> qMin, PriorityQueue<Integer> qMax) {
        return qMin.size() == qMax.size() ? 0.5 * qMin.peek() + 0.5 * qMax.peek() : qMax.peek();
    }
}
