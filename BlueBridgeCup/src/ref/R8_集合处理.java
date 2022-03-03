package ref;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R8_集合处理 {
    public static void main(String[] args) {
        /**
         * List
         */
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);
        list.removeAll(list2);
        list.clear();

        list.lastIndexOf(2);
        list.indexOf(2);
        list.get(2);

        list.contains(123);
        // 交集
        list.retainAll(list2);

        list.containsAll(list2);

        // 替换
        list.set(2, 5);

        list.isEmpty();
        list.size();
        // 通过索引截取子列表
        list.subList(1, 3);

        list.equals(list2);
        list.toArray();

        /**
         * Set
         */
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();

        set.add(1);
        set.remove(1);
        set.removeAll(set2);

        set.contains(2);
        set.retainAll(set2);
        set.containsAll(set2);

        set2.isEmpty();
        set.size();
        set.equals(set2);
        set.toArray();

        /**
         * Map
         */
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map.put("key", 213);
        // 将制定map复制到此map
        map.putAll(map2);

        map.clear();
        map.remove("key");
        map.remove("key", 213);

        map.containsKey("key");
        map.containsValue(213);

        map.entrySet();
        map.keySet();
        map.values();

        map.get("key");
        map.getOrDefault("key", 123);

        // 替换：前者返回原值，后者有找到对应原值才修改
        map.replace("key", 123456);
        map.replace("key", 123456, 123);

        map.isEmpty();
        map.equals(123);
        // 若该映射尚未关联某个值，映射之
        map.putIfAbsent("key", 123);

        map.size();

        /**
         * Pair的使用
         */
        Pair<String, Integer>[] pair = new Pair[55];
        pair[0] = new Pair<>("23", 23);
        pair[1] = new Pair<>("234", 234);
        pair[2] = new Pair<>("23456", 23456);

        for (int i = 0; i < 3; i++) {
            String s = pair[i].getKey();
            System.out.println(s);
            int t = pair[i].getValue();
            System.out.println(t);
        }

    }
}
