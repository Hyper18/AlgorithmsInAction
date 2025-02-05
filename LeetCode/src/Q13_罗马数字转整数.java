/**
 * @author Hyper
 * 解题思路
 * 一开始想法很复杂，考虑前后位置上的减法；
 * 后来借鉴思路是抓核心问题，对于第一个字符对应的数值，依次向后找，遇到比它还大的则减去，否则累加和。
 * 最后再处理最后一位上的加和，得到结果。值得多斟酌，单个for循环，算法复杂度为O(n)
 */
public class Q13_罗马数字转整数 {
    public int romanToInt(String s) {
        int sum = 0;
        int formerNum = transform(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int latterNum = transform(s.charAt(i));
            if (formerNum < latterNum) {
                sum -= formerNum;
            } else {
                sum += formerNum;
            }
            formerNum = latterNum;
        }
        return sum + formerNum;
    }

    private int transform(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
