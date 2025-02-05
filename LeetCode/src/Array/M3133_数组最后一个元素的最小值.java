package Array;

/**
 * @author Hyper
 * @date 2024/08/22
 * @file M3133_数组最后一个元素的最小值.java
 * <p>
 * 思路
 * 首先将n，x二进制表示
 * 假设x=5=0101_(2)
 * 先确定数组中元素的最大位数
 * 对于x的每一位r和当前元素的对应位s
 * 1) r=0 s=0/1
 * 2) r=1 s=1
 * 转化为在x中找为0的位，将1,2,3……依次填入
 * 从低位开始填入，后续每一个值均比x大（是x的超集）
 */
public class M3133_数组最后一个元素的最小值 {
    public long minEnd(int n, int x) {
        long ans = x, t = n - 1;
        for (int i = 0, j = 0; i < 64; i++) {
            if (((ans >> i) & 1) == 0) {
                if (((t >> j) & 1) == 1) {
                    ans |= (1L << i);
                }
                j++;
            }
        }

        return ans;
    }

    public long minEnd2(int n, int x) {
        long ans = x;
        n--;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            if (((ans >> i) & 1) == 0) {
                ans |= (long) ((n >> j) & 1) << i;
                j++;
            }
            i++;
        }

        return ans;
    }
}
