package Greedy;

/**
 * @author Hyper
 * @date 2024/09/24
 * @file M2207_字符串中最多数目的子序列.java
 * <p>
 * 思路
 * 贪心+前缀和
 * 可以发现核心是两部分
 * 一部分是新插入的放哪收益最大
 * 另一部分是原来的数目统计，可以发现跟pattern不包含的元素没任何关系，直接丢掉
 * 1. 初提交版，卡了一次样例，需要特判pattern为同一个元素的情况
 * "vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign"
 * "rr"
 * 2. 不需要预先处理text，直接统计可以一次遍历
 */
public class M2207_字符串中最多数目的子序列 {
    public long maximumSubsequenceCount(String text, String pattern) {
        StringBuilder sb = new StringBuilder();
        int cnt1 = 0;
        for (char c : text.toCharArray()) {
            if (pattern.indexOf(c) != -1) {
                if (c == pattern.charAt(0)) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    cnt1++;
                }
            }
        }
        int cnt2 = sb.length() - cnt1;
        if (pattern.charAt(0) == pattern.charAt(1)) {
            return (long) cnt2 * (cnt2 + 1) / 2;
        }
        char[] c = sb.toString().toCharArray();
        int n = c.length;
        int[] pre = new int[n];
        long ans;
        if (cnt1 >= cnt2) {
            ans = cnt1;
            for (int i = n - 2; i >= 0; i--) {
                pre[i] = pre[i + 1] + (c[i + 1] - '0');
            }
            for (int i = 0; i < n; i++) {
                if (c[i] == '0') {
                    ans += pre[i];
                }
            }
        } else {
            ans = cnt2;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + (c[i - 1] == '0' ? 1 : 0);
            }
            for (int i = n - 1; i >= 0; i--) {
                if (c[i] == '1') {
                    ans += pre[i];
                }
            }
        }

        return ans;
    }

    public long maximumSubsequenceCount2(String text, String pattern) {
        int cnt1 = 0, cnt2 = 0;
        long ans = 0;
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                ans += cnt1;
                cnt2++;
            }
            if (c == pattern.charAt(0)) {
                cnt1++;
            }
        }

        return ans + Math.max(cnt1, cnt2);
    }
}
