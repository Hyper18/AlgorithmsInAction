package Math;

/**
 * @author Hyperspace
 * @date 2024/08/30
 * @file M3153_所有数对中数位不同之和.java
 * <p>
 * 思路
 * 1. 朴素写法 TLE，这个10^4范围内才可行
 * 2. 从模拟每个数变为模拟每个数位
 * 根据hint3而来，需要注意这样计算的话，
 * 相当于该位为x贡献的次数c会在x+1,x+2...中被重复计算
 * 最后相当于每个位的贡献都被多计算了1次
 * 故需要将最终ans除以2
 * 3. 空间优化
 */
public class M3153_所有数对中数位不同之和 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += diff(nums[i], nums[j]);
            }
        }

        return ans;
    }

    private long diff(int a, int b) {
        long cnt = 0;
        while (a > 0 && b > 0) {
            if (a % 10 != b % 10) {
                cnt++;
            }
            a /= 10;
            b /= 10;
        }

        return cnt;
    }

    public long sumDigitDifferences2(int[] nums) {
        int n = nums.length, len = String.valueOf(nums[0]).length();
        int[][] mp = new int[len][10];
        for (int num : nums) {
            char[] s = String.valueOf(num).toCharArray();
            for (int i = 0; i < len; i++) {
                mp[i][s[i] - '0']++;
            }
        }
        long ans = 0;
        for (int[] cnt : mp) {
            for (int c : cnt) {
                if (c != 0) {
                    ans += (long) c * (n - c);
                }
            }
        }

        return ans >> 1;
    }

    public long sumDigitDifferences3(int[] nums) {
        int n = nums.length;
        long ans = 0;
        while (nums[0] > 0) {
            int[] mp = new int[10];
            for (int i = 0; i < n; i++) {
                mp[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int c : mp) {
                ans += c == 0 ? 0 : (long) c * (n - c);
            }
        }

        return ans >> 1;
    }
}
