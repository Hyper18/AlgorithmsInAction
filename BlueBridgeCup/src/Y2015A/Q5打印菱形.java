package Y2015A;

/**
 * @author Hyperspace
 * @date 2022/03/21
 * 挺有意思的一道题
 * 思路在于控制中间子串，左边累加. 右边补*
 * 中间每次减去3，分别是 头 尾 补的* 三个位置
 */
public class Q5打印菱形 {
    public static void main(String[] args) {
        f(8);
    }

    public static void f(int n) {
        String s = "*";
        for (int i = 0; i < 2 * n - 3; i++)
            s += ".";
        s += "*";

        String s1 = s + "\n";
        String s2 = "";

        for (int i = 0; i < n - 1; i++) {
            s = "." + s.substring(0, s.length() - 3) + "*"; // 填空
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1 + s2);
    }
}
