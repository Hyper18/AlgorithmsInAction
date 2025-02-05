package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/08/03
 * @file M722_删除注释.java
 * <p>
 * 思路
 * 模拟
 * 遍历行，分类讨论：
 * 1）不在注释中
 * /* 进注释
 * // 忽略本行
 * 2）在注释中
 */
public class M722_删除注释 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String l : source) {
            int i = 0, n = l.length();
            while (i < n) {
                if (!flag) {
                    if (i < n - 1 && l.charAt(i) == '/') {
                        if (l.charAt(i + 1) == '*') {
                            flag = true;
                            i++;
                        } else if (l.charAt(i + 1) == '/') {
                            break;
                        }
                    }
                    if (!flag) {
                        sb.append(l.charAt(i));
                    }
                } else {
                    if (i < n - 1 && l.charAt(i) == '*' && l.charAt(i + 1) == '/') {
                        flag = false;
                        i++;
                    }
                }
                i++;
            }
            if (!flag && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
}
