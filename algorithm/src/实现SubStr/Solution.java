package 实现SubStr;

/**
 * @author 陈方岩
 * @date 2020/1/6 15:18
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        char[] source = haystack.toCharArray(); //目标对象
        char[] target = needle.toCharArray();//查询对象
        int sourcelength = source.length;
        int targetlength = target.length;
        //判断给定元素是否为空
        if (source.length == 0) {
            return 0;
        }
        //遍历源数组
        for (int i = 0; i < sourcelength; i++) {
            if (source[i] == target[0]) {//找到第一个匹配元素
                if (i + targetlength > sourcelength) {
                    continue;
                }
                //遍历目标字符串, 和源字符串当前索引位置的字符串开始对比 都想同则return
                for (int j = 0; j < targetlength; j++) {
                    result = i;
                    if (source[i + j] != target[j]) {
                        result = -1;
                        break;
                    }
                }
                if (result > -1) {
                    return result;
                }


            }

        }return result;
    }
}
