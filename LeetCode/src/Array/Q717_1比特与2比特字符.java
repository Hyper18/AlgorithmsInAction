package Array;

/**
 * @author Hyperspace
 * @date 2022/02/20
 * <p>
 * 1. 正序
 * 依次判断类型，第一种则+1, 第二种+1+1
 * 2. 逆序
 * 借鉴官解的思路，只需判断n−2−i -- n-i的奇偶性
 * 找出最后一个0前面有奇数个还是偶数个1
 */
public class Q717_1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i;
        for (i = 0; i < n - 1; i++) {
            i += bits[i];
        }
        return i == n - 1;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length;
        int i = n - 2;
        while (i >= 0 && bits[i] == 1) {
            --i;
        }
        return (n - i) % 2 == 0;
    }
}
