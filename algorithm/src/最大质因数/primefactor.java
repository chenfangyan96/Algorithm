package 最大质因数;
/**
 * @author 陈方岩
 * @date 2019/12/23 22:55
 */
public class primefactor {
     public   static int GetMaxPrime(int n) {
        int i = 2;
        int res = 1;
        while (n > 2) {
            if (n%i == 0) {
                n /= i;
                res = i;
            }
            else
                i++;
        }
        return res;
    }
    public static void primeMethod(double m){
        int start =2;
        while(start<=m){
            if(m==start){
                System.out.print(m);
                break;
            }else if(m%start ==0){
                System.out.println(start);
               m= m/start;

            }else{
                start++;
            }
        }
    }

    public static void main(String[] args) {
            primeMethod(28);
        System.out.println("-------------");
        System.out.println(GetMaxPrime(28));

    }
}
