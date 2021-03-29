package DS.Queue;

import java.util.Arrays;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 22:00 2021/3/24
 * @ Description：手写一个队列  先进先出
 */
public class ArrayQueueDemo {
    private  int maxSize;
    private int rear;//尾部
    private   int front;//头部
    private  int []arr;
    public  ArrayQueueDemo(int maxSize){
        front=rear=-1;
        this.maxSize=maxSize;
        arr= new int[maxSize];
    }
    /*
    * 判断队列是否满*/
    public boolean isFull(){
        return  rear==maxSize-1;
    }
    private  boolean  isEmpty(){
        return rear==front;

    }
    public  void addQueue(int m){
        if (isFull()){
            System.out.println("队列满~");
            return;
        }
        arr[++rear]=m;
    }
    public void showQueue(){
        if (isEmpty()){
        System.out.println("Queue is null");
            return;
        }
        Arrays.stream(arr).boxed().forEach(n ->{
            System.out.println(n);
        });
    }
    public  int headQueue(){
        if (isEmpty()){
            System.out.println("队列是空的~~~");
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front+1];
    }
    public    int getQueue(){
        if (isEmpty()){
            System.out.println("队列是空的~~~");
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[++front];
    }

    public static void main(String[] args) {
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(3);
        arrayQueueDemo.addQueue(19);
        arrayQueueDemo.addQueue(16);
        arrayQueueDemo.addQueue(9);
        arrayQueueDemo.addQueue(5);
        arrayQueueDemo.showQueue();
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());

    }
}
