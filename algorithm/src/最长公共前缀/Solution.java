package 最长公共前缀;

import java.util.HashMap;

/**
 * @author 陈方岩
 * @date 2020/1/10 14:00
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        //考虑边界   判断字符串数组是否为空
        if (length==0){
            return "";
        }
        //将首元素设为前缀
        String str = strs[0];
            for (int i = 1; i < length; i++) {//遍历
                //判断元素是不是以str为前缀  如果不是  则将str的length逐渐缩短  控制边界
               while (strs[i].indexOf(str)!=0){
                   str=str.substring(0,str.length()-1);
                   if (str.isEmpty()){
                       return "";
                   }
               }
            }
            return str;
        }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length==0){
            return  null;
        }
        int  i=0;
        int  j=numbers.length-1;
        while(i<j){
            if (numbers[i]+numbers[j]==target){
                return  new int[]{i+1,j+1};
            }else if(numbers[i]+numbers[j]<target){
                    i++;
            }else {
                j--;
            }
        }
        return  null;

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        if (length==0){
            return  0;
        }
        int index=0;
        int maxindex=0;
        for (int i = 0; i <length ; i++) {
            if (nums[i]==0){
                if (i==0){
                    maxindex=0;
                }else{
                    maxindex=i-index-1>maxindex?i-index-1:maxindex;
                }
                index=i;
            }
        }
        return maxindex> (nums.length-2-index)?maxindex:(nums.length-2-index);
    }

    public static void main(String[] args) {
        int maxConsecutiveOnes = new Solution().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
        System.out.println(maxConsecutiveOnes);
    }

}
