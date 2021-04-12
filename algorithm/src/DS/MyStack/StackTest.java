package DS.MyStack;

/**
 * @ Author ：Chen fangyan.
 * @ Date       ：Created in 22:29 2021/4/12
 * @ Description：
 */
public class StackTest {
    public static void main(String[] args) {
        Mystack mystack = new Mystack(5);
        mystack.push(5);
        mystack.push(4);
        mystack.push(3);
        mystack.push(2);
        mystack.push(1);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
    }
}
