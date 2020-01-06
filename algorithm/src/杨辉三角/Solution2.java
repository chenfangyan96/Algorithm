package 杨辉三角;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈方岩
 * @date 2020/1/1 12:18
 */
/*
* Question:
* 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *示例：
*输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
* 思路：
*
* 行为0
* 临界点：每一行的第一个元素为0
*   不是第一个的元素的值  为上一行的第前一个元素  和上一行同位置元素的值
*  最后一个元素的值为1
* */
public class Solution2 {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> objects = new ArrayList<>();
            if(numRows==0){
                return  objects;
            }
            ArrayList<Integer> list0 = new ArrayList<Integer>();
            list0.add(1);
            objects.add(list0);

            for (int i = 1; i <numRows ; i++) {
                ArrayList<Integer> listi = new ArrayList<Integer>();
                List<Integer> prov = objects.get(i - 1);
                listi.add(1);
                for (int j = 1; j <i ; j++) {
                    listi.add(prov.get(j)+prov.get(j-1));
                }
                listi.add(1);
                objects.add(listi);
            }
            return objects;
        }
}
