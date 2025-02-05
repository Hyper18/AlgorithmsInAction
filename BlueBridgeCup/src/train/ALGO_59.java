package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 70/100
 * 待优化，需要考虑当数组几乎完全有序时
 * 其时间复杂度接近O(n^2)
 */
public class ALGO_59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            out.println(num);
        }

        in.close();
        out.close();
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int idx = partitioning(arr, low, high);
        quickSort(arr, low, idx - 1);
        quickSort(arr, idx + 1, high);
    }

    private static int partitioning(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (arr[high] >= key && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= key && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = key;

        return high;
    }
}
