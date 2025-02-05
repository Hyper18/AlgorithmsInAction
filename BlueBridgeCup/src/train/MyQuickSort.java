package train;

/**
 * @author Hyper
 * @date 2022/03/02
 */
public class MyQuickSort {
    public static int partition(int[] arr, int low, int high) {
        // set pivot
        int key = arr[low];
        // scanning
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
        // save pivot
        arr[high] = key;

        return high;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int idx = partition(arr, low, high);
        quickSort(arr, low, idx - 1);
        quickSort(arr, idx + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 12, 7, 8, 3, 4, 65, 22};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
