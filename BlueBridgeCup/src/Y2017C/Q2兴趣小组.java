package Y2017C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/04/02
 * <p>
 * 标题：兴趣小组
 * <p>
 * 为丰富同学们的业余文化生活，某高校学生会创办了3个兴趣小组
 * （以下称A组，B组，C组）。
 * 每个小组的学生名单分别在【A.txt】,【B.txt】和【C.txt】中。
 * 每个文件中存储的是学生的学号。
 * <p>
 * 由于工作需要，我们现在想知道：
 * 既参加了A组，又参加了B组，但是没有参加C组的同学一共有多少人？
 * <p>
 * 请你统计该数字并通过浏览器提交答案。
 * <p>
 * 注意：答案是一个整数，不要提交任何多余的内容。
 * <p>
 * --------------------
 * <p>
 * 笨笨有话说：
 * 哇塞！数字好多啊！一眼望过去就能发现相同的，好像没什么指望。
 * 不过，可以排序啊，要是每个文件都是有序的，那就好多了。
 * <p>
 * 歪歪有话说：
 * 排什么序啊，这么几行数字对计算机不是太轻松了吗？
 * 我看着需求怎么和中学学过的集合很像啊.....
 */
public class Q2兴趣小组 {
    public static void main(String[] args) throws IOException {
        BufferedReader text1 = new BufferedReader(new FileReader("C:\\Users\\Vincent\\IdeaProjects\\AlgorithmsInAction\\BlueBridgeCup\\src\\Y2017C\\A.txt"));
        BufferedReader text2 = new BufferedReader(new FileReader("C:\\Users\\Vincent\\IdeaProjects\\AlgorithmsInAction\\BlueBridgeCup\\src\\Y2017C\\B.txt"));
        BufferedReader text3 = new BufferedReader(new FileReader("C:\\Users\\Vincent\\IdeaProjects\\AlgorithmsInAction\\BlueBridgeCup\\src\\Y2017C\\C.txt"));
        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        Set<String> c = new HashSet<>();

        while (text1.readLine() != null) {
            String line = text1.readLine();
            for (String num : line.split(", ")) {
                a.add(num);
            }
        }
        while (text2.readLine() != null) {
            String line = text2.readLine();
            for (String num : line.split(", ")) {
                b.add(num);
            }
        }
        while (text3.readLine() != null) {
            String line = text3.readLine();
            for (String num : line.split(", ")) {
                c.add(num);
            }
        }
        int ans = 0;
        for (String num : a) {
            if (b.contains(num) && !c.contains(num)) {
                ans++;
            }
        }

        System.out.println(ans);

        text1.close();
        text2.close();
        text3.close();
    }
}
