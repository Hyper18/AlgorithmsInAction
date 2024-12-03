package Array;

/**
 * @author Hyperspace
 * @date 2024/12/03
 * @file M3274_检查棋盘方格颜色是否相同.java
 */
public class M3274_检查棋盘方格颜色是否相同 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) - '0' + coordinate1.charAt(1)) % 2 == (coordinate2.charAt(0) - '0' + coordinate2.charAt(1)) % 2;
    }

    public boolean checkTwoChessboards2(String a, String b) {
        return (a.charAt(0) + a.charAt(1)) % 2 == (b.charAt(0) + b.charAt(1)) % 2;
    }
}
