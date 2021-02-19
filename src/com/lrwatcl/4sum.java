package com.lrwatcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Runtime: 32 ms, faster than 52.09% of Java online submissions for 4Sum.
Memory Usage: 38.9 MB, less than 83.87% of Java online submissions for 4Sum.
*/
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List result=new ArrayList();
        Arrays.sort(nums);
        int length = nums.length;
        int i=0;
        int j=0;
        int temp=0;
        int m=0;
        int n=0;
        for(i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(j=i+1;j<length-2;j++){
                 if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                n=j+1;
                m=length-1;
                while(m>n){
                    if(n>j+1&&nums[n]==nums[n-1]){
                        n++;
                        continue;
                    }
                    if(m<length-1&&nums[m]==nums[m+1]){
                        m--;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[n]+nums[m]<target){
                        n++;
                    }else if(nums[i]+nums[j]+nums[n]+nums[m]>target){
                        m--;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[n],nums[m]));
                        m--;
                        n++;
                    }   
                }
            }
        }
        return result;
    }
}