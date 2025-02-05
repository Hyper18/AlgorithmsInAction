package basic;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/02/23
 */
public class BASIC_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int rows = in.nextInt();

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(currRow);
            for (int k = 0; k <= currRow.size() - 1; k++) {
                out.print(currRow.get(k) + " ");
            }
            out.print("\n");
        }

        in.close();
        out.close();
    }
}
