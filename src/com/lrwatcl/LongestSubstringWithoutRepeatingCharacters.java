package com.lrwatcl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: LongestSubstringWithoutRepeatingCharacters
 * @Description: TODO
 * @author: linrongwu
 * @date: 2021��02��12�� ����12:06
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    * ִ����ʱ: 966 ms ִ����ʱ: 8 ms
    * �ڴ�����: 38.9 MB �ڴ�����: 38.7 MB
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
