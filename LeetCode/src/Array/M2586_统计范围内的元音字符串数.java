package Array;

/**
 * @author Hyperspace
 * @date 2023/11/07
 * @file M2586_统计范围内的元音字符串数.java
 * <p>
 * 思路
 * 模拟
 */
public class M2586_统计范围内的元音字符串数 {
    final String vowels = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (vowels.contains(words[i].substring(0, 1)) && vowels.contains(words[i].substring(words[i].length() - 1))) {
                ans++;
            }
        }

        return ans;
    }
}
