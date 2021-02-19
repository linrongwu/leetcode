package com.lrwatcl;

import java.util.Arrays;

/*
Runtime: 1 ms, faster than 99.98% of Java online submissions for Two Sum.
Memory Usage: 38.2 MB, less than 70.74% of Java online submissions for Two Sum.
*/
class TwoSumOld {
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = (int[])nums.clone();
        int[] local=new int[2];
        int m=0;
        Arrays.sort(nums);
        int length=nums.length;

        int i=0;
        int j=length-1;
        while(i<j){
            int temp = nums[i]+nums[j];
            if(temp>target){
                j--;
            }
            else if(temp<target){
                i++;
            }
            else{
                for(int n=0;n<length;n++){
                    if(newNums[n]==nums[i]||newNums[n]==nums[j]){
                        local[m]=n;
                        m++;
                    }
                }
                return local;
            }
        }
        return local;
    }
}