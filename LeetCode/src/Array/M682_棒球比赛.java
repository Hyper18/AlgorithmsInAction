package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2024/07/29
 * @file M682_棒球比赛.java
 * <p>
 * 思路
 * 做起来比想象麻烦
 * 处理记录的小问题比较多
 * C+的情况
 * 如果用两个变量维护前两个元素的话没法处理
 * 由于C可以移除一条记录
 * 这时没法得到倒数第三个元素的值
 */
public class M682_棒球比赛 {
    public int calPoints(String[] operations) {
        int ans = 0, t;
        Deque<Integer> stk = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "C":
                    ans -= stk.pop();
                    break;
                case "D":
                    t = stk.peek() << 1;
                    ans += t;
                    stk.push(t);
                    break;
                case "+":
                    int t1 = stk.pop(), t2 = stk.pop();
                    t = t1 + t2;
                    ans += t;
                    stk.push(t2);
                    stk.push(t1);
                    stk.push(t);
                    break;
                default:
                    t = Integer.parseInt(op);
                    ans += t;
                    stk.push(t);
                    break;
            }
        }

        return ans;
    }
}
