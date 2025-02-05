package Design;

/**
 * @author Hyper
 * @date 2024/03/21
 * @file M2671_频率跟踪器.java
 * <p>
 * 思路
 * 模拟
 * freq[i]: 记录i出现的次数
 * cnt[i]: 记录频率为i的数目
 * 注：每次增减时需先去掉原有该频率的计数，再加上现有频率的计数
 * 如，现在有3个2，加一个2，需要先把原来的频率为3的计数-1，再把4的频率计数+1
 */
public class M2671_频率跟踪器 {
    class FrequencyTracker {
        final int N = (int) (1e5 + 10);
        private int[] freq, cnt;

        public FrequencyTracker() {
            freq = new int[N];
            cnt = new int[N];
        }

        public void add(int number) {
            cnt[freq[number]]--;
            freq[number]++;
            cnt[freq[number]]++;
        }

        public void deleteOne(int number) {
            if (freq[number] == 0) {
                return;
            }
            cnt[freq[number]]--;
            freq[number]--;
            cnt[freq[number]]++;
        }

        public boolean hasFrequency(int frequency) {
            return cnt[frequency] > 0;
        }
    }

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
}
