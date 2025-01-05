package Design;

/**
 * @author Hyperspace
 * @date 2025/01/05
 * @file M2241_设计一个ATM机器.java
 * <p>
 * 思路
 * 贪心
 */
public class M2241_设计一个ATM机器 {
    class ATM {
        private final int[] MONEY = new int[]{20, 50, 100, 200, 500};
        private int[] cnts;

        public ATM() {
            cnts = new int[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                cnts[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5], tmp = new int[5];
            System.arraycopy(cnts, 0, tmp, 0, 5);
            for (int i = 4; i >= 0; i--) {
                if (tmp[i] == 0) {
                    continue;
                }
                int cnt = amount >= MONEY[i] ? Math.min(amount / MONEY[i], tmp[i]) : -1;
                if (cnt > 0) {
                    amount -= MONEY[i] * cnt;
                    res[i] = cnt;
                    tmp[i] -= cnt;
                }
            }
            if (amount > 0) {
                return new int[]{-1};
            }
            cnts = tmp;

            return res;
        }
    }

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
}
