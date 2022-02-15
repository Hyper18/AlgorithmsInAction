package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/02/15
 * 元宵打卡
 * <p>
 * 思路
 * 1. 模拟矩阵遍历
 * 2. 预处理
 */
public class M1380_矩阵中的幸运数 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                boolean minFlag = true;
                boolean maxFlag = true;
                for (int k = 0; k < colLen; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        minFlag = false;
                        break;
                    }
                }
                if (minFlag) {
                    for (int k = 0; k < rowLen; k++) {
                        if (matrix[k][j] > matrix[i][j]) {
                            maxFlag = false;
                            break;
                        }
                    }

                    if (maxFlag) {
                        res.add(matrix[i][j]);
                    }
                }
            }
        }

        return res;
    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] min = new int[50];
        int[] max = new int[50];
        for (int i = 0; i < rowLen; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < colLen; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == min[i] && matrix[i][j] == max[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
