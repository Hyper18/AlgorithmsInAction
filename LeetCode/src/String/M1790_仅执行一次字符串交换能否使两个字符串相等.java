package String;

/**
 * @author Hyper
 * @date 2022/10/11
 * <p>
 * 思路
 * 模拟
 * 从测试样例来看，需注意的可能情况有：
 * 1. s1和s2为同一字符串
 * 2. 需要交换的两字符t1,t2均相等
 * <p>
 * 其实可以不引入cnt来判断是第几次不同的情况，可直接通过t1的初值情况判断
 * <p>
 * 还可以记录不记录字符，而是记录下标位置来判断
 */
public class M1790_仅执行一次字符串交换能否使两个字符串相等 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length(), cnt = 0;
        char t1 = ' ', t2 = ' ';
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // 注意只需为第一次赋初值
                if (cnt == 0) {
                    t1 = s1.charAt(i);
                    t2 = s2.charAt(i);
                }
                cnt++;
            }
            if (cnt == 2 && t1 == s2.charAt(i) && t2 == s1.charAt(i)) {
                flag = true;
            }
        }
        if (cnt > 2) {
            flag = false;
        }
        return flag;
    }

    public boolean areAlmostEqual2(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        char t1 = ' ', t2 = ' ';
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // 第一次出现不同
                if (t1 == ' ') {
                    t1 = s1.charAt(i);
                    t2 = s2.charAt(i);
                } else if (!flag && t1 == s2.charAt(i) && t2 == s1.charAt(i)) {
                    // 第二次出现不同，通过!flag指定了只有第二次会访问
                    flag = true;
                } else {
                    // 第三次返回false
                    return false;
                }
            }
        }

        return flag;
    }

    public boolean areAlmostEqual3(String s1, String s2) {
        int n = s1.length();
        int i = -1, j = -1;
        for (int idx = 0; idx < n; idx++) {
            if (s1.charAt(idx) != s2.charAt(idx)) {
                if (i < 0) {
                    i = idx;
                } else if (j < 0) {
                    j = idx;
                } else {
                    return false;
                }
            }
        }

        return i < 0 || j >= 0 && s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
