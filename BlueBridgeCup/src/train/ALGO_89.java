package train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Hyperspace
 * @date 2022/03/02
 * <p>
 * 90/100
 * 使用scanner无法处理空格
 * 换用io流
 */
public class ALGO_89 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        char ch = (char) in.read();
        out.println(s.replace(String.valueOf(ch), ""));

        in.close();
        out.close();
    }
}
