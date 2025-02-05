package Matrix;

/**
 * @author Hyper
 * @date 2024/12/08
 * @file M782_变为棋盘.java
 * <p>
 * 思路@灵茶山艾府
 * 将问题转化为逆向考虑
 * 想要组成棋盘，有两种行的情况：
 * 1) 0101... 的序列
 * 2) 1010... 的序列
 * 判断能否构成棋盘后，统计最小的交换次数
 */
public class M782_变为棋盘 {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int[] firstRow = board[0], firstCol = new int[n];
        int[] rowCnt = new int[2], colCnt = new int[2];
        for (int i = 0; i < n; i++) {
            rowCnt[firstRow[i]]++;
            firstCol[i] = board[i][0];
            colCnt[firstCol[i]]++;
        }
        if (Math.abs(rowCnt[0] - rowCnt[1]) > 1 || Math.abs(colCnt[0] - colCnt[1]) > 1) {
            return -1;
        }
        for (int[] row : board) {
            boolean same = row[0] == firstRow[0];
            for (int i = 0; i < n; i++) {
                if ((row[i] == firstRow[i]) != same) {
                    return -1;
                }
            }
        }

        return minSwap(firstRow, rowCnt) + minSwap(firstCol, colCnt);
    }

    private int minSwap(int[] nums, int[] cnt) {
        int n = nums.length;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += i % 2 ^ nums[i] ^ (cnt[1] > cnt[0] ? 1 : 0);
        }

        return n % 2 == 1 ? diff / 2 : Math.min(diff, n - diff) / 2;
    }
}
