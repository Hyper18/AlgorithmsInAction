package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/02
 * <p>
 * 思路
 * 使用sort，自定义比较器
 */
public class ALGO_141 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        Student[] stu = new Student[n];
        for (int i = 0; i < n; i++) {
            stu[i] = new Student(in.next(), in.next(), in.nextInt(), in.nextInt());
        }

        Arrays.sort(stu);

        for (Student s : stu) {
            out.println(s.name + " " + s.sex + " " + s.age + " " + s.grade);
        }

        in.close();
        out.close();
    }

    private static class Student implements Comparable<Student> {
        String name;
        String sex;
        int age;
        int grade;

        public Student(String name, String sex, int age, int grade) {
            super();
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student stu) {
            return this.grade - stu.grade;
        }
    }
}
