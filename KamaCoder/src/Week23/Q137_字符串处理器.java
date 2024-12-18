package Week23;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file Q137_字符串处理器.java
 * <p>
 * 题目描述
 * 产品代码需要设计一个带游标的字符串处理器，它需要实现以下功能:
 * 插入：在游标所在处添加文本，其对应操作为 insert str,insert
 * 表示插入操作命令关键字 (区分大小写)，
 * str 表示待操作的字符串，
 * insert 操作执行后将 str 拼接到游标当前位置，同时游标移动到 str 的右边;
 * 删除：在游标所在处删除文本，其对应操作为 delete len，delete
 * 表示删除操作命令关键字(区分大小写)，
 * len 为整数，表示删除游标左边字符串的长度，
 * 如果len大于游标所在处左侧字符串长度 或者len 为负数 则认为输入命名非法，不做任何处理;
 * 移动：将游标往左或者往右移动，其对应操 move cnt，move
 * 表示游标移动操作命令关键字(区分大小写)，
 * cnt 为整数，表示游标移动次数，cnt
 * 如果为负数时表示向左移动 cnt 次，如果为正数表示向右移动 cnt 次数，
 * 如果 cnt 等于 0，则表示游标不移动，
 * 如果移动次数 cnt 超过字符串左右边界则认为输入命名非法，不做任何处理;
 * 复制：将游标左边字符串复制并插入到游标的右边，游标位置不变
 * (如果游标右边有字符，复制插入到游标和原有字符中间)，
 * 其对应操作为 copy，copy 表示复制操作命令关键字(区分大小写);
 * <p>
 * 输入描述
 * 支持输入多行，每个仅支持输入一个操作命令，
 * 当输入 end 结束操作命令关键字（区分大小写）时则代表操作停止。
 * 首次执行时字符串处理器内部字符串为空，游标位置索引为 0，此时字符串处理器序列化结果为 1。
 * 1 <= str.length<= 40
 * -40 <= len<= 40
 * -40 <= cnt <= 40
 * 调用 insert，delete，move 和copy 的总次数不超过 200 次。
 * <p>
 * 输出描述
 * 当前字符串处理器的序列化结果，游标使用“|”来表示。
 * <p>
 * 思路
 * 模拟
 * 根据题意，delete和move需要处理边界情况
 */
public class Q137_字符串处理器 {
    private static StringBuilder sb = new StringBuilder();
    private static int idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if ("end".equals(s)) {
                break;
            }
            String op = s.split(" ")[0];
            switch (op) {
                case "insert":
                    insert(s.split(" ")[1]);
                    break;
                case "delete":
                    delete(Integer.parseInt(s.split(" ")[1]));
                    break;
                case "move":
                    move(Integer.parseInt(s.split(" ")[1]));
                    break;
                case "copy":
                    copy();
                    break;
            }
        }
        System.out.println(sb.insert(idx, "|").toString());
    }

    private static void insert(String s) {
        if (idx < 0) {
            return;
        }
        sb.insert(idx, s);
        move(s.length());
    }

    private static void delete(int n) {
        if (n > idx || n < 0) {
            return;
        }
        sb.delete(idx - n, idx);
        move(-n);
    }

    private static void move(int n) {
        if (idx + n > sb.length() || idx + n < 0) {
            return;
        }
        idx += n;
    }

    private static void copy() {
        if (idx < 0 || idx > sb.length()) {
            return;
        }
        sb.insert(idx, sb.substring(0, idx));
    }
}
