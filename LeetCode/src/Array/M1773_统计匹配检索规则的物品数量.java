package Array;

import java.util.List;

/**
 * @author Hyper
 * @date 2022/10/29
 * <p>
 * 思路
 * 1. 模拟
 * 2. 哈希
 */
public class M1773_统计匹配检索规则的物品数量 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (List item : items) {
            switch (ruleKey) {
                case "type":
                    if (ruleValue.equals(item.get(0))) {
                        ans++;
                    }
                    break;
                case "color":
                    if (ruleValue.equals(item.get(1))) {
                        ans++;
                    }
                    break;
                case "name":
                    if (ruleValue.equals(item.get(2))) {
                        ans++;
                    }
                    break;
            }
        }

        return ans;
    }
}
