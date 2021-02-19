package com.lrwatcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumOne {
    public List<List<Integer>> threeSum(int[] nums) {
        List result=new ArrayList();
        Arrays.sort(nums);
        int length = nums.length;
        int i=0;
        int j=0;
        int temp=0;
        int m=0;
        for(i=0;i<length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(j=i+1;j<length;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                temp=nums[i]+nums[j];
                m=length-1;
                while(m>j){
                    if(m<length-1&&nums[m]==nums[m+1]){
                        m--;
                        continue;
                    }
                    if(temp+nums[m]<0){
                        break;
                    }else if(temp+nums[m]>0){
                        m--;
                    }else{
                        List<Integer> then = new ArrayList<Integer>();
                        then.add(nums[i]);
                        then.add(nums[j]);
                        then.add(nums[m]);
                        result.add(then);
                        m--;
                    }
                }
            }
        }
        return result;
    }
}


class ThreeSumTwo {
    public List<List<Integer>> threeSum(int[] nums) {
    List result=new ArrayList();
    List middle=new ArrayList();
    Arrays.sort(nums);
    int length = nums.length;
    for(int i=0;i<length;i++){
        if(i>0&&nums[i]==nums[i-1]){
            continue;
        }
        for(int j=i+1;j<length;j++){
            if(j>i+1&&nums[j]==nums[j-1]){
                continue;
            }
            int temp=nums[i]+nums[j];
            int[] a={i,j,temp};
            middle.add(a);
        }
    }
    for(int i = 0 ; i < middle.size() ; i++) {
        int[] a=new int[3];
        a=(int[]) middle.get(i);
        int m=length-1;
        while(m>a[1]){
            if(m<length-1&&nums[m]==nums[m+1]){
                m--;
                continue;
            }
            int temp=a[2];
            if(temp+nums[m]<0){
                break;
            }else if(temp+nums[m]>0){
                m--;
            }else{
                List<Integer> then = new ArrayList<Integer>();
                then.add(nums[a[0]]);
                then.add(nums[a[1]]);
                then.add(nums[m]);
                result.add(then);
                m--;
            }
        }
    }
    return result;
}
}
/*
Runtime: 41 ms, faster than 60.20% of Java online submissions for 3Sum.
Memory Usage: 49 MB, less than 45.54% of Java online submissions for 3Sum.
*/
class ThreeSumThree {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List result=new ArrayList();
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int temp=0;
        int m=0;
        for(i=0;i<length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            j=i+1;
            m=length-1;
            while(m>j&&j<length-1){
                if(j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(m<length-1&&nums[m]==nums[m+1]){
                    m--;
                    continue;
                }
                if(nums[i]+nums[j]+nums[m]<0){
                    j++;
                }else if(nums[i]+nums[j]+nums[m]>0){
                    m--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[m]));
                    m--;
                    j++;
                }   
            }
        }
        return result;
    }
}
