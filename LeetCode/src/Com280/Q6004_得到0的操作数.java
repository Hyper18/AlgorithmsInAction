package Com280;

/**
 * @author Hyperspace
 * @date 2022/02/13
 * 注意判断0的情况
 */
public class Q6004_得到0的操作数 {
    public static void main(String[] args) {
        System.out.println(countOperations(0, 0));
    }

    public static int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int cnt = 0;
        while (true) {
            if (num1 > num2) {
                num1 -= num2;
                cnt++;
            } else if (num1 < num2) {
                num2 -= num1;
                cnt++;
            } else {
                cnt++;
                break;
            }
        }
        return cnt;
    }
}
