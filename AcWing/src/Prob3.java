import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/11
 */
public class Prob3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1010;
    private static List<Integer>[] p = new List[N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        // init
        n = nextInt();
        for (int i = 0; i < n; i++) {
            m = nextInt();
            int districtScore = nextInt();
            p[i] = new ArrayList<Integer>(m + 1);
            p[i].add(0, districtScore);
            for (int j = i + 1; j < m + 1; j++) {
                int memberScore = nextInt();
                p[i].add(i, memberScore);
            }
        }
        close();
    }

    /**
     * @param k the given rank
     * @return the idx to the district currently ranked kth
     */
    private static int getKthDistrict(int k) {
        Arrays.sort(p, 0, n);
//        int low = 0, high = n - 1;
//        while(low < high) {
//            int mid = low + ((high - low) >> 1);
//            if (p[mid].get(0) < )
//        }
        return k - 1;
    }

    private static boolean inCompete(int rank, int size, int increment) {
        for (int i = 1; i < size; i++) {
            p[rank].set(i, p[rank].get(i) + increment);
            if (p[rank].get(i) < 0) {
                return true;
            }
        }
        p[rank].set(0, p[rank].get(0) + increment * (size - 1));
        return false;
    }

    private static boolean compete(int k, int j, boolean kWins) {
        int kScore = p[k].get(0);
        int jScore = p[k].get(0);
        if (kScore == jScore || k < 1 || k > n || j < 1 || j > n) {
            return false;
        }
        // given increment: default 10
        int increment = 10;
        boolean isDisqualified = false;
        if (kScore > jScore) {
            kWins = true;
            inCompete(k, p[k].size(), increment);
            isDisqualified = inCompete(j, p[j].size(), -increment);
            // operation
        } else {
            kWins = false;
            inCompete(j, p[j].size(), increment);
            isDisqualified = inCompete(k, p[k].size(), -increment);
            // operation
        }
        return kWins;
    }

//    private static int getStrongest() {
//
//    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
