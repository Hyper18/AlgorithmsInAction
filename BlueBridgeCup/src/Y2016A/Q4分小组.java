package Y2016A;

/**
 * @author Hyper
 * @date 2022/03/25
 * <p>
 * 9名运动员参加比赛，需要分3组进行预赛。
 * 有哪些分组的方案呢？
 * <p>
 * 我们标记运动员为 A,B,C,... I
 * 下面的程序列出了所有的分组方法。
 * <p>
 * 该程序的正常输出为：
 * ABC DEF GHI
 * ABC DEG FHI
 * ABC DEH FGI
 * ABC DEI FGH
 * ABC DFG EHI
 * ABC DFH EGI
 * ABC DFI EGH
 * ABC DGH EFI
 * ABC DGI EFH
 * ABC DHI EFG
 * ABC EFG DHI
 * ABC EFH DGI
 * ABC EFI DGH
 * ABC EGH DFI
 * ABC EGI DFH
 * ABC EHI DFG
 * ABC FGH DEI
 * ABC FGI DEH
 * ABC FHI DEG
 * ABC GHI DEF
 * ABD CEF GHI
 * ABD CEG FHI
 * ABD CEH FGI
 * ABD CEI FGH
 * ABD CFG EHI
 * ABD CFH EGI
 * ABD CFI EGH
 * ABD CGH EFI
 * ABD CGI EFH
 * ABD CHI EFG
 * ABD EFG CHI
 * ..... (以下省略，总共560行)。
 * <p>
 * 思路
 * 全排列问题
 * 通过交换并回溯，找到每一种可能的解
 * 最后可以验算一下全排列的数目为560
 */
public class Q4分小组 {
    public static String remain(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) s += (char) (i + 'A');
        }
        return s;
    }

    public static void f(String s, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) continue;
            a[i] = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == 1) continue;
                a[j] = 1;
                for (int k = j + 1; k < a.length; k++) {
                    if (a[k] == 1) continue;
                    a[k] = 1;
                    System.out.println(s + " " + (char) (i + 'A') + (char) (j + 'A') + (char) (k + 'A') + " " + remain(a));  //填空位置
                    a[k] = 0;
                }
                a[j] = 0;
            }
            a[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[9];
        a[0] = 1;

        for (int b = 1; b < a.length; b++) {
            a[b] = 1;
            for (int c = b + 1; c < a.length; c++) {
                a[c] = 1;
                String s = "A" + (char) (b + 'A') + (char) (c + 'A');
                f(s, a);
                a[c] = 0;
            }
            a[b] = 0;
        }
    }
}
