package practice.practice2;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/23
 */
public class A_人物相关性分析 {
    private static String name1 = "Alice";
    private static String name2 = "Bob";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int k = in.nextInt();
        in.nextLine();
        String text = in.nextLine();

        out.print(getCorrelation(text, k));

        in.close();
        out.close();
    }

    private static int getCorrelation(String text, int scope) {
        int cnt = 0;
        int idx;
        String name;
        String curName;
        StringBuilder sb;
        while (text.length() > 0) {
            int idx1 = text.indexOf(name1);
            int idx2 = text.indexOf(name2);
            idx = idx1 < idx2 ? idx1 : idx2;

            name = idx1 < idx2 ? name2 : name1;
            curName = idx1 < idx2 ? name1 : name2;

            sb = new StringBuilder();
            text = sb.append(" ").append(text).append(" ").toString();
            if (idx == -1) {
                break;
            }

            String sub;
            if (idx1 + scope < text.length()) {
                sub = text.substring(idx1, idx1 + scope);
            } else {
                sub = text.substring(idx1);
            }

            for (int i = 0; i < sub.length() - name.length(); i++) {
                String tmp = sub.substring(i, i + name.length());
                if (tmp.equals(name)) {
                    if (!isLetter(sub.charAt(i - 1)) && !isLetter(sub.charAt(i + name.length()))) {
                        cnt++;
                    }
                }
            }
            text = text.substring(idx + curName.length());
        }

        return cnt;
    }

    private static boolean isLetter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }

        return false;
    }
}
