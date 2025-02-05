package Y2014B;

/**
 * @author Hyper
 * @date 2022/03/20
 * 模拟即可
 */
public class Q3猜字母 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrs";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 106; i++) {
            sb.append(str);
        }
        String newStr = sb.toString();
        while (newStr.length() != 1) {
            StringBuilder cut = new StringBuilder();
            for (int i = 1; i < newStr.length(); i += 2) {
                cut.append(newStr.charAt(i));
            }
            newStr = cut.toString();
        }

        System.out.println(newStr);
    }
}
