package Array;

/**
 * @author Hyper
 * @date 2024/06/18
 * @file M2288_价格减免.java
 * <p>
 * 思路
 * 模拟
 * 1. 将每个单词拿出来单独处理
 * 2. 直接在原字符串上修改，需要判断$前为空格（法1split相当于已经预处理了），并特判0的情况
 * <p>
 * 体感第二种快，实际跑出来高达1280ms。。。
 * 主要需要注意输出格式的处理
 */
public class M2288_价格减免 {
    final char MONEY = '$';

    public String discountPrices(String sentence, int discount) {
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String ss : s) {
            if (!check(ss)) {
                sb.append(ss).append(" ");
                continue;
            }
            double p = Double.parseDouble(ss.substring(1)) * (100 - discount) / 100;
            sb.append(MONEY).append(String.format("%.2f", p)).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    private boolean check(String s) {
        int n = s.length();
        if (n <= 1 || s.indexOf(MONEY) != 0) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public String discountPrices2(String s, int discount) {
        s = " " + s + " ";
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            while (i < s.length() && s.charAt(i) != '$') {
                i++;
            }
            j = i + 1;
            boolean flag = true;
            while (j < s.length() && s.charAt(j) != ' ') {
                if (!(Character.isDigit(s.charAt(j)) || s.charAt(j) == '.')) {
                    flag = false;
                    break;
                }
                j++;
            }
            if (!flag || j - i == 1 || s.charAt(i - 1) != ' ' || s.charAt(i + 1) == '0') {
                i = j + 1;
                continue;
            }
            double p = Double.parseDouble(s.substring(i + 1, j));
            String t = String.format("%.2f", p * (100 - discount) / 100);
            s = s.substring(0, i + 1) + t + s.substring(j);
            i += t.length() + 1;
        }

        return s.substring(1, s.length() - 1);
    }
}
