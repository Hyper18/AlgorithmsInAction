package ref;

import java.io.*;

/**
 * @author Hyperspace
 * @date 2022/02/09
 */
public class R2_缓冲区输入输出 {

    public static void main(String[] args) throws Exception {
        int n = 65;
        char c = '2';
        char[] chars = new char[]{'a', 'B', 'c', 'D', 'e', 'f'};
        String s = "1234567890";

        /*
         * 获取输入输出
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        /*
         * BufferedReader处理输入
         * 按一下回车 有两个字符 “\n\r” （win环境）
         * 吸收回车: 两个read()/一个readLine()
         */
        int n1 = br.read();
        br.read();
        br.read();
        String str = br.readLine();
        br.readLine();

        bw.write(n1 + "\n");
        bw.write(str);
        bw.flush();

        /*
         * StreamTokenizer处理输入
         * 只能接收数字或字母，其他均无法识别，是为null
         * 获取输入流并根据空格和回车分割成Token（标记），用nextToken方法读取下一个标记
         *
         * 1. 标记是字符串 -> st.sval获取标记
         * 2. 标记是数字 -> st.nval获取标记（double类型！！）
         */
        // 若使用分组输入 StreamTokenizer.TT_EOF = EOF
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            // nextToken指示光标向下一个位置
            st.nextToken();
            int n2 = (int) st.nval;

            // PrintWriter可以使用print/printf/println方法
            pw.println(n2);
            pw.flush();

            st.nextToken();
            // 获取不带空格的字符串 含有空格的字符串无法全部读取
            String str2 = st.sval;

            pw.print(str2 + "\n");
            pw.flush();
        }

        /*
         * 处理输出 -> 缓冲区存放
         * 如果在未flush/close前重新new BufferedWriter(),会把原来的缓冲区覆盖
         */
        // 直接输出整型是对应的ASCii码
        bw.write(n);
        bw.write("\n");
        // 拼接以输出整型数值
        bw.write(n + "\n");
        // 转换类型以输出整型数值
        bw.write(Integer.toString(n));
        bw.write("\n");

        bw.write(c);
        bw.write("\n");

        bw.write(chars);
        bw.write("\n");
        bw.write(chars, 1, 3);
        bw.write("\n");

        bw.write(s);
        bw.write("\n");
        bw.write(s, 1, 3);
        bw.write("\n");

        /*
         * 刷新 -> console
         * 如果在未flush/close前重新new BufferedWriter(),就会把原来的缓冲区覆盖
         */
        bw.flush();
        pw.flush();

        /*
         * （刷新并）关流 -> console
         */
        br.close();

        bw.close();
        pw.close();
    }
}
