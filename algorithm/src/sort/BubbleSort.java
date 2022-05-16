package sort;

/**
 * 功能描述
 *
 * @author CFY
 * @since 2022-04-05
 */

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]= {6,4,3,7,9,1,5};
        bubbleSort(arr);
    }
    public  static  void bubbleSort(int arr[]){
        if (arr==null||arr.length<2){
            return;
        }
        int len=arr.length;
        for (int i = len-1; i>=0; i--) {
            for (int j = 1; j <=i ; j++) {
                if (arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }
            print(arr);
            System.out.println();
        }

    }
    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void print(int p[]){
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
    }
}
