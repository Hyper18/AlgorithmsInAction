package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/07/19
 * @file M1233_删除子文件夹.java
 * <p>
 * 思路
 * 模拟
 */
public class M1233_删除子文件夹 {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            String t = folder[i++];
            while (i < n && folder[i].indexOf(t + "/") == 0) {
                i++;
            }
            res.add(t);
        }

        return res;
    }
}
