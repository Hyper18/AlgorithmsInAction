package Y2017C;

/**
 * @author Hyperspace
 * @date 2022/04/02
 * <p>
 * 标题： 杨辉三角
 * <p>
 * 杨辉三角也叫帕斯卡三角，在很多数量关系中可以看到，十分重要。
 * <p>
 * 第0行：           1
 * 第1行：          1 1
 * 第2行：         1 2 1
 * 第3行：        1 3 3 1
 * 第4行：       1 4 6 4 1
 * ....
 * <p>
 * 两边的元素都是1， 中间的元素是左上角的元素与右上角的元素和。
 * <p>
 * 我们约定，行号，列号都从0计数。
 * 所以： 第6行的第2个元素是15，第3个元素是20
 * <p>
 * 直观地看，需要开辟一个二维数组，其实一维数组也可以胜任。
 * 如下程序就是用一维数组“腾挪”的解法。
 */
public class Q5杨辉三角 {
    // 杨辉三角形的第row行第col列
    static long f(int row, int col) {
        if (row < 2) return 1;
        if (col == 0) return 1;
        if (col == row) return 1;

        long[] a = new long[row + 1];
        a[0] = 1;
        a[1] = 1;

        int p = 2;

        while (p <= row) {
            a[p] = 1;
            // 填空位置
            for (int q = p - 1; q >= 1; q--) a[q] = a[q] + a[q - 1];
            p++;
        }

        return a[col];
    }

    public static void main(String[] args) {
        System.out.println(f(6, 2));
        System.out.println(f(6, 3));
    }
}
