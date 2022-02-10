package ref;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Hyperspace
 * @date 2022/02/10
 */
public class R3_数组 {
    public static void main(String[] args) {
        /**
         * 创建
         * 1. 声明并初始化赋值
         * 2. 声明并初始化
         */
        int[] n = {1, 2, 3, 4, 5};

        int[] nums1 = new int[10];
        int[][] nn = new int[5][3];

        /**
         * 数组复制
         * 1. clone()
         * 2. System.arraycopy()：新的数组多余的会自动补0，速度快于clone()
         * 3. Arrays.copyOf() 源码实现为System.arraycopy()套模
         * 4. Arrays.copyOfRange()
         */
        nums1 = n.clone();
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[10];
        System.arraycopy(n, 0, nums2, 0, n.length);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = Arrays.copyOf(nums2, 15);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = Arrays.copyOfRange(nums2, 1, 4);
        System.out.println(Arrays.toString(nums4));

        /**
         * 数组扩容
         * Arrays.copyOf()：同上
         */
        System.out.printf("nums1.length: %d\n", nums1.length);
        nums1 = Arrays.copyOf(nums1, nums1.length + 1);
        System.out.printf("nums1.length now: %d\n", nums1.length);

        /**
         * 数组赋值
         * Arrays.fill()
         */
        int[] arr = new int[5];
        Arrays.fill(arr, 3);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[5];
        Arrays.fill(arr2, 2, 3, 5);
        System.out.println(Arrays.toString(arr2));

        /**
         * 数组排序
         * Arrays.sort()
         * 1. 数字升序输出
         * 2. 对指定索引范围进行排序
         * 3. 数字逆序输出（使用包装类！）
         * 4. 字符串排序，大写 -> 小写顺序
         * 5. 字符串排序，字母表顺序
         * 6. 字符串排序，字母表反向顺序
         */
        System.out.println("------------数组排序---------------");

        int[] intArray = new int[]{2, 66, 13, -7, 2};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        int[] intArray2 = new int[]{2, 66, 13, -7, 2};
        Arrays.sort(intArray2, 2, intArray.length);
        System.out.println(Arrays.toString(intArray2));

        Integer[] intArray3 = new Integer[]{2, 66, 13, -7, 2};
        Arrays.sort(intArray3, Collections.reverseOrder());
        System.out.println(Arrays.toString(intArray3));

        String[] strArray = new String[]{"d", "Bc", "B", "c", "dAe"};
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));

        Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArray));

        Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(Arrays.asList(strArray));
        System.out.println(Arrays.toString(strArray));

        /**
         * 数据比较
         */
        System.out.println(Arrays.equals(intArray, intArray2));

        /**
         * 数组二分查找
         * 1. 找到元素：返回对应下标索引
         * 2. 找不到元素：返回-1减去对应的二分查找次数
         */
        System.out.println(Arrays.binarySearch(intArray, 13));
        System.out.println(Arrays.binarySearch(intArray, -1));
    }
}
