package DS.Queue;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 22:00 2021/3/24
 * @ Description：手写环形队列  先进先出
 */
public class CircleQueueDemo {
    private  int maxSize;
    private int rear;//尾部
    private   int front;//头部
    private  int []arr;
    public CircleQueueDemo(int maxSize){
        this.maxSize=maxSize;
        arr= new int[maxSize];
    }
    /*
    * 判断队列是否满*/
    public boolean isFull(){
        return  (rear+1)%maxSize==front;
    }
    private  boolean  isEmpty(){
        return rear==front;

    }
    public  void addQueue(int m){
        if (isFull()){
            System.out.println("队列满~");
            return;
        }
        arr[rear]=m;
        rear=(rear+1)%maxSize;
    }
    public void showQueue(){
        if (isEmpty()){
        System.out.println("Queue is null");
            return;
        }
        for (int i = front; i <(front+ size()); i++) {
            System.out.println(i%maxSize+"    "+arr[i%maxSize]);
        }

    }
    public  int size(){
        return  (rear+maxSize-front)%maxSize;
    }
    public  int headQueue(){
        if (isEmpty()){
            System.out.println("队列是空的~~~");
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
    public    int getQueue(){
        if (isEmpty()){
            System.out.println("队列是空的~~~");
            throw new RuntimeException("队列空的，没有数据~~");
        }
        int i = arr[front];
        front=(front+1)%maxSize;
        return i;
    }

    public static void main(String[] args) {
        CircleQueueDemo arrayQueueDemo = new CircleQueueDemo(3);
        arrayQueueDemo.addQueue(19);
        arrayQueueDemo.addQueue(16);
        arrayQueueDemo.addQueue(9);
        arrayQueueDemo.addQueue(5);
        arrayQueueDemo.showQueue();
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        arrayQueueDemo.addQueue(9);
        arrayQueueDemo.addQueue(5);
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());
        System.out.println(arrayQueueDemo.getQueue());

    }
}
