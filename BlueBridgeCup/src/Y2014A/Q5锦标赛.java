package Y2014A;

/**
 * @author Hyperspace
 * @date 2022/03/16
 */
public class Q5锦标赛 {
    public static void main(String[] args) {
        int[] a = {1, 8, 22, 15, 3, 6, 12, 13};
        pick(a);

    }

    //a 表示待处理的数据，长度如果不是2的次幂，则不足位置补为-1
    static void pick(int[] a) {
        int n = 1;
        while (n < a.length)
            n *= 2;

        int[] b = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            if (i < a.length)
                b[n - 1 + i] = i;
            else
                b[n - 1 + i] = -1;
        }

        //从最后一个向前处理
        for (int i = b.length - 1; i > 0; i -= 2) {
            if (b[i] < 0) {
                if (b[i - 1] >= 0)
                    b[(i - 1) / 2] = b[i - 1];
                else
                    b[(i - 1) / 2] = -1;
            } else {
                if (a[b[i]] > a[b[i - 1]])
                    b[(i - 1) / 2] = b[i];
                else
                    b[(i - 1) / 2] = b[i - 1];
            }
        }

        //输出树根
        System.out.println(b[0] + ": " + a[b[0]]);

        //值等于根元素的位置需要重新pk
        pk(a, b, 0, b[0]);

        //再次输出树根
        System.out.println(b[0] + ": " + a[b[0]]);
    }


    // a 表示待处理数据，b 二叉树，k 当前要重新比拼的位置，v 已经决胜出的值
    static void pk(int[] a, int[] b, int k, int v) {

        int k1 = k * 2 + 1;
        int k2 = k1 + 1;

        if (k1 >= b.length || k2 >= b.length) {
            b[k] = -1;
            return;
        }

        if (b[k1] == v)
            pk(a, b, k1, v);
        else
            pk(a, b, k2, v);


        //重新比较
        if (b[k1] < 0) {
            if (b[k2] >= 0)
                b[k] = b[k2];
            else
                b[k] = -1;
            return;
        }

        if (b[k2] < 0) {
            if (b[k1] >= 0)
                b[k] = b[k1];
            else
                b[k] = -1;
            return;
        }

        if (a[b[k1]] > a[b[k2]])  //填空
            b[k] = b[k1];
        else
            b[k] = b[k2];
    }
}
