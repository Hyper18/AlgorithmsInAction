package Y2019B;

import java.io.*;

/**
 * @author Hyper
 * @date 2022/04/06
 */
public class H人物相关性分析 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final String ALICE = "Alice";
    private static final String BOB = "Bob";

    public static void main(String[] args) throws IOException {
        int k = nextInt();
        String text = next();
        out.print(getCorrelation(text, k));
        close();
    }

    private static int getCorrelation(String text, int scope) {
        int idx, cnt = 0;
        String name, curName;
        StringBuilder sb;
        while (text.length() > 0) {
            int pa = text.indexOf(ALICE);
            int pb = text.indexOf(BOB);
            idx = Math.min(pa, pb);

            name = pa < pb ? BOB : ALICE;
            curName = pa < pb ? ALICE : BOB;

            sb = new StringBuilder();
            text = sb.append(" ").append(text).append(" ").toString();
            if (idx == -1) {
                break;
            }

            String sub;
            if (pa + scope < text.length()) {
                sub = text.substring(pa, pa + scope);
            } else {
                sub = text.substring(pa);
            }

            for (int i = 0; i < sub.length() - name.length(); i++) {
                String tmp = sub.substring(i, i + name.length());
                if (tmp.equals(name)) {
                    if (isNotLetter(sub.charAt(i - 1)) && isNotLetter(sub.charAt(i + name.length()))) {
                        cnt++;
                    }
                }
            }
            text = text.substring(idx + curName.length());
        }

        return cnt;
    }

    private static boolean isNotLetter(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public static String next() throws IOException {
        return in.readLine();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
