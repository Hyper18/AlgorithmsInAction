package Design;

/**
 * @author Hyper
 * @date 2025/02/27
 * @file M2296_设计一个文本编辑器.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 对顶栈@灵茶山艾府
 * 分别使用两个栈 l, r 保存光标左、右侧的文本
 */
public class M2296_设计一个文本编辑器 {
    class TextEditor {
        StringBuilder sb;
        private int pos;

        public TextEditor() {
            sb = new StringBuilder();
            pos = 0;
        }

        public void addText(String text) {
            sb.insert(pos, text);
            pos += text.length();
        }

        public int deleteText(int k) {
            int len = Math.min(pos, k);
            sb.delete(pos - len, pos);
            pos -= len;

            return len;
        }

        public String cursorLeft(int k) {
            if (pos < k) {
                pos = 0;
                return "";
            }
            pos -= k;

            return sb.substring(Math.max(pos - 10, 0), pos);
        }

        public String cursorRight(int k) {
            int n = sb.length();
            pos = Math.min(pos + k, n);

            return sb.substring(Math.max(pos - 10, 0), pos);
        }
    }

    class TextEditor2 {
        private StringBuilder l, r;

        public TextEditor2() {
            l = new StringBuilder();
            r = new StringBuilder();
        }

        public void addText(String text) {
            l.append(text);
        }

        public int deleteText(int k) {
            int len = Math.min(k, l.length());
            l.setLength(l.length() - len);

            return len;
        }

        public String cursorLeft(int k) {
            while (k > 0 && l.length() > 0) {
                r.append(l.charAt(l.length() - 1));
                l.setLength(l.length() - 1);
                k--;
            }

            return getText();
        }

        public String cursorRight(int k) {
            while (k > 0 && r.length() > 0) {
                l.append(r.charAt(r.length() - 1));
                r.setLength(r.length() - 1);
                k--;
            }

            return getText();
        }

        private String getText() {
            return l.substring(Math.max(l.length() - 10, 0));
        }
    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
}
