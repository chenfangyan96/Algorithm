package DS;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 23:40 2021/4/6
 * @ Description：约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.playGame(1,2,5);
    }
}
class  CircleSingleList{
    private  Node first= new Node(-1);
    public  void addNode(int nums){
        if (nums<1){
            System.out.println("nums  is  not  null");
            return;
        }
        Node cur=null;
        for (int i=1;i<=nums;i++){
            Node node = new Node(i);
            if (i==1){
                first=cur=node;
                cur.setNext(first);
            }else {
                cur.setNext(node);
                cur=node;
                cur.setNext(first);
            }
        }

    }
    public  void showlist(){
        if(first==null){
            System.out.println("is  null");
        }
        Node current=first;
        while (true){
            System.out.println(current.getNo());
            if (current.getNext()==first){
                break;
            }
            current=current.getNext();
        }
    }
    public  void playGame(int num,int n,int nums){
        addNode(nums);
        Node temp=first;//辅助变量
            for (int i = 1; i < num; i++) {
                temp=temp.getNext();//指向下一节点
            }
           //找到第几个节点
            while (true){
                if (temp.getNext()==temp){
                    System.out.println(temp.getNo());
                    break;
                }
                for (int i = 1; i <=n-2; i++) {
                    temp=temp.getNext();//temp指向要删除节点的上一个节点
                }
                System.out.println(temp.getNext().getNo());
                temp.setNext(temp.getNext().getNext());
                temp=temp.getNext();
            }
    }
}
class  Node{
    private  int no;
    private Node next;
    public Node(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
