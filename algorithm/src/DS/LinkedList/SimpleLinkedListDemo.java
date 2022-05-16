package DS.LinkedList;


/*import com.sun.jmx.snmp.SnmpOid;*/

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Stack;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 12:55 2021/3/28
 * @ Description：单链表demo
 */
public class SimpleLinkedListDemo {
    public static void main(String[] args) {
        SimpleLinkList simpleLinkList = new SimpleLinkList();
        SimpleLinkList simpleLinkList2 = new SimpleLinkList();
       /* SimpleListNode chen = new SimpleListNode(1, "chen");
        simpleLinkList.addNode(chen);
        simpleLinkList.addNode(new SimpleListNode(2,"che"));
        simpleLinkList.addNode(new SimpleListNode(3,"ch"));
        simpleLinkList.addNode(new SimpleListNode(4,"c"));
        simpleLinkList.showNode();*/
      /*  SimpleListNode chen = new SimpleListNode(2, "chen");
        simpleLinkList.addNodeByOrder(chen);
        simpleLinkList.addNodeByOrder(new SimpleListNode(1, "che"));
        simpleLinkList.addNodeByOrder(new SimpleListNode(4, "ch"));
        simpleLinkList.addNodeByOrder(new SimpleListNode(3, "c"));
        simpleLinkList.showNode();
        simpleLinkList.updateNode(new SimpleListNode(3, "333333"));
        simpleLinkList.deleteNode(2);
        simpleLinkList.showNode();
        System.out.println(simpleLinkList.getLength());
        System.out.println(simpleLinkList.getLastIndexNode(3));
        //翻转s
        System.out.println("reverse");
        simpleLinkList.reverseListNode();
        simpleLinkList.showNode();
        simpleLinkList.reverseListNodePrint();*/
        simpleLinkList.addNode(new SimpleListNode(1,"3"));
        simpleLinkList.addNode(new SimpleListNode(2,"3"));
        simpleLinkList.addNode(new SimpleListNode(7,"3"));
        simpleLinkList.addNode(new SimpleListNode(9,"3"));
        simpleLinkList2.addNode(new SimpleListNode(1,"3"));
        simpleLinkList2.addNode(new SimpleListNode(4,"3"));
        simpleLinkList2.addNode(new SimpleListNode(10,"3"));
        simpleLinkList2.addNode(new SimpleListNode(14,"3"));
        simpleLinkList2.addNode(new SimpleListNode(17,"3"));

        SimpleListNode listNode = SimpleLinkList.mergeNode(simpleLinkList.getHead().next, simpleLinkList2.getHead().next);
        System.out.println(listNode.toString());


    }


}

class SimpleLinkList {
    private SimpleListNode head = new SimpleListNode(0, "");

    public void addNode(SimpleListNode listNode) {
        SimpleListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = listNode;

    }
    /*
     * @description
     * @author chen fangyan
     * @date 2021/3/28 增加节点
     * @param listNode
     * @return void
     */
    public void addNodeByOrder(SimpleListNode listNode) {
        SimpleListNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > listNode.no) {
                break;
            }
            if (temp.next.no == listNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该位置已存在");
        } else {
            listNode.next = temp.next;
            temp.next = listNode;
        }

    }

    public SimpleListNode getHead() {
        return head;
    }

    public void showNode() {
        SimpleListNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void deleteNode(int no) {
        boolean flag = false;
        SimpleListNode temp = head;
        if (head.next == null) {
            System.out.println("linklist  is  null");
            return;
        }
        while (true) {
            if (temp.next == null) {
                System.out.println(" value  is not present");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("删除成功");
        } else {
            System.out.println("不存在");
        }


    }
    public  void  updateNode(SimpleListNode node){
        boolean flag = false;
        SimpleListNode temp = head.next;
        if (temp == null) {
            System.out.println("linklist  is  null");
            return;
        }
        while (true){
            if (temp==null){
                System.out.println("不存在");
                break;
            }
            if (temp.no== node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.data= node.data;
        }else {
            System.out.println("不存在");
        }
    }
    /*
     * @description
     * @author chen fangyan
     * @date 2021/3/28 获取链表长度
     * @param
     * @return int
     */
    public  int getLength(){
        if(head.next==null){
            return 0;
        }
        SimpleListNode temp=head.next;
        int length = 0;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    /*
     * @description
     * @author chen fangyan
     * @date 2021/3/28 获取倒数第k元素的值
     * @param k
     * @return DS.LinkedList.SimpleListNode
     */
    public  SimpleListNode getLastIndexNode(int k){
        if (head.next==null)return null;
        int length = getLength();
        if (length<k||k<0){
            return null;
        }
        SimpleListNode cur = head.next;
        for (int i=0;i<length-k;i++){
            cur=cur.next;
        }
        return  cur;
    }
    /*
     * @description 
     * @author chen fangyan
     * @date 2021/3/28 逆序打印（方法一 会破坏原结构）
     * @param 
     * @return DS.LinkedList.SimpleListNode
     */
    //思路：
    //1.创建一个新的头结点  然后遍历单链表  使用头插法插入到新头结点中（新链表的最前端）
    public    void  reverseListNode(){
        SimpleListNode newHead = new SimpleListNode(0, "");
        if (head.next==null){
            return;
        }
        //定义一个辅助节点 来遍历
        //定义一个节点来保存temp节点的下一个节点
        SimpleListNode cur=head.next;
        SimpleListNode temp=null;
        while (cur!=null){
          temp=cur.next;
          //将cur节点加入到新链表的最前端
          cur.next=newHead.next;
          newHead.next=cur;
          cur=temp;
        }
        head.next=newHead.next;
    }
    /*
     * @description 
     * @author chen fangyan
     * @date 2021/3/28 逆序打印 不破坏原来结构
     * @param 
     * @return void
     */
    public    void  reverseListNodePrint(){
        Stack<Object> objects = new Stack();
        if (head.next==null||head.next.next==null){
        return;
        }
       SimpleListNode temp=head.next;
        while (temp!=null)
        {
            objects.add(temp);
            temp=temp.next;
        }
        while (objects.size()>0){
            System.out.println(objects.pop());
        }
    }
    /*
     * @description
     * @author chen fangyan
     * @date 2021/3/29 合并两个有序节点
     * @param l1
 * @param l2
     * @return DS.LinkedList.SimpleListNode
     */
    public static SimpleListNode  mergeNode (SimpleListNode l1,SimpleListNode l2){
        SimpleListNode listNode;
        if (l1==null)return l2;
        if (l2==null)return l1;
        if (l1.no<=l2.no){
            listNode=l1;
            listNode.next=mergeNode(l1.next,l2);
        }else {
            listNode=l2;
            listNode.next=mergeNode(l1,l2.next);
        }
        return  listNode;
    }
    }


class SimpleListNode {
    public int no;
    public String data;
    public SimpleListNode next;

    public SimpleListNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SimpleListNode{" +
                "no=" + no +
                ", data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
