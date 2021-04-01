package DS.LinkedList;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 0:00 2021/3/30
 * @ Description：双向链表
 */
public class DoublelinkedListDemo {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(new DataNode(1));
        doubleLinkedList.addNode(new DataNode(7));
        doubleLinkedList.addNode(new DataNode(9));
        doubleLinkedList.addNode(new DataNode(11));
        System.out.println(doubleLinkedList.length());
        doubleLinkedList.list();
        doubleLinkedList.updateNode(new DataNode(999),3);
        doubleLinkedList.list();
        doubleLinkedList.deleteNode(new DataNode(999));
        doubleLinkedList.deleteNode(new DataNode(11));
        doubleLinkedList.list();

    }
}
class  DoubleLinkedList{
  DataNode head=new DataNode(-1);
    /*获取双向链表长度*/
    public  int length(){
        int length=0;
        DataNode temp=head.next;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    public  DataNode getHead(){
        return head;
    }
    /*遍历*/
    public  void list(){
        if (head.next==null){
            System.out.println("double  list  is  null");
            return;
        }
        DataNode temp=head.next;
        while (temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
    /*add增加节点*/
    public  void addNode(DataNode dataNode){
        DataNode temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=dataNode;
        dataNode.pre=temp;
    }
    /*add更新节点*/
    public Boolean updateNode(DataNode dataNode ,int n){
        if (n>length()){
            System.out.println("下标越界");
            return false;
        }
        DataNode temp=head.next;
        boolean flag=false;
        int m=1;
        while (true){
            if (temp==null) break;
            if (m==n){
                flag=true;
                break;
            }
            temp=temp.next;
            m++;

        }
        if (flag){
            temp.data=dataNode.data;
            return  true;
        }else {
            System.out.println("未找到此节点");
            return  false;
        }
    }
    /*add删除节点*/
    public  boolean deleteNode(DataNode dataNode){
        if (head.next==null)
        {
            System.out.println(" double  list  is null");
            return  false;
        }
        DataNode temp=head.next;
        boolean flag=false;
        int m=1;
        while (true){
            if (temp==null) break;
            if (temp.data==dataNode.data){
                flag=true;
                break;
            }
            temp=temp.next;
            m++;

        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
            return  true;
        }else {
            System.out.println("未找到此节点");
            return  false;
        }


    }
}


class  DataNode{
    public  int data;
    public  DataNode next;
    public  DataNode pre;

    public int getData() {
        return data;
    }

    public DataNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "data=" + data +
                '}';
    }
}
