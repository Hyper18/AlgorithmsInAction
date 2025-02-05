package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/03/03
 * @file M1487_保证文件名唯一.java
 * <p>
 * 思路
 * 模拟，注意自带编号的重复词
 */
public class M1487_保证文件名唯一 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = names[i];
            res[i] = s;
            if (mp.containsKey(s)) {
                int idx = mp.get(s);
                while (mp.containsKey(s + "(" + idx + ")")) {
                    idx++;
                }
                mp.put(s, idx + 1);
                mp.put(s + "(" + idx + ")", 1);
                res[i] += "(" + idx + ")";
            } else {
                mp.put(s, 1);
            }
        }

        return res;
    }
}
