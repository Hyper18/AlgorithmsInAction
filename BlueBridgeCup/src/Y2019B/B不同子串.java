package Y2019B;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/04/06
 */
public class B不同子串 {
    public static void main(String[] args) {
        String s = "0100110001010001";
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // 踩坑啊！！由源码可知，这里是截取左闭右开，也就是endIndex不包含！！
                set.add(s.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
