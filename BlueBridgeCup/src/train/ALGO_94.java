package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 利用hash设定二元组
 * 注意next的使用
 */
public class ALGO_94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String id = in.next();
            String sex = in.next();
            map.put(name, sex);
            map.put(id, sex);
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String name = in.next();
            String id = in.next();
            String sex1 = map.get(name);
            String sex2 = map.get(id);

            if (!sex1.equals(sex2)) {
                out.println("Y");
            } else {
                out.println("N");
            }
        }

        in.close();
        out.close();
    }
}
