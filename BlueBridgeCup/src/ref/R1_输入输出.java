package ref;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/09
 */
public class R1_输入输出 {
    public static void main(String[] args) {
        /*
         * 获取输入
         */
        Scanner sc = new Scanner(System.in);

        /*
         * 获取输入参数
         */
        int num = sc.nextInt();
        float fl = sc.nextFloat();
        double dou = sc.nextDouble();
        String str = sc.next();
        String line = sc.nextLine();

        /*
         * 处理输出
         */
        System.out.print(fl);
        System.out.println(num);
        System.out.printf("%f %f %s %s\n", fl, dou, str, line);
        System.out.format("%f %f %s %s\n", fl, dou, str, line);

        /*
         * 关流
         */
        sc.close();
    }
}
