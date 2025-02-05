package SWM;

/**
 * @author Hyper
 * @date 2024/09/02
 * @file M2024_考试的最大困扰度.java
 * <p>
 * 思路
 * SWM+两次遍历
 * <p>
 * 疯狂卡Test case。。
 * 比较麻烦的几个点在于：
 * 1) 最后一个元素的处理，是否算入ans
 * 2) 当可替换 cnt==k 时，左边界如何收缩
 * <p>
 * Failed test case examples:
 * args[0] args[1]
 * "FFTFTFTFFT" 6
 * "FFT" 1
 * "FTFFTFTTTT" 4
 * "TTFTTTTTFT" 1
 * "TFTTTFFTFTTFFFTTTFFTFFFFTFTTTFFTFTFTFFFFFTTFTFTTFFFTTTTFFTTTTFFFFTFTFFFTFTFFTFTFFTFFTTFTTTTFTTTTTTTF" 50
 * <p>
 * 1. SWM
 * 但是ans替或者不替换都要进行，写两遍不太优雅
 * 2. 优化，但这个while循环看着也蛮别扭
 * 3. 再优化，改改次序，到这步发现跟官解几乎一样了，乐
 * 不过golang即便用这种写法也不算太简洁
 */
public class M2024_考试的最大困扰度 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] c = answerKey.toCharArray();
        return Math.max(count(c, k, 'T'), count(c, k, 'F'));
    }

    private int count(char[] c, int k, char target) {
        int n = c.length;
        int ans = 0, cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (c[r] == target) {
                ans = Math.max(ans, r - l + 1);
                continue;
            }
            if (cnt == k) {
                cnt--;
                while (c[l] == target) {
                    l++;
                }
                l++;
            }
            cnt++;
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    private int count2(char[] c, int k, char target) {
        int n = c.length;
        int ans = 0, cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt += c[r] != target ? 1 : 0;
            if (cnt > k) {
                cnt--;
                while (c[l] == target) {
                    l++;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    private int count3(char[] c, int k, char target) {
        int n = c.length;
        int ans = 0, cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt += c[r] != target ? 1 : 0;
            while (cnt > k) {
                cnt -= c[l] != target ? 1 : 0;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
