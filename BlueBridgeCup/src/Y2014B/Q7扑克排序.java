package Y2014B;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/03/20
 * 全排列+set去重
 */
public class Q7扑克排序 {
    private static Set<String> set = new HashSet<>();
    private static char[] seq;

    public static void main(String[] args) throws IOException {
        seq = new char[]{'A', 'A', '2', '2', '3', '3', '4', '4'};
        backtrack(0);
        System.out.println(set.iterator().next());
    }

    private static void backtrack(int k) {
        if (k == seq.length) {
            check();
            return;
        }
        for (int i = k; i < seq.length; i++) {
            swap(i, k);
            backtrack(k + 1);
            swap(i, k);
        }
    }

    private static void check() {
        String s = new String(seq);
        if (s.lastIndexOf('A') - s.indexOf('A') == 2
                && s.lastIndexOf('2') - s.indexOf('2') == 3
                && s.lastIndexOf('3') - s.indexOf('3') == 4
                && s.lastIndexOf('4') - s.indexOf('4') == 5) {
            set.add(s);
        }
    }

    private static void swap(int i, int j) {
        char tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}
