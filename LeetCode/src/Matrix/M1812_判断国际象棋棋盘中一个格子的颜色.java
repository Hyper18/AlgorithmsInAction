package Matrix;

/**
 * @author Hyper
 * @date 2024/12/09
 * @file M1812_判断国际象棋棋盘中一个格子的颜色.java
 * <p>
 * 思路
 * 和3274是一个题
 */
public class M1812_判断国际象棋棋盘中一个格子的颜色 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
    }
}
