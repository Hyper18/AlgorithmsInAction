package ref;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * @author Hyperspace
 * @date 2022/02/09
 */
public class R2_缓冲区输入输出 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 65;
        char c = '2';
        char[] chars = new char[]{'a', 'B', 'c', 'D', 'e', 'f'};
        String s = "1234567890";

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

        bw.flush();

        bw.close();
    }
}
