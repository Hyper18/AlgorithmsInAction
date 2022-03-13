package Y2013A;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/13
 * @time 78ms
 * Q7错误票据
 */
public class PREV_285 {
    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int extra;

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        in.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] nums = in.nextLine().split(" ");
            for (String num : nums) {
                int iNum = Integer.parseInt(num);
                if (list.contains(iNum)) {
                    extra = iNum;
                } else {
                    list.add(iNum);
                }
            }
        }

        Collections.sort(list);
        int p1 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - p1 != 1) {
                int res = list.get(i) - 1;
                out.println(res + " " + extra);
                break;
            }
            p1 = list.get(i);
        }

        out.close();
    }
}
