package sort;

/**
 * 选择排序
 * 将最小一个数放在第一个位置
 *
 * @author CFY
 * @since 2022-04-04
 */

public class SelectSort {
    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void SelectSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        //0~n-1
        //1~N-1
        for (int j = 0; j < len ; j++) {
            int min = j;
            for (int i = j; i < len; i++) {
                if (arr[min] > arr[i]) {
                    swap(arr, min, i);
                }
            }
        }
        print(arr);
    }
    public static void print(int p[]){
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
    }

    public static void main(String[] args) {
        int arr[]= {6,4,3,7,9,1,5};
        SelectSort(arr);
    }
}
