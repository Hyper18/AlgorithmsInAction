package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/02/26
 * @file M1472_设计浏览器历史记录.java
 * <p>
 * 思路
 * 模拟
 */
public class M1472_设计浏览器历史记录 {
    class BrowserHistory {
        private List<String> urls;
        private int pos;

        public BrowserHistory(String homepage) {
            urls = new ArrayList<String>() {{
                add(homepage);
            }};
            pos = 0;
        }

        public void visit(String url) {
            if (pos < urls.size() - 1) {
                urls.subList(pos + 1, urls.size()).clear();
            }
            urls.add(url);
            pos++;
        }

        public String back(int steps) {
            pos = Math.max(0, pos - steps);
            return urls.get(pos);
        }

        public String forward(int steps) {
            pos = Math.min(urls.size() - 1, pos + steps);
            return urls.get(pos);
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
