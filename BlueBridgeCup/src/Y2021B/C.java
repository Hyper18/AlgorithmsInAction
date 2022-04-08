package Y2021B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {
    private static final int x = 19;
    private static final int y = 20;
    private static Set<String> ans = new HashSet<>();

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                set.add(i * 100 + j);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int a = list.get(i);
            for (int j = i + 1; j < len; j++) {
                int b = list.get(j);
                getLine(a, b);
            }
        }

        System.out.println(ans.size());
    }

    private static void getLine(int a, int b) {
        // TODO Auto-generated method stub
        int x1 = a / 100, x2 = b / 100;
        int y1 = a % 100, y2 = b % 100;

        int up = y1 - y2;
        int down = x1 - x2;
        int div = gcd(up, down);
        String K = (up / div) + " " + (down / div);

        if (down == 0) {
            ans.add("x = " + x1);
            return;
        }

        int up_kx = up * x1;
        int up_y = y1 * down;
        int up_b = up_y - up_kx;

        int div_b = gcd(up_kx, down);
        String B = (up_b / div_b) + " " + (down / div_b);
        ans.add(K + " " + B);
    }

    private static int gcd(int a, int b) {
        // TODO Auto-generated method stub
        return b == 0 ? a : gcd(b, a % b);
    }
}
