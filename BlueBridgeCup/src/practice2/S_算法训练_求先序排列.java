package practice2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/06
 * @time 140ms
 */
public class S_算法训练_求先序排列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static char[] preorder, inorder, postorder;

    public static void main(String[] args) throws Exception {
        init();

        int inorderIdx = inorder.length - 1;
        int postorderIdx = postorder.length - 1;
        buildPre(0, inorderIdx, postorderIdx, 0);

        for (char c : preorder) {
            out.print(c);
        }

        close();
    }

    private static void init() throws Exception {
        inorder = nextString().toCharArray();
        postorder = nextString().toCharArray();
        preorder = new char[inorder.length];
    }

    private static void buildPre(int inorderLeft, int inorderRight, int postorderIdx, int preorderIdx) {
        if (inorderLeft > inorderRight) {
            return;
        }
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == postorder[postorderIdx]) {
                preorder[preorderIdx] = inorder[i];
                buildPre(inorderLeft, i - 1, postorderIdx - (inorderRight - i) - 1, preorderIdx + 1);
                buildPre(i + 1, inorderRight, postorderIdx - 1, preorderIdx + (i - inorderLeft) + 1);
            }
        }
    }

    public static int nextInt() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static String nextString() throws Exception {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws Exception {
        in.close();
        out.close();
    }
}
