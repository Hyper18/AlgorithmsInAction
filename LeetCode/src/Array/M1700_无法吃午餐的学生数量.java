package Array;

/**
 * @author Hyper
 * @date 2022/10/19
 * <p>
 * 思路
 * 模拟
 */
public class M1700_无法吃午餐的学生数量 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int[] cnt = new int[2];
        for (int stu : students) {
            cnt[stu]++;
        }
        for (int i = 0; i < n; i++) {
            if (--cnt[sandwiches[i]] < 0) {
                return n - i;
            }
        }

        return 0;
    }
}
