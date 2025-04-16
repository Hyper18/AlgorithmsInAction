package HW;

import java.io.*;
import java.util.*;
import java.util.function.Function;

/**
 * @author Hyperspace
 * @date 2025/04/16
 * @file HJ68_成绩排序.java
 */
public class HJ68_成绩排序 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = next(Integer::parseInt), op = next(Integer::parseInt);
        List<Student> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = next(Function.identity());
            int a = next(Integer::parseInt);
            li.add(new Student(s, a));
        }
        li.sort((a, b) -> op == 0 ? b.grade - a.grade : a.grade - b.grade);
        for (Student s : li) {
            out.println(s.name + " " + s.grade);
        }

        close();
    }

    static class Student {
        String name;
        int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static <T> T next(Function<String, T> parser) throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return parser.apply(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
