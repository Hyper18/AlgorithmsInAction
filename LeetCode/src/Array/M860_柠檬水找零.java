package Array;

/**
 * @author Hyperspace
 * @date 2023/07/22
 * @file M860_柠檬水找零.java
 * <p>
 * 思路
 * 模拟
 */
public class M860_柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int x = 0, y = 0;
        for (int b : bills) {
            switch (b) {
                case 5:
                    x++;
                    break;
                case 10:
                    if (x == 0) {
                        return false;
                    }
                    y++;
                    x--;
                    break;
                case 20:
                    if (y > 0) {
                        y--;
                        x--;
                    } else {
                        x -= 3;
                    }
                    break;
            }
            if (x < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int x = 0, y = 0;
        for (int b : bills) {
            if (b == 5) {
                x++;
            } else if (b == 10) {
                if (x == 0) {
                    return false;
                }
                y++;
                x--;
            } else if (y > 0) {
                y--;
                x--;
            } else {
                x -= 3;
            }
            if (x < 0) {
                return false;
            }
        }

        return true;
    }
}
