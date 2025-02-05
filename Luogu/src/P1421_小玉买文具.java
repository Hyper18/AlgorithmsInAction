import java.util.Scanner;

/**
 * @author Hyper
 */
public class P1421_小玉买文具 {
    public static final int PEN_A = 1;
    public static final int PEN_B = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(calculate(a, b));

    }

    private static int calculate(int a, int b) {
        int sum = a * 10 + b;
        int penPrice = PEN_A * 10 + PEN_B;
        return sum / penPrice;
    }
}
