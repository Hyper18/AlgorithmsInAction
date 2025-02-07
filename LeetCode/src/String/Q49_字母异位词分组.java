package String;

import java.util.*;

/**
 * @author Hyper
 * @date 2025/02/05
 * @file Q49_字母异位词分组.java
 */
public class Q49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        int idx = 0;
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            if (mp.containsKey(s)) {
                res.get(mp.get(s)).add(str);
            } else {
                res.add(new ArrayList<String>() {{
                    add(str);
                }});
                mp.put(s, idx++);
            }
        }

        return res;
    }
}
