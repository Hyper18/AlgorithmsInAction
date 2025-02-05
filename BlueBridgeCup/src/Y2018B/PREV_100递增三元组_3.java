//package Y2018B;
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///**
// * @author Hyper
// * @date 2022/04/06
// * 二分+区间和 -- O(nlogn)
// * 思路@白之月
// */
//public class PREV_100递增三元组_3 {
//    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    public static StringTokenizer tk = new StringTokenizer("");
//    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
//    private static int[] A, B, C;
//
//    public static void main(String[] args) throws IOException {
//        int n = nextInt();
//        A = new int[n + 1];
//        B = new int[n + 1];
//        C = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            A[i] = nextInt();
//        }
//        for (int j = 1; j <= n; j++) {
//            B[j] = nextInt();
//        }
//        for (int k = 1; k <= n; k++) {
//            C[k] = nextInt();
//        }
//        Arrays.sort(A);
//        Arrays.sort(C);
//
//        int ans = 0;
//        int pa, pc;
//        for (int j = 1; j <= n; j++) {
//            pa = binarySearchLeft(1, n, B[j]);
//            pc = binarySearchRight(1, n, B[j]);
//            if (A[pa] >= B[j] || C[pc] <= B[j]) {
//                continue;
//            }
//            while (pa + 1 <= n && A[pa] == A[pa + 1]) {
//                pa++;
//            }
//            ans += pa * (n - pc + 1);
//        }
//
//        out.println(ans);
//
//        close();
//    }
//
//    private static int binarySearchLeft(int low, int high, int target) {
//        while (low < high) {
//            int mid = (low + high) >> 1;
//            if (C[mid] > target) {
//                high = mid;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
//
//    private static int binarySearchRight(int low, int high, int target) {
//        while (low < high) {
//            int mid = (low + high + 1) >> 1;
//            if (C[mid] < target) {
//                low = mid;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return low;
//    }
//
//    public static int nextInt() throws IOException {
//        while (!tk.hasMoreTokens()) {
//            tk = new StringTokenizer(in.readLine());
//        }
//        return Integer.parseInt(tk.nextToken());
//    }
//
//    public static void close() throws IOException {
//        in.close();
//        out.close();
//    }
//}
