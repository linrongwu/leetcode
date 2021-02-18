package com.lrwatcl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: LongestSubstringWithoutRepeatingCharacters
 * @Description: TODO
 * @author: linrongwu
 * @date: 2021年02月12日 上午12:06
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    * 执行用时: 966 ms 执行用时: 8 ms
    * 内存消耗: 38.9 MB 内存消耗: 38.7 MB
    * */
    public int lengthOfLongestSubstring(String s) {
        List list = new ArrayList<Character>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(!list.contains(c)){
                list.add(c);
            }else{
                int length = list.size();
                int index = list.indexOf(c);
                list.subList(0,index+1).clear();//966ms----8ms
                list.add(c);
                max = max>length?max:length;
//                if(list.size()+s.length()-i<=max){
//                    return max;
//                }
            }
        }
        max = max>list.size()?max:list.size();
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
    }
}
