package Design;

/**
 * @author Hyperspace
 * @date 2025/02/25
 * @file M2502_设计内存分配器.java
 * <p>
 * 思路
 * 模拟
 */
public class M2502_设计内存分配器 {
    class Allocator {
        private int[] arr;

        public Allocator(int n) {
            arr = new int[n];
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < arr.length - size; i++) {
                int j = i + size - 1;
                if (check(i, j)) {
                    fill(i, j, mID);
                    return i;
                }
            }

            return -1;
        }

        private boolean check(int i, int j) {
            while (i < j) {
                if (arr[i++] != 0) {
                    return false;
                }
            }

            return arr[i] == 0;
        }

        private void fill(int i, int j, int num) {
            while (i <= j) {
                arr[i++] = num;
            }
        }

        public int freeMemory(int mID) {
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == mID) {
                    arr[i] = 0;
                    ans++;
                }
            }

            return ans;
        }
    }

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
}
