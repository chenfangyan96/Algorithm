package DS.MyStack;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 22:16 2021/4/12
 * @ Description：使用数组模拟栈
 */
public class Mystack {
    private int maxSize;
    private int []stack;
    private  int top=-1;
    public Mystack(int nums){
        this.maxSize=nums;
        this.stack=new int[nums];

    }
    //判断栈是否满了
    public   Boolean isFull(){
        return  top==maxSize-1;
    }
    //判断是够为空
    public   Boolean isEmpty(){
        return  top==-1;
    }

    /*入栈*/
    public void push(int  num){
        if (isFull()){
            throw  new RuntimeException("stack  is  full");
        }
        top++;
        stack[top]=num;
    }
    public  int pop(){
        if (isEmpty()){
            throw  new RuntimeException("stack  is  Empty");
        }
        int value =stack[top];
        top--;
        return  value;
    }

}
