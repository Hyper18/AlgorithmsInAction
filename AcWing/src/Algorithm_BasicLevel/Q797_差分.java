package Algorithm_BasicLevel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/03
 * <p>
 * ˼·
 */
public class Q797_��� {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N];
    private static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            // ��ʼ��ԭ����
            a[i] = nextInt();
            // ��ʼ��������飬�������Ķ��壺b[i] = a[i] - a[i - 1]
            // ��������д����Ч���ǵ�ͬ�ģ�
            // 1. Ĭ��a[i]Ϊδ��ֵ��״̬����ʼ���в��
            // insert(i, i, a[i]);
            // 2. �Ӷ������ֵ�д��
            b[i] = a[i] - a[i - 1];
        }

        while (m-- > 0) {
            int l = nextInt(), r = nextInt(), c = nextInt();
            // ���в�ֲ���
            insert(l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            // �������У�ȡ��������ǰ׺��
            b[i] += b[i - 1];
            out.print(b[i] + " ");
        }

        close();
    }

    private static void insert(int l, int r, int c) {
        // Ϊ��l��ʼ��������ϲ��ֵc
        b[l] += c;
        // Ϊ��r���������ָ����
        b[r + 1] -= c;
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
