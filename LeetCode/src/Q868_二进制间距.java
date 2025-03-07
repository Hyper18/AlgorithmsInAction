/**
 * @author Hyper
 * @date 2022/04/25
 * 思路
 * 1. 模拟进制转换
 * 2. 先得到二进制串，后比较
 */
public class Q868_二进制间距 {
    public int binaryGap(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                int pos = 0;
                while (true) {
                    n /= 2;
                    pos++;
                    if (n % 2 != 0) {
                        break;
                    }
                }
                ans = Math.max(ans, pos);
            } else {
                n /= 2;
            }
        }

        return ans;
    }

    public int binaryGap2(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                int pos = 0;
                while (true) {
                    n >>= 1;
                    pos++;
                    if (n % 2 != 0) {
                        break;
                    }
                }
                ans = Math.max(ans, pos);
            } else {
                n >>= 1;
            }
        }

        return ans;
    }

    public int binaryGap3(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            // 通过与运算取最低位
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }

        return ans;
    }

//    public int binaryGap4(int n) { // 只能得到第一串
//        String arr = Integer.toBinaryString(n);
//        int pos = arr.indexOf('1');
//        for (int i = pos + 1; i < arr.length(); i++) {
//            if (arr.charAt(i) == '1') {
//                return i - pos;
//            }
//        }
//
//        return 0;
//    }
}
