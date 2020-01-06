package 数组中第k大奇数;

import java.util.PriorityQueue;

/**
 * @author 陈方岩
 * @date 2019/12/26 14:11
 */
public class TestDemo1126 {


    /*
    查找数组arr中第k大的奇数,如果不存在则返回0. (arr[i] > 0 (i>=0))
    计算出时间复杂度（注意代码注释，不要使⽤库函数或脚本中已经实现好的排序算法和⼯具,
     需要⾃⼰实现数据结构和所需要的算法）
    格式
   思路：先排序  再进行便利操作
    */
    /*
    * 冒泡排序
    * */
    public static void BubbleSort(int []arr){
        int length=arr.length;
        for (int i = 0; i <length-1 ; i++) {
            for (int j = 0; j <length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static int findKth(int[] arr, int k){
        //冒泡排序（从小到大）
        BubbleSort(arr);
        //寻找第k大的奇数（要倒序遍历）
        int size =1;
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]%2==1){   //奇数
                if (size==k){   //第k大
                    return  arr[i];
                }
                size++;
            }
        }
        return 0;
    }
/*
* 创建一个容量为k的优先队列
* 只存放前k个
* */
    public static int findKth2(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]%2==1){   //奇数
                q.add(arr[i]);
            }
            if (q.size()>k){   //如果队列满了  就弹出最小元素
                q.poll();
            }
        }
        //判断队列长度是否为空或者根本不存在第k大的奇数
        if (q.size()!=k||q.size()==0){
            return 0;
        }else {
            return q.peek();
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{55,8,7,9,45,79,3,1};//55 7 9  45 79

        int kth2 = findKth2(arr,4); //55 9 45 79 3
        System.out.println(kth2);
        int kth = findKth(arr, 4);
        System.out.println(kth);
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(7);
        integers.add(1);
        integers.add(8);
        integers.add(7);
        integers.add(9);
        integers.add(15);
        integers.add(45);
        integers.add(55);
        integers.add(79);
        System.out.println(integers.peek());



    }
}
