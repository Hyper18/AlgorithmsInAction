package ref;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/02/10
 */
public class R4_数据类型 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        /**
         * 字符处理
         * 1. 字符串转字符数组输出
         * 2. 读取流中的指定单个字符
         * 3. 字符输出
         */
        String str = bf.readLine();
        char[] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch));

        char c = sc.next().charAt(3);
        System.out.println(c);

        // 输出时方法重载为String入参
        System.out.println("ch: " + ch);
        // 输出时方法重载为char[]入参
        System.out.println(ch);

        /**
         * 基本类型与包装类
         * 1. 基本类型 -> 包装类
         * 2. 包装类 -> 基本类型
         * 3. 自动装箱、拆箱 JDK5+
         */
        /*
        int
         */
        int i = 233;
        Integer ie = new Integer(i);
        System.out.println(ie);
        // 必须为纯数字字符串
        Integer it = new Integer("12345");
        System.out.println(it);

        int i2 = it.intValue();
        System.out.println(i2);

        Integer it2 = it;
        System.out.println("装箱：" + it2);
        int ie2 = it;
        System.out.println("拆箱结果：" + ie2);

        /*
        String
         */
        String str2 = "233";
        int num = Integer.parseInt(str2);
        System.out.println(num);

        String str3 = "false";
        boolean fl = Boolean.parseBoolean(str3);
        System.out.println(fl);

        System.out.println(String.valueOf(i));
        System.out.println(String.valueOf(22.33));

        /**
         * 字符串
         * 1. 字符串比较
         * 2. 子串与母串匹配
         *      - 开头
         *      - 结尾
         *      - 子串出现的初始下标位置
         *      - 子串最后一次出现的下标位置
         *      - 提取子串
         * 3. 修剪 trim()
         * 4. 为null/空值
         * 5. 替换子串 replace()/replaceAll()
         * 6. 分割 split()
         * 7. 拼接 String.join() 这里注意是静态方法！！
         */
        /*
        忽略大小写
         */
        String s1 = "abcdefghijklmnopkrstuvwxyz";
        String s2 = "ABCDEFGHIJKLMNOPKRSTUVWXYZ ";
        boolean flag = s1.equalsIgnoreCase(s2);
        System.out.println(flag);

        // output: true false
        System.out.printf("%s %s\n", s1.startsWith("abc"), s2.endsWith("xyz"));
        // output: 1 19
        System.out.printf("%d %d\n", s1.indexOf("bc"), s2.lastIndexOf("TU"));
        // output: z LMN
        System.out.printf("%s %s\n", s1.substring(25), s2.substring(11, 14));

        System.out.println(s2.trim());

        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());

        /*
        替换
         */
        String sr = "abc".replace('a', 'c');
        String sr2 = "abc".replace("ab", "cd");

        // 使用正则表达式
        String sr3 = "abc".replaceAll("[bc]", ", ");

        String str4 = "abc,EF,ddd";
        str4.split(",");

        String str5 = String.join("str5", str4);

        /**
         * StringBuffer & String Builder
         * 单线程操作大量数据用StringBuilder
         * 多线程操作大量数据，用StringBuffer
         */
        StringBuilder sb = new StringBuilder();
        sb.append(12);
        sb.setCharAt(0, 'c');
        sb.insert(1, "GKD");
        System.out.println(sb);
    }
}
