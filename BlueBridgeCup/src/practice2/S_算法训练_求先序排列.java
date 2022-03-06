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
 * 思路同根据中序和后序排列构造二叉树，并顺次记录两序列相等时结点值
 * 遍历输出得到前序序列
 * 主要思考的地方在于递归左右子树时前序和后序指针的位置边界处理：
 * 1. 遍历左子树时，后序排列中的前i-inorderLeft个结点为当前根结点的左子树结点
 * 2. 同理，在遍历右子树时，后序排列中的第i+1到根节点下标的前一个结点为当前根节点的右子树
 * 但实际上这两个点还是思考蛮久的，一开始左子树的后序指针没有-1，一直间隔输出空格。。
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
