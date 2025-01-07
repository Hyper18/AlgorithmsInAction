package String;

/**
 * @author Hyperspace
 * @date 2025/01/07
 * @file M3019_按键变更的次数.java
 */
public class M3019_按键变更的次数 {
    public int countKeyChanges(String s) {
        int n = s.length(), ans = 0;
        for (int i = 1; i < n; i++) {
            char a = s.charAt(i), b = s.charAt(i - 1);
            if (a - 32 == b || a + 32 == b || a == b) {
                continue;
            }
            ans++;
        }

        return ans;
    }

    public int countKeyChanges2(String s) {
        int n = s.length(), ans = 0;
        for (int i = 1; i < n; i++) {
            char a = s.charAt(i), b = s.charAt(i - 1);
            if (Character.toUpperCase(a) == Character.toUpperCase(b)) {
                continue;
            }
            ans++;
        }

        return ans;
    }
}
