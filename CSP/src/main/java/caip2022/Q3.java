package caip2022;

import java.io.*;

/**
 * @author Hyper
 * @date 2022/07/10
 */
public class Q3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1010;
    private static long[] faces = new long[N];

    public static void main(String[] args) throws IOException {
        String input = in.readLine();
        if (input.charAt(0) != '-') {
            input = "+" + input;
        }
        char[] s = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '+' || s[i] == '-') {
                sb.append(s[i]);
            }
        }
        String[] seq = input.split("[+-]");
        String operators = sb.toString();
        long sum = 0;
        for (int i = 1; i < seq.length; i++) {
            String ss = seq[i];
            boolean isAdd = operators.charAt(i - 1) == '+';

            if (!ss.contains("d")) {
                long n = Long.parseLong(ss);
                sum = isAdd ? sum + n : sum - n;
            } else {
                if (ss.charAt(0) == 'd') {
                    ss = "1" + ss;
                }
                int n = Integer.parseInt(ss.split("d")[0]);
                int f = Integer.parseInt(ss.split("d")[1]);

                faces[f] = isAdd ? faces[f] + n : faces[f] - n;
            }
        }

        long min = sum, max = sum;
        for (int i = 2; i < faces.length; i++) {
            if (faces[i] == 0) {
                continue;
            }
            long mul = faces[i] * i;
            if (mul > 0) {
                max += mul;
                min += faces[i];
            } else {
                max += faces[i];
                min += mul;
            }

            out.println(i + " " + Math.abs(faces[i]));
        }

        out.println(min + " " + max);

        close();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
