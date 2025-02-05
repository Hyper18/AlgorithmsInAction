package Y2015A;

/**
 * @author Hyper
 * @date 2022/03/21
 */
public class Q1熊怪吃核桃 {
    public static void main(String[] args) {
        int n = 1543;
        int ans = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                ans++;
                n--;
            }
            n /= 2;
        }

        System.out.println(ans);
    }
}
