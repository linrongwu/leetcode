package com.lrwatcl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoSum
 * @Description: TODO
 * @author: linrongwu
 * @date: 2021年02月11日 下午8:35
 */
public class TwoSum {
    /*
    * 执行用时: 7 ms
    * 内存消耗: 38.7 MB
    * */
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        int[] oldNums = nums.clone();
        Arrays.sort(nums);
        int index=0;
        while(index<nums.length-1){
            int y=index+1;
            while (y<nums.length && nums[index]+nums[y]<target){
                y++;
            }
            boolean one = false;
            boolean two = false;
            if(y<nums.length && nums[index]+nums[y]==target){
                for(int i=0;i<oldNums.length;i++){
                    if(oldNums[i]==nums[index] && !one){
                        result[0]=i;
                        one=true;
                    }
                    if(oldNums[i]==nums[y] && result[0]!=i && !two){
                        result[1]=i;
                        two=true;
                    }
                    if(one && two){
                        return result;
                    }
                }
            }
            index++;
        }
        return result;
    }

    /*
    * 执行用时: 0 ms
    * 内存消耗: 38.8 MB
    * */
    public int[] twoSumNew(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,-5};int target = -8;
        int[] result = new TwoSum().twoSum(nums,target);
        System.out.println(result[0]+":"+result[1]);
    }
}
