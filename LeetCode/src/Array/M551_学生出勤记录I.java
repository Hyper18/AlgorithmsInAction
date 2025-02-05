package Array;

/**
 * @author Hyper
 * @date 2024/08/18
 * @file M551_学生出勤记录I.java
 */
public class M551_学生出勤记录I {
    public boolean checkRecord(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                cnt++;
                if (cnt == 2) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (i + 2 < n && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                    return false;
                }
            }
        }

        return true;
    }
}
