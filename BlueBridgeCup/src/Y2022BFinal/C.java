//package Y2022BFinal;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class C {
//	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	public static StringTokenizer tk = new StringTokenizer("");
//	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
//	private static final int N = 200000 * 5 + 10;
//	private static int[] p = new int[N];
//
//	public static void main(String[] args) throws IOException {
//		int n = nextInt(), m = nextInt();
//		int l = 500000, r = 500000 + n;
//		for (int i = 500000; i <= n; i++) {
//			p[i] = i;
//		}
//		while(m-- > 0) {
//			String input = in.readLine();
//			char c = input.charAt(0);
//			int x = (int)input.charAt(1);
//
//			if (c == 'L') {
//				movl(x, l, r);
//				l--;
//			} else if (c == 'R') {
//				movr(x, l, r);
//				r++;
//			}
//		}
//
//		for (int i = l; i <= r; i++) {
//			if (p[i] == 0) {
//				continue;
//			}
//			out.print(p[i] + " ");
//		}
//
//		close();
//	}
//
//	private static void movl(int x, int l, int r) {
//		int idx = 0;
//		for(int i = l; i <= r; i++) {
//			if(p[i] == x) {
//				idx = i;
//				break;
//			}
//		}
//		p[l - 1] = p[idx];
//		p[idx] = 0;
//	}
//
//	private static void movr(int x, int l, int r) {
//		int idx = 0;
//		for(int i = l; i <= r; i++) {
//			if(p[i] == x) {
//				idx = i;
//				break;
//			}
//		}
//		p[r + 1] = p[idx];
//		p[idx] = 0;
//	}
//
//	public static int nextInt() throws IOException {
//		while(!tk.hasMoreTokens()) {
//			tk = new StringTokenizer(in.readLine());
//		}
//		return Integer.parseInt(tk.nextToken());
//	}
//
//	public static void close() throws IOException {
//		in.close();
//		out.close();
//	}
//}
