package Y2018A;

/**
 * @author Hyper
 * @date 2022/04/03
 * <p>
 * 分析图形中的关系
 * 每次的花型是dfs四遍的结果
 * -- 找中心点之间的间距
 * 可知，大N = 中心点之间的间距
 * 因此累除之，得到每次的最小步数小n
 */
public class Q5打印图形 {
    static void show(byte[][] buf) {
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < buf[i].length; j++) {
                System.out.print(buf[i][j] == 0 ? ' ' : 'o');
            }
            System.out.println();
        }
    }

    static void draw(byte[][] buf, int x, int y, int size) {
        if (size == 1) {
            buf[y][x] = 1;
            return;
        }

        int n = size / 3;  // 填空
        draw(buf, x, y, n);
        draw(buf, x - n, y, n);
        draw(buf, x + n, y, n);
        draw(buf, x, y - n, n);
        draw(buf, x, y + n, n);
    }

    public static void main(String[] args) {
        final int N = 3;
        int t = 1;
        for (int i = 0; i < N; i++) t *= 3;

        byte[][] buf = new byte[t][t];
        draw(buf, t / 2, t / 2, t);
        show(buf);
    }
}
