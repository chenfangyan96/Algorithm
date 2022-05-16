package 位运算;

/**
 *  二进制打印
 *
 * @author CFY
 * @since 2022-04-04
 */

public class BinaryPrint {
    public static void  binaryPrint(int num)
    {
        System.out.println("-------------");
        //int 32位  long 64位
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num&(1 << i)) == 0 ?"0":"1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        binaryPrint(-9);//0110+1 0111
        binaryPrint(9);//1001
        binaryPrint(Integer.MAX_VALUE);
    }
}
