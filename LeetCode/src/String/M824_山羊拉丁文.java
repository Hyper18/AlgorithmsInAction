package String;

/**
 * @author Hyperspace
 * @date 2022/04/21
 * 模拟，遍历
 */
public class M824_山羊拉丁文 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
            sb = new StringBuilder();
            if (judge(first)) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1)).append(first);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            res.append(sb);
            if (i != words.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    private boolean judge(char first) {
        String list = "aeiouAEIOU";
        return list.indexOf(first) != -1;
    }
}
