package Y2015C;

/**
 * @author Hyper
 * @date 2022/03/24
 * 坑点在于int值的三次方在4位数后会爆int
 * 需要强转为long处理
 */
public class Q2立方尾不变 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i < 10000; i++) {
            if (check(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int n) {
        String str = String.valueOf((long) n * n * n);
        int len = str.length();
        String res = str.substring(len - String.valueOf(n).length());
        return Integer.parseInt(res) == n;
    }
}
