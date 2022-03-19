package practice.practice2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/06
 * @time 109ms
 * 思路同根据中序和后序排列构造二叉树，并顺次记录两序列相等时结点值
 * 遍历输出得到前序序列
 * 主要思考的地方在于递归左右子树时前序和后序指针的位置边界处理：
 * 1. 遍历左子树时，后序排列中的前i-inorderLeft个结点为当前根结点的左子树结点
 * 2. 同理，在遍历右子树时，后序排列中的第i+1到根节点下标的前一个结点为当前根节点的右子树
 * 但实际上这两个点还是思考蛮久的，一开始左子树的后序指针没有-1，一直间隔输出空格。。
 * 二刷巩固一下
 */
public class S_算法训练_求先序排列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static char[] preorder, inorder, postorder;

    public static void main(String[] args) throws IOException {
        init();

        int preorderIdx = preorder.length - 1;
        int inorderIdx = inorder.length - 1;

        buildPre(0, inorderIdx, 0, preorderIdx);

        for (char c : preorder) {
            out.print(c);
        }

        close();
    }

    private static void buildPre(int inorderLeft, int inorderRight, int preorderIdx, int postorderIdx) {
        if (inorderLeft > inorderRight) {
            return;
        }
        for (int idx = inorderLeft; idx <= inorderRight; idx++) {
            if (inorder[idx] == postorder[postorderIdx]) {
                preorder[preorderIdx] = inorder[idx];
                buildPre(inorderLeft, idx - 1, preorderIdx + 1, postorderIdx - (inorderRight - idx) - 1);
                buildPre(idx + 1, inorderRight, preorderIdx + (idx - inorderLeft) + 1, postorderIdx - 1);
            }
        }
    }

    private static void init() throws IOException {
        inorder = nextString().toCharArray();
        postorder = nextString().toCharArray();
        preorder = new char[inorder.length];
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static String nextString() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
