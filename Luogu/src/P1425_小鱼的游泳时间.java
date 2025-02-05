import java.util.Scanner;

/**
 * @author Hyper
 */
public class P1425_小鱼的游泳时间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hStart = sc.nextInt();
        int minStart = sc.nextInt();
        int hEnd = sc.nextInt();
        int minEnd = sc.nextInt();

        if (minEnd - minStart < 0) {
            minEnd += 60;
            hEnd--;
        }

        int hResult = hEnd - hStart;
        int minResult = minEnd - minStart;
        System.out.println(hResult + " " + minResult);
    }
}
