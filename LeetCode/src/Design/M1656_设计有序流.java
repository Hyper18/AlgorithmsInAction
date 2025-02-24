package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/02/24
 * @file M1656_设计有序流.java
 * <p>
 * 思路
 * 模拟
 */
public class M1656_设计有序流 {
    class OrderedStream {
        private String[] arr;
        private int pos;

        public OrderedStream(int n) {
            arr = new String[n];
            pos = 0;
        }

        public List<String> insert(int idKey, String value) {
            List<String> res = new ArrayList<>();
            arr[idKey - 1] = value;
            if (pos == idKey - 1) {
                while (pos < arr.length && arr[pos] != null) {
                    res.add(arr[pos++]);
                }
            }

            return res;
        }
    }
}
